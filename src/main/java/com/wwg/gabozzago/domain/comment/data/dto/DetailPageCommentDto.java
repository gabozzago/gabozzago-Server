package com.wwg.gabozzago.domain.comment.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class DetailPageCommentDto {
    private final String userName;
    private final String img;
    private final String content;
    private final LocalDateTime date;
    private final Boolean mine;
}
