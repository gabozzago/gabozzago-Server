package com.wwg.gabozzago.domain.comment.repository;


import com.wwg.gabozzago.domain.comment.entity.Comment;
import com.wwg.gabozzago.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentsByPostInfo(Post postInfo);
}
