package com.wwg.gabozzago.domain.likes.service.Impl;

import com.wwg.gabozzago.domain.likes.service.LikesService;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.likes.repository.LikesRepository;
import com.wwg.gabozzago.domain.user.repository.UserRepository;
import com.wwg.gabozzago.global.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class  LikesServiceImpl implements LikesService {
    private final LikesRepository likesRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void likes(Long postId, String Email) {
        User user = userRepository.findUserByEmail(Email).orElseThrow(UserNotFoundException::new);
        likesRepository.likes(postId, user.getEmail());
    }

    @Transactional
    @Override
    public void unlikes(Long postId, String Email){
        User user = userRepository.findUserByEmail(Email).orElseThrow(UserNotFoundException::new);
        likesRepository.unlikes(postId, user.getEmail());
    }
}
