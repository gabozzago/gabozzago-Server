package com.wwg.gabozzago.domain.auth.service;

import com.wwg.gabozzago.domain.auth.dto.request.LoginRequestDto;
import com.wwg.gabozzago.domain.auth.dto.response.LoginResponseDto;

public interface LoginService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
