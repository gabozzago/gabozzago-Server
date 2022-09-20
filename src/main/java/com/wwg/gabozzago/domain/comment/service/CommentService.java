package com.wwg.gabozzago.domain.comment.service;

import com.wwg.gabozzago.domain.comment.data.request.CommentRequestDto;
import com.wwg.gabozzago.domain.comment.entity.Comment;

public interface CommentService {
    Comment addComment(String content, Long postId);

    void delete(Long commentId);

    void update(Long commentId, CommentRequestDto dto);
}
