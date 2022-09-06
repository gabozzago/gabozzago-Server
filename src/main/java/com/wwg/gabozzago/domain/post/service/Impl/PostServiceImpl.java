package com.wwg.gabozzago.domain.post.service.Impl;

import com.wwg.gabozzago.domain.post.data.request.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.data.response.*;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.post.repository.LikesRepository;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.global.aws.service.AwsS3Service;
import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.PostNotFoundException;
import com.wwg.gabozzago.domain.user.post.repository.PostRepository;
import com.wwg.gabozzago.domain.post.service.PostService;
import com.wwg.gabozzago.global.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserUtils userUtils;
    private final LikesRepository likesRepository;
    //게시물 생성
    @Override
    @Transactional
    public void save(CreatePostRequestDto createPostRequestDto){
        User userInfo = userUtils.getCurrentUser();
        Post post = createPostRequestDto.toEntity(userInfo);
        postRepository.save(post);
    }
    //게시물 수정
    @Override
    public void update(Long id, PostUpdateResponse postUpdateResponse) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new PostNotFoundException(ErrorCode.POST_NOT_FOUND));
                postRepository.update(post);
    }

    //게시물 삭제
    @Override
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new
                PostNotFoundException(ErrorCode.POST_NOT_FOUND));
            postRepository.delete(post);
    }

    //메인 페이지
    @Override
    public MainPageResponse getMainPage(){
        List<PostResponse> postResponseList = findAllPostInfo();
        return new MainPageResponse(postResponseList);
    }
    private List<PostResponse> findAllPostInfo(){
        List<PostResponse> list = new ArrayList<>();
        User currentUser = userUtils.getCurrentUser();
        postRepository.findAll().forEach(post -> {
            Long postId = post.getId();
            String title = post.getTitle();
            String address = post.getLocation();
            String postImg = post.getPostImg();
            post.getLikesList().forEach(likes -> {
                if(Objects.equals(likes.getUser().getEmail(), currentUser.getEmail())) post.updateLikeState(true);
            });
            list.add(new PostResponse(postId,title,address,postImg,post.isLikesState()));
       });
        return list;
    }

    @Override
    public LikedPostListResponse getLikedPostList(){
        List<LikedPostResponse> likedPostResponseList = findAllLikedPostInfo();
        return new LikedPostListResponse(likedPostResponseList);
    }

    private List<LikedPostResponse> findAllLikedPostInfo() {
        List<LikedPostResponse> list = new ArrayList<>();
        User currentUser = userUtils.getCurrentUser();
        likesRepository.findAll().forEach(likes -> {
            if(likes.getUser() == currentUser){
                String userName = likes.getUser().getName();
                String userImg = likes.getUser().getUserImg();
                String title = likes.getPost().getTitle();
                String location = likes.getPost().getLocation();
                String postImg = likes.getPost().getPostImg();
                list.add(new LikedPostResponse(userName,userImg,title,location,postImg,true));
            }
        });
        return list;
    }
}
