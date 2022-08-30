package com.wwg.gabozzago.domain.post.service;

import com.wwg.gabozzago.domain.post.dto.CreatePostRequestDto;

import javax.annotation.processing.FilerException;

public interface PostService {
     //게시물 생성
     void save(CreatePostRequestDto createPostRequestDto) throws FilerException;
     //게시물 삭제
     void delete(Long id);
}
