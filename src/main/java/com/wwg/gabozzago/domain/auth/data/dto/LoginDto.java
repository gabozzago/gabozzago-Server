package com.wwg.gabozzago.domain.auth.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginDto {
    private final TokenDto tokenDto;
    private final Integer status;
}
