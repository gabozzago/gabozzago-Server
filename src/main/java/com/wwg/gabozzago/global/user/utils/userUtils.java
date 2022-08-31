package com.wwg.gabozzago.global.user.utils;


import com.wwg.gabozzago.domain.user.entity.User;

//TODO 지인호 | Java에서는 Class 이름을 Camel Case 로 작명하는것을 권장하고있어요. "UserUtils" 는 어떠신가요??
public interface userUtils {
    User getCurrentUser();
    User getUserByEmail(String email);
}
