package com.wwg.gabozzago.domain.auth.service;

import com.wwg.gabozzago.domain.auth.data.response.TokenResponse;

public interface RefreshTokenService {
    TokenResponse refresh(String refreshToken);
}
