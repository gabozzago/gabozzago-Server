package com.wwg.gabozzago.domain.comment.service;

import com.wwg.gabozzago.domain.comment.data.request.CommentRequestDto;

public interface CommentService {
    Long addComment(Long id, CommentRequestDto commentRequestDto);

    void delete(Long commentId);
}
