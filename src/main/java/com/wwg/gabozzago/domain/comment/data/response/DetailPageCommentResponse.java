package com.wwg.gabozzago.domain.comment.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class DetailPageCommentResponse {
    private final String userName;
    private final String img;
    private final String content;
    private final LocalDateTime date;
    private final Boolean mine;
}
