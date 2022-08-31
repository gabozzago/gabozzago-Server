package com.wwg.gabozzago.domain.auth.utils;

import com.wwg.gabozzago.domain.auth.data.dto.LoginDto;
import com.wwg.gabozzago.domain.auth.data.dto.TokenDto;
import com.wwg.gabozzago.domain.auth.data.response.LoginResponse;
import com.wwg.gabozzago.domain.auth.data.response.TokenResponse;

public interface AuthConverter {
    LoginResponse toLoginResponse(LoginDto loginDto);
    TokenResponse toTokenResponse(TokenDto tokenDto);
}
