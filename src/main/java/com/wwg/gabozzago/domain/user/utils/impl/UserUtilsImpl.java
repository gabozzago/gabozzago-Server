package com.wwg.gabozzago.domain.user.utils.impl;

import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.user.repository.UserRepository;
import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.UserNotFoundException;
import com.wwg.gabozzago.global.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUtilsImpl implements UserUtils {
    private final UserRepository userRepository;

    @Override
    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(()->new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
    }
}
