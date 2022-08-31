package com.wwg.gabozzago.domain.auth.service.impl;

import antlr.Token;
import com.wwg.gabozzago.domain.auth.data.response.TokenResponse;
import com.wwg.gabozzago.domain.auth.service.RefreshTokenService;
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


    @Override
    public TokenResponse refresh(String refreshToken) {
        String email = jwtTokenProvider.extractEmailFromRefreshToken(refreshToken);
        User user = userUtils.getUserByEmail(email);
        if(!refreshToken.equals(user.getRefreshToken())) throw new InvalidTokenException();
        return getTokenResponseByRefreshToken(email,user);
    }
    private TokenResponse getTokenResponse(String email, User user){
        String access = jwtTokenProvider.generateAccessToken(email);
        String refresh = jwtTokenProvider.generateRefreshToken(email);
        Integer accessExp = 60 * 15;
        Integer refreshExp = 60 * 60 * 24 * 7;
        user.updateRefreshToken(refresh);

        return new TokenResponse(access,refresh,accessExp,refreshExp);
    }
    private TokenResponse getTokenResponseByRefreshToken(String email, User user){
        return getTokenResponse(email,user);
    }
}
