package com.wwg.gabozzago.global.error.exception;

import com.wwg.gabozzago.global.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentNotFoundException extends RuntimeException{
    private ErrorCode errorCode;
}
