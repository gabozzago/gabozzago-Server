package com.wwg.gabozzago.domain.auth.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenDto {
    private final String accessToken;
    private final String refreshToken;
    private final Integer accessExp;
    private final Integer refreshExp;
}
