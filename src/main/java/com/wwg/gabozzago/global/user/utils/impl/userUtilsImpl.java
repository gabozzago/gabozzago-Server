package com.wwg.gabozzago.global.user.utils.impl;

import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.user.repository.UserRepository;
import com.wwg.gabozzago.global.user.exception.UserNotFoundException;
import com.wwg.gabozzago.global.user.utils.userUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //TODO 지인호 | Java에서는 Class 이름을 Camel Case 로 작명하는것을 권장하고있어요. "UserUtilsImpl" 은 어떠신가요??
public class userUtilsImpl implements userUtils {
    private final UserRepository userRepository;

    @Override
    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(UserNotFoundException::new);
    }
}
