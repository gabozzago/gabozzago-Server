package com.wwg.gabozzago.domain.comment.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentUploadRequest {
    private final String comment;
}
