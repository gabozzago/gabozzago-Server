package com.wwg.gabozzago.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private final int status;
    private final String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.status = errorCode.getStatus();
    }
}
