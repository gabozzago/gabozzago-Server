package com.wwg.gabozzago.global.user.utils;


import com.wwg.gabozzago.domain.entity.User;

public interface userUtils {
    User getCurrentUser();
    User getUserByEmail(String email);
}
