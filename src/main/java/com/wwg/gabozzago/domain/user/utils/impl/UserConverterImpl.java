package com.wwg.gabozzago.domain.user.utils.impl;

import com.wwg.gabozzago.domain.user.data.dto.MyPageDto;
import com.wwg.gabozzago.domain.user.data.response.MyPageResponse;
import com.wwg.gabozzago.domain.user.utils.UserConverter;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public MyPageResponse toMyPageResponse(MyPageDto myPageDto) {
        MyPageResponse myPageResponse = new MyPageResponse(myPageDto.getName(),myPageDto.getUserImg(),myPageDto.getPostImg());
        return myPageResponse;
    }
}
