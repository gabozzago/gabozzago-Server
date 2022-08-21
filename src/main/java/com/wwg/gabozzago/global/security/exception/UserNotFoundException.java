package com.wwg.gabozzago.global.security.exception;

import com.wwg.gabozzago.global.error.exception.ErrorCode;
import com.wwg.gabozzago.global.error.exception.GlobalException;

public class UserNotFoundException extends GlobalException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
