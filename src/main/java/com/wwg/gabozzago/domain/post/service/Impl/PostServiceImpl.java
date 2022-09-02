package com.wwg.gabozzago.domain.post.service.Impl;

import com.wwg.gabozzago.domain.post.data.request.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.data.response.MainPageResponse;
import com.wwg.gabozzago.domain.post.data.response.PostResponse;
import com.wwg.gabozzago.domain.post.entity.Likes;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.post.repository.LikesRepository;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.UserNotFoundException;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
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
        Post post = createPostRequestDto.toEntity();
        postRepository.save(post);
    }
    //게시물 삭제
    @Override
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
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
}
