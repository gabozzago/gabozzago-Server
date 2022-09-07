package com.wwg.gabozzago.domain.post.data.response;

import com.wwg.gabozzago.domain.comment.data.response.DetailPageCommentResponse;
import com.wwg.gabozzago.domain.comment.entity.Comment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class DetailPageResponse {
    private final String title;
    private final String img;
    private final String address;
    private final String description;
    private final Long likeCount;
    private final Boolean liked;
    private final List<DetailPageCommentResponse> commentList;
    private final Long commentCount;
    private final Boolean mine;
}
