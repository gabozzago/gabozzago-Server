package com.wwg.gabozzago.domain.auth.controller;

import com.wwg.gabozzago.domain.auth.dto.request.LoginRequestDto;
import com.wwg.gabozzago.domain.auth.dto.response.LoginResponseDto;
import com.wwg.gabozzago.domain.auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final LoginService loginService;
    @PostMapping("oauth")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        LoginResponseDto tokenResponseDto = loginService.login(loginRequestDto);
        return new ResponseEntity<>(tokenResponseDto, HttpStatus.valueOf(tokenResponseDto.getStatus()));
    }
}
