package com.wwg.gabozzago.global.error.exception;

import com.wwg.gabozzago.global.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class InvalidTokenException extends RuntimeException{
    private ErrorCode errorCode;
}
