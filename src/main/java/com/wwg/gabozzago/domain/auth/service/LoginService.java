package com.wwg.gabozzago.domain.auth.service;

import com.wwg.gabozzago.domain.auth.data.dto.LoginDto;
import com.wwg.gabozzago.domain.auth.data.request.LoginRequest;

public interface LoginService {
    LoginDto login(LoginRequest loginRequest);
}
