package com.wwg.gabozzago.domain.post.service.Impl;

import com.wwg.gabozzago.domain.post.data.request.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.UserNotFoundException;
import com.wwg.gabozzago.global.post.repository.PostRepository;
import com.wwg.gabozzago.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
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
}
