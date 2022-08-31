package com.wwg.gabozzago.domain.post.service;

import com.wwg.gabozzago.domain.post.data.request.CreatePostRequestDto;

public interface PostService {
     //게시물 생성
     void save(CreatePostRequestDto createPostRequestDto);
     //게시물 삭제
     void delete(Long id);
}
