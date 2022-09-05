package com.wwg.gabozzago.domain.comment.service;

import com.wwg.gabozzago.domain.comment.entity.Comment;

public interface CommentService {
    Comment addComment(String comment, Long postId);
}
