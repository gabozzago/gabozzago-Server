package com.wwg.gabozzago.domain.auth.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenResponseDto {
    private final String accessToken;
    private final String refreshToken;
    private final Integer accessExp;
    private final Integer refreshExp;

    public TokenResponseDto(TokenResponseDto tokenResponseDto) {
        this.accessToken = tokenResponseDto.getAccessToken();
        this.accessExp = tokenResponseDto.getAccessExp();
        this.refreshToken = tokenResponseDto.getRefreshToken();
        this.refreshExp = tokenResponseDto.getRefreshExp();
    }
}
