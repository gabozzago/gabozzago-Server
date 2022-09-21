package com.wwg.gabozzago.domain.post.service.Impl;

import com.wwg.gabozzago.domain.post.entity.Likes;
import com.wwg.gabozzago.domain.post.service.LikesService;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.post.repository.LikesRepository;
import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.PostNotFoundException;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
import com.wwg.gabozzago.global.user.utils.UserUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikesServiceImpl implements LikesService {
    private final LikesRepository likesRepository;
    private final UserUtils userUtils;
    private final PostRepository postRepository;

    public LikesServiceImpl(@Lazy LikesRepository likesRepository,@Lazy UserUtils userUtils,@Lazy PostRepository postRepository) {
        this.likesRepository = likesRepository;
        this.userUtils = userUtils;
        this.postRepository = postRepository;
    }

    @Transactional
    @Override
    public boolean addLike(Long postId) {
        User user = userUtils.getCurrentUser();
        Post post = postRepository.findById(postId).orElseThrow(()-> new PostNotFoundException(ErrorCode.POST_NOT_FOUND));

        // 중복 좋아요 방지
        if(isNotAlreadyLike(post)) {
            likesRepository.save(new Likes(user, post));
            return true;
        }
        return false;
    }

    //사용자가 이미 좋아요 한 게시물인지 체크
    private boolean isNotAlreadyLike(Post post) {
        User user = userUtils.getCurrentUser();
        return likesRepository.findByPostAndUser(post, user).isEmpty();
    }

    //좋아요 취소
    @Transactional
    @Override
    public void unlikes(Long postId){
        User user = userUtils.getCurrentUser();
        Post post = postRepository.findById(postId).orElseThrow(()-> new PostNotFoundException(ErrorCode.POST_NOT_FOUND));
        likesRepository.deleteByPostAndUser(post, user);
    }
}
