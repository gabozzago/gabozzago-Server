package com.wwg.gabozzago.global.user.utils;


import com.wwg.gabozzago.domain.user.entity.User;

public interface UserUtils {
    User getCurrentUser();
    User getUserByEmail(String email);
}
