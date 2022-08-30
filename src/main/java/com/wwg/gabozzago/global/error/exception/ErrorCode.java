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
    USER_NOT_FOUND(404,"User Not Found"),

    UNKNOWN_ERROR(500,"Unknown Error"),
    Post_Not_Found(404,"Post Not Found");

    private final int status;
    private final String message;
}
