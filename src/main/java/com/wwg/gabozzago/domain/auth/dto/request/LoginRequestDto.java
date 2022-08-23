package com.wwg.gabozzago.domain.auth.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@RequiredArgsConstructor
public class LoginRequestDto {
    @NotNull @NotEmpty
    private final String idToken;
}
