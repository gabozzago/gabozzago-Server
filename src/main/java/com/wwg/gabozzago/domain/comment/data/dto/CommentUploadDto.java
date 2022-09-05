package com.wwg.gabozzago.domain.comment.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentUploadDto {
    private final String content;
    private final Long postId;
}
