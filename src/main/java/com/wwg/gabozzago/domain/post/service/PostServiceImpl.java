package com.wwg.gabozzago.domain.post.service;

import com.wwg.gabozzago.domain.entity.Post;
import com.wwg.gabozzago.domain.post.dto.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor

public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    @Transactional
    public void save(final CreatePostRequestDto requestDto) {
        Post post = requestDto.toEntity();
    }
}
