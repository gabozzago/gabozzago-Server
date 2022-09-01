package com.wwg.gabozzago.domain.post.Exception;

import com.wwg.gabozzago.global.error.exception.ErrorCode;
import com.wwg.gabozzago.global.error.exception.GlobalException;

public class PostNotFoundException extends GlobalException {
    public PostNotFoundException() {
        super(ErrorCode.Post_Not_Found);
    }
}
