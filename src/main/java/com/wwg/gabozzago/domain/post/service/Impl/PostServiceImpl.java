package com.wwg.gabozzago.domain.post.service.Impl;

import com.wwg.gabozzago.domain.post.dto.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
import com.wwg.gabozzago.domain.post.service.PostService;
import com.wwg.gabozzago.global.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.processing.FilerException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    @Transactional
    public void save(CreatePostRequestDto createPostRequestDto) throws FilerException {
        postRepository.save(createPostRequestDto.toEntity());
    }

    @Override
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(UserNotFoundException::new);
        postRepository.delete(post);

    }
}
