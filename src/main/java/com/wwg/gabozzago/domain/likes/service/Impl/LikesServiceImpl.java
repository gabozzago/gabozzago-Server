package com.wwg.gabozzago.domain.likes.service.Impl;

import com.wwg.gabozzago.domain.likes.service.LikesService;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.likes.repository.LikesRepository;
import com.wwg.gabozzago.domain.user.repository.UserRepository;
import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class LikesServiceImpl implements LikesService {
    private final LikesRepository likesRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void likes(Long postId, String Email) {
        User user = userRepository.findUserByEmail(Email).orElseThrow(()->new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
        likesRepository.likes(postId, user.getEmail());
    }

    @Transactional
    @Override
    public void unlikes(Long postId, String Email){
        User user = userRepository.findUserByEmail(Email).orElseThrow(()->new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
        likesRepository.unlikes(postId, user.getEmail());
    }
}
