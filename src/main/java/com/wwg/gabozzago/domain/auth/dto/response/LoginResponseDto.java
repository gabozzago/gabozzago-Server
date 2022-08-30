package com.wwg.gabozzago.domain.auth.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginResponseDto {
    private final TokenResponseDto tokenResponseDto;
    private final Integer status;
}
