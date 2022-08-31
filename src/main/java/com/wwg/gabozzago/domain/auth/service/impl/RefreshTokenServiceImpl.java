package com.wwg.gabozzago.domain.auth.service.impl;

import com.wwg.gabozzago.domain.auth.data.dto.TokenDto;
import com.wwg.gabozzago.domain.auth.service.RefreshTokenService;
import com.wwg.gabozzago.domain.auth.utils.AuthUtils;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.global.security.JwtTokenProvider;
import com.wwg.gabozzago.global.security.exception.InvalidTokenException;
import com.wwg.gabozzago.global.user.utils.userUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final JwtTokenProvider jwtTokenProvider;
    private final userUtils userUtils;
    private final AuthUtils authUtils;
    @Override
    public TokenDto refresh(String refreshToken) {
        String email = jwtTokenProvider.extractEmailFromRefreshToken(refreshToken);
        User user = userUtils.getUserByEmail(email);
        if(!refreshToken.equals(user.getRefreshToken())) throw new InvalidTokenException();
        return authUtils.generateTokenResponse(email);
    }
}
