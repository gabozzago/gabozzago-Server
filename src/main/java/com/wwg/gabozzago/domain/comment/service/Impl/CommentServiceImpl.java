package com.wwg.gabozzago.domain.comment.service.Impl;

import com.wwg.gabozzago.domain.comment.data.request.CommentRequestDto;
import com.wwg.gabozzago.domain.comment.entity.Comment;
import com.wwg.gabozzago.domain.comment.repository.CommentRepository;
import com.wwg.gabozzago.domain.comment.service.CommentService;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.user.post.repository.PostRepository;
import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.PostNotFoundException;
import com.wwg.gabozzago.global.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserUtils userUtils;

    @Transactional
    @Override
    public Long addComment(Long postId, CommentRequestDto commentRequestDto) {
        User user = userUtils.getCurrentUser();
        Post post = postRepository.findById(postId).orElseThrow(()-> new PostNotFoundException(ErrorCode.POST_NOT_FOUND));

        commentRequestDto.setUser(user);
        commentRequestDto.setPost(post);

        Comment comment = commentRequestDto.toEntity();
        commentRepository.save(comment);

        return commentRequestDto.getId();
    }
}
