package com.wwg.gabozzago.domain.user.utils;

import com.wwg.gabozzago.domain.user.data.dto.MyPageDto;
import com.wwg.gabozzago.domain.user.data.response.MyPageResponse;

public interface UserConverter {
    MyPageResponse toMyPageResponse(MyPageDto myPageDto);

}
