package com.wwg.gabozzago.global.security.exception;

import com.wwg.gabozzago.global.error.exception.ErrorCode;
import com.wwg.gabozzago.global.error.exception.GlobalException;

public class ExpiredTokenException extends GlobalException {
    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN_EXCEPTION);
    }
}
