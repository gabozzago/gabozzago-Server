package com.wwg.gabozzago.global.error.handler;

import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.ErrorResponse;
import com.wwg.gabozzago.global.error.exception.ExpiredTokenException;
import com.wwg.gabozzago.global.error.exception.InvalidTokenException;
import com.wwg.gabozzago.global.error.exception.PostNotFoundException;
import com.wwg.gabozzago.global.error.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ExpiredTokenException.class)
    public ResponseEntity<ErrorResponse> ExpiredTokenException(HttpServletRequest request,ExpiredTokenException e){
        printException(request,e.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
    }
    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorResponse> InvalidTokenException(HttpServletRequest request,InvalidTokenException e){
        printException(request,e.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(errorResponse,HttpStatus.valueOf(errorResponse.getStatus()));
    }
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorResponse> PostNotFoundException(HttpServletRequest request,PostNotFoundException e){
        printException(request,e.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> UserNotFoundException(HttpServletRequest request,UserNotFoundException e){
        printException(request,e.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?>ConstraintViolationException(ConstraintViolationException e){
        Map<String,String> errorMap = new HashMap<>();
        int i = 0;
        for(ConstraintViolation error : e.getConstraintViolations()){
            errorMap.put("error"+i,error.getMessageTemplate());
            i++;
        }
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
    public void printException(HttpServletRequest request, ErrorCode errorCode){
        log.error("URL:"+request.getRequestURI()+"errorCode:"+errorCode);
    }
}
