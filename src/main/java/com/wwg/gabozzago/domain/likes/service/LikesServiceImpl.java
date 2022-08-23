package com.wwg.gabozzago.domain.likes.service;

import com.wwg.gabozzago.domain.entity.User;
import com.wwg.gabozzago.domain.likes.repository.LikesRepository;
import com.wwg.gabozzago.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LikesServiceImpl implements LikesService {
    private final LikesRepository likesRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void likes(Long postId, String loginEmail) {
        User user = userRepository.findUserByEmail(loginEmail);
        likesRepository.likes(postId, user.getEmail());
    }

    @Transactional
    @Override
    public void unlikes(Long postId, String loginEmail){
        User user = userRepository.findUserByEmail(loginEmail);
        likesRepository.unlikes(postId, user.getEmail());
    }
}
