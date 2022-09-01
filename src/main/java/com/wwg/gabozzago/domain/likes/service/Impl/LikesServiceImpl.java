package com.wwg.gabozzago.domain.likes.service.Impl;

import com.wwg.gabozzago.domain.likes.entity.Likes;
import com.wwg.gabozzago.domain.likes.service.LikesService;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.post.exception.PostNotFoundException;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.likes.repository.LikesRepository;
import com.wwg.gabozzago.global.user.utils.userUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class LikesServiceImpl implements LikesService {
    private final LikesRepository likesRepository;
    private final PostRepository postRepository;
    private final userUtils userUtils;
    @Transactional
    @Override
    public void likes(Long postId) {
        User user = userUtils.getCurrentUser();
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        Likes likes = new Likes(user,post);
        likesRepository.save(likes);

    }

    @Transactional
    @Override
    public void unlikes(Long postId){
        User user = userUtils.getCurrentUser();
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        Likes likes = new Likes(user,post);
        likesRepository.deleteById(likes.getPost().getId());
    }
}
