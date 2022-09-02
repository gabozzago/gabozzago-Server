package com.wwg.gabozzago.domain.post.service;

import com.wwg.gabozzago.domain.post.data.request.CreatePostRequestDto;

public interface PostService {
     //게시물 등록
     void save(CreatePostRequestDto createPostRequestDto);
     void delete(Long id);
}
