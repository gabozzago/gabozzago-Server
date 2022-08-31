package com.wwg.gabozzago.domain.auth.data.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

@Getter
public class LoginRequest {
    private final String idToken;

    @JsonCreator
    public LoginRequest(String idToken) {
        this.idToken = idToken;
    }
}
