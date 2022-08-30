package com.wwg.gabozzago.domain.auth.utils;

import com.wwg.gabozzago.domain.auth.data.dto.LoginDto;
import com.wwg.gabozzago.domain.auth.data.response.LoginResponse;

public interface AuthConverter {
    LoginResponse toLoginResponse(LoginDto loginDto);
}
