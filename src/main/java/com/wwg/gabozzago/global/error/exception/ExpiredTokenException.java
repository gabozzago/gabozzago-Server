package com.wwg.gabozzago.global.error.exception;

import com.wwg.gabozzago.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExpiredTokenException extends RuntimeException{
    private final ErrorCode errorCode;
}
