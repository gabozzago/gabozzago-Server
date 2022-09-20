package com.wwg.gabozzago.domain.comment.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public class DetailPageCommentResponse {
    private final String userName;
    private final String img;
    private final String content;
    private final String date;
    private final Boolean mine;
}
