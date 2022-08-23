package com.wwg.gabozzago.domain.post.service;

import com.wwg.gabozzago.domain.post.dto.CreatePostRequestDto;

public interface PostService {
    Long save(CreatePostRequestDto requestDto);

}
