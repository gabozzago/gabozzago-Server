package com.wwg.gabozzago.global.security.exception;

import com.wwg.gabozzago.global.error.exception.ErrorCode;
import com.wwg.gabozzago.global.error.exception.GlobalException;

public class InvalidTokenException extends GlobalException{
    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN_EXCEPTION);
    }
}
