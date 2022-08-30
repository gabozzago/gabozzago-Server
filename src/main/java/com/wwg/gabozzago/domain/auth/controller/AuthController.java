package com.wwg.gabozzago.domain.auth.controller;

import com.wwg.gabozzago.domain.auth.data.dto.LoginDto;
import com.wwg.gabozzago.domain.auth.data.request.LoginRequest;
import com.wwg.gabozzago.domain.auth.data.response.LoginResponse;
import com.wwg.gabozzago.domain.auth.data.response.TokenResponse;
import com.wwg.gabozzago.domain.auth.service.LoginService;
import com.wwg.gabozzago.domain.auth.utils.AuthConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final LoginService loginService;
    private final AuthConverter authConverter;
    @PostMapping("/oauth")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginDto loginDto = loginService.login(loginRequest);
        LoginResponse loginResponse = authConverter.toLoginResponse(loginDto);
        TokenResponse tokenResponse = new TokenResponse(loginResponse.getTokenResponse());
        return new ResponseEntity(tokenResponse, HttpStatus.valueOf(loginResponse.getStatus()));
    }
}
