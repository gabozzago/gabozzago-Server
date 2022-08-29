package com.wwg.gabozzago.domain.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

@Getter
public class LoginRequestDto {
    private final String idToken;

    @JsonCreator
    public LoginRequestDto(String idToken) {
        this.idToken = idToken;
    }
}
