package com.wwg.gabozzago.domain.comment.service.Impl;

import com.wwg.gabozzago.domain.comment.entity.Comment;
import com.wwg.gabozzago.domain.comment.repository.CommentRepository;
import com.wwg.gabozzago.domain.comment.service.CommentService;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.user.post.repository.PostRepository;
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
    public Comment addComment(String content, Long postId) {
        User user = userUtils.getCurrentUser();
        Post post = postRepository.findById(postId).get();
        Comment comment = Comment.builder()
                .content(content)
                .post(post)
                .user(user)
                .build();

        return commentRepository.save(comment);
    }
}
