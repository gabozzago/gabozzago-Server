package com.wwg.gabozzago.domain.post.service.Impl;

import com.wwg.gabozzago.domain.post.data.request.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.PostNotFoundException;
import com.wwg.gabozzago.global.error.exception.UserNotFoundException;
import com.wwg.gabozzago.global.post.repository.PostRepository;
import com.wwg.gabozzago.domain.post.service.PostService;
import com.wwg.gabozzago.global.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserUtils userUtils;
    //게시물 생성
    @Override
    @Transactional
    public void save(CreatePostRequestDto createPostRequestDto){
        User userInfo = userUtils.getCurrentUser();
        Post post = createPostRequestDto.toEntity(userInfo);
        postRepository.save(post);
    }
    //게시물 삭제
    @Override
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new
                PostNotFoundException(ErrorCode.POST_NOT_FOUND));
        postRepository.delete(post);

    }
}
