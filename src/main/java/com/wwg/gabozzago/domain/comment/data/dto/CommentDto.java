package com.wwg.gabozzago.domain.comment.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentDto {
    private final String comment;
    private final Long postId;
}
