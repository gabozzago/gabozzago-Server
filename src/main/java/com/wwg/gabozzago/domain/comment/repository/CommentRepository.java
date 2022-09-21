package com.wwg.gabozzago.domain.comment.repository;


import com.wwg.gabozzago.domain.comment.entity.Comment;
import com.wwg.gabozzago.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByPost(Post postInfo);
}
