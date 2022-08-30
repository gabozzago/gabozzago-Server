package com.wwg.gabozzago.domain.auth.data.response;

import com.wwg.gabozzago.domain.auth.data.dto.TokenDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final Integer accessExp;
    private final Integer refreshExp;

    public TokenResponse(TokenResponse tokenResponse) {
        this.accessToken = tokenResponse.getAccessToken();
        this.accessExp = tokenResponse.getAccessExp();
        this.refreshToken = tokenResponse.getRefreshToken();
        this.refreshExp = tokenResponse.getRefreshExp();
    }
}
