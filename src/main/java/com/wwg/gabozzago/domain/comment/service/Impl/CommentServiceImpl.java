package com.wwg.gabozzago.domain.comment.service.Impl;

import com.wwg.gabozzago.domain.comment.data.request.CommentRequestDto;
import com.wwg.gabozzago.domain.comment.entity.Comment;
import com.wwg.gabozzago.domain.comment.repository.CommentRepository;
import com.wwg.gabozzago.domain.comment.service.CommentService;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.CommentNotFoundException;
import com.wwg.gabozzago.global.error.exception.PostNotFoundException;
import com.wwg.gabozzago.global.user.utils.UserUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserUtils userUtils;

    public CommentServiceImpl(@Lazy CommentRepository commentRepository,@Lazy PostRepository postRepository,@Lazy UserUtils userUtils) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userUtils = userUtils;
    }

    @Transactional
    @Override
    public Comment addComment(String content, Long postId) {
        User user = userUtils.getCurrentUser();
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(ErrorCode.POST_NOT_FOUND));

        Comment comment = Comment.builder()
                .content(content)
                .post(post)
                .user(user)
                .build();
        comment.createDate();
        return commentRepository.save(comment);
    }

    //댓글 삭제
    @Transactional
    @Override
    public void delete(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException(ErrorCode.COMMENT_NOT_FOUND));
        commentRepository.delete(comment);
    }

    //댓글 수정
    @Transactional
    @Override
    public void update(Long commentId, CommentRequestDto dto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException(ErrorCode.COMMENT_NOT_FOUND));
        comment.update(dto.getContent());
    }
}
