package com.wwg.gabozzago.domain.auth.service;

import com.wwg.gabozzago.domain.auth.data.dto.TokenDto;
import com.wwg.gabozzago.domain.auth.data.response.TokenResponse;

public interface RefreshTokenService {
    TokenDto refresh(String refreshToken);
}
