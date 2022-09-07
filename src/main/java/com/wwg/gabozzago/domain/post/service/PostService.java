package com.wwg.gabozzago.domain.post.service;

import com.wwg.gabozzago.domain.comment.data.dto.DetailPageCommentDto;
import com.wwg.gabozzago.domain.post.data.request.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.data.response.LikedPostListResponse;
import com.wwg.gabozzago.domain.post.data.response.MainPageResponse;

public interface PostService {
     //게시물 등록
     void save(CreatePostRequestDto createPostRequestDto);
     void delete(Long id);
     //메인페이지
     MainPageResponse getMainPage();
     //좋아요 누른 게시물
     LikedPostListResponse getLikedPostList();

     DetailPageCommentDto getDetailPage(Long id);
}
