package com.wwg.gabozzago.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    UNAUTHORIZED(401,"Unauthorized"),
    EXPIRED_TOKEN_EXCEPTION(401,"Expired Token"),
    INVALID_TOKEN_EXCEPTION(401,"Invalid Token"),

    UNKNOWN_ERROR(500,"Unknown Error");

    private final int status;
    private final String message;
}
