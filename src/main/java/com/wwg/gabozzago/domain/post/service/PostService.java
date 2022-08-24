package com.wwg.gabozzago.domain.post.service;

import com.wwg.gabozzago.domain.post.dto.CreatePostRequestDto;

import javax.annotation.processing.FilerException;

public interface PostService {
     //게시물 등록
     void save(CreatePostRequestDto requestDto) throws FilerException;

}
