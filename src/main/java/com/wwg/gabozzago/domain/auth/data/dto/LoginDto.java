package com.wwg.gabozzago.domain.auth.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class LoginDto {
    private final TokenDto tokenDto;
    private final HttpStatus status;
}
