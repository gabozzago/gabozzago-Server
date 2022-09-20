package com.wwg.gabozzago.domain.post.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentListDto {
    private final String userName;
    private final String img;
    private final String content;
    private final String date;
    private final Boolean mine;
}
