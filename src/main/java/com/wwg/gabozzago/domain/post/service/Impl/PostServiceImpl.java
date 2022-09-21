package com.wwg.gabozzago.domain.post.service.Impl;

import com.wwg.gabozzago.domain.comment.data.response.DetailPageCommentResponse;
import com.wwg.gabozzago.domain.comment.entity.Comment;
import com.wwg.gabozzago.domain.comment.repository.CommentRepository;
import com.wwg.gabozzago.domain.post.data.request.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.data.response.*;
import com.wwg.gabozzago.domain.post.entity.Likes;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.post.repository.LikesRepository;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.PostNotFoundException;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
import com.wwg.gabozzago.domain.post.service.PostService;
import com.wwg.gabozzago.global.user.utils.UserUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserUtils userUtils;
    private final LikesRepository likesRepository;

    private final CommentRepository commentRepository;

    public PostServiceImpl(@Lazy PostRepository postRepository,@Lazy UserUtils userUtils,@Lazy LikesRepository likesRepository,@Lazy CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userUtils = userUtils;
        this.likesRepository = likesRepository;
        this.commentRepository = commentRepository;
    }
    //게시물 생성
    @Override
    @Transactional
    public void save(CreatePostRequestDto createPostRequestDto) {
        User userInfo = userUtils.getCurrentUser();
        Post post = createPostRequestDto.toEntity(userInfo);
        postRepository.save(post);
    }

    //게시물 수정
    @Override
    public void update(Long id, PostUpdateResponse dto) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new PostNotFoundException(ErrorCode.POST_NOT_FOUND));
        post.update(dto.getContent(), dto.getTitle(), dto.getPostImg());
    }

    //게시물 삭제
    @Override
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new
                PostNotFoundException(ErrorCode.POST_NOT_FOUND));
        postRepository.delete(post);

    }

    //메인 페이지
    @Override
    public MainPageResponse getMainPage() {
        List<PostResponse> postResponseList = findAllPostInfo();
        return new MainPageResponse(postResponseList);
    }

    private List<PostResponse> findAllPostInfo() {
        List<PostResponse> list = new ArrayList<>();
        User currentUser = userUtils.getCurrentUser();
        postRepository.findAll().forEach(post -> {
            Long postId = post.getId();
            String title = post.getTitle();
            String address = post.getLocation();
            String postImg = post.getPostImg();
            post.getLikesList().forEach(likes -> {
                if (Objects.equals(likes.getUser().getEmail(), currentUser.getEmail())) post.updateLikeState(true);
            });
            list.add(new PostResponse(postId, title, address, postImg, post.isLikesState()));
        });
        return list;
    }

    @Override
    public LikedPostListResponse getLikedPostList() {
        List<LikedPostResponse> likedPostResponseList = findAllLikedPostInfo();
        return new LikedPostListResponse(likedPostResponseList);
    }

    @Override
    public DetailPageResponse getDetailPage(Long id) {
        User user = userUtils.getCurrentUser();
        Post postInfo = postRepository.findById(id).orElseThrow(()->new PostNotFoundException(ErrorCode.POST_NOT_FOUND));
        List<DetailPageCommentResponse> commentList = getCommentInfo(user,postInfo);
        List<Likes> likes = likesRepository.findByPost(postInfo);
        Boolean liked = checkLiked(user,postInfo);
        Boolean mine = checkMine(user,postInfo);
        DetailPageResponse detailPageResponse = new DetailPageResponse(user,postInfo,commentList,likes,liked,mine);
        return detailPageResponse;
    }

    @Override
    public List<FindPostResponse> getFindPost(String title) {
        User user = userUtils.getCurrentUser();
        List<Post> postList = postRepository.findByTitleContaining(title);
        List<FindPostResponse> findPostResponses = new ArrayList<>();
        postList.stream().forEach(post->{
            FindPostResponse findPostResponse = new FindPostResponse(post,checkLiked(user,post));
            findPostResponses.add(findPostResponse);
        });
        return findPostResponses;
    }

    private List<LikedPostResponse> findAllLikedPostInfo() {
        List<LikedPostResponse> list = new ArrayList<>();
        User currentUser = userUtils.getCurrentUser();
        likesRepository.findAll().stream().filter(likes -> likes.getUser() == currentUser).forEach(likes -> {
            String userName = likes.getUser().getName();
            String userImg = likes.getUser().getUserImg();
            String title = likes.getPost().getTitle();
            String location = likes.getPost().getLocation();
            String postImg = likes.getPost().getPostImg();
            list.add(new LikedPostResponse(userName, userImg, title, location, postImg, true));
        });
        return list;
    }
    private List<DetailPageCommentResponse> getCommentInfo(User user,Post post){
        List<Comment> commentInfo = commentRepository.findCommentsByPost(post);
        List<DetailPageCommentResponse> list = new ArrayList<>();
        commentInfo.forEach(comment -> {
            if (comment.getUser() == user) {
                DetailPageCommentResponse commentListDto = new DetailPageCommentResponse(comment.getUser().getName(), comment.getUser().getUserImg(), comment.getContent(), comment.getCreateDate(), false);
                list.add(commentListDto);
            }
            DetailPageCommentResponse commentListDto = new DetailPageCommentResponse(comment.getUser().getName(), comment.getUser().getUserImg(), comment.getContent(), comment.getCreateDate(), true);
            list.add(commentListDto);
        });
        return list;
    }
    private Boolean checkLiked(User user,Post post){
        return likesRepository.existsByPostAndUser(post,user);
    }
    private Boolean checkMine(User user,Post post){
        return post.getUser() == user;
    }
}
