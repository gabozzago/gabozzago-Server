package com.wwg.gabozzago.domain.auth.utils.impl;

import com.wwg.gabozzago.domain.auth.data.dto.LoginDto;
import com.wwg.gabozzago.domain.auth.data.dto.TokenDto;
import com.wwg.gabozzago.domain.auth.data.response.LoginResponse;
import com.wwg.gabozzago.domain.auth.data.response.TokenResponse;
import com.wwg.gabozzago.domain.auth.utils.AuthConverter;
import org.springframework.stereotype.Component;

@Component
public class AuthConverterImpl implements AuthConverter{
    @Override
    public LoginResponse toLoginResponse(LoginDto loginDto) {
        TokenResponse tokenResponse = toTokenResponse(loginDto.getTokenDto());
        return new LoginResponse(tokenResponse, loginDto.getStatus());
    }
    @Override
    public TokenResponse toTokenResponse(TokenDto tokenDto){
        return new TokenResponse(tokenDto.getAccessToken(), tokenDto.getRefreshToken(), tokenDto.getAccessExp(), tokenDto.getRefreshExp());
    }
}
