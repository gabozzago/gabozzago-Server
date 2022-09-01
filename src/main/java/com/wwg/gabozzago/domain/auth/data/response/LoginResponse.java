package com.wwg.gabozzago.domain.auth.data.response;

import com.wwg.gabozzago.domain.auth.data.dto.TokenDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class LoginResponse {
    private final TokenResponse tokenResponse;
    private final HttpStatus status;
}
