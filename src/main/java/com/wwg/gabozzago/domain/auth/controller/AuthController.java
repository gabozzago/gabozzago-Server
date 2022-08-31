package com.wwg.gabozzago.domain.auth.controller;

import com.wwg.gabozzago.domain.auth.data.dto.LoginDto;
import com.wwg.gabozzago.domain.auth.data.dto.TokenDto;
import com.wwg.gabozzago.domain.auth.data.request.LoginRequest;
import com.wwg.gabozzago.domain.auth.data.response.LoginResponse;
import com.wwg.gabozzago.domain.auth.data.response.TokenResponse;
import com.wwg.gabozzago.domain.auth.service.LoginService;
import com.wwg.gabozzago.domain.auth.service.RefreshTokenService;
import com.wwg.gabozzago.domain.auth.utils.AuthConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final LoginService loginService;
    private final AuthConverter authConverter;
    private final RefreshTokenService refreshTokenService;
    @PostMapping("/oauth")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginDto loginDto = loginService.login(loginRequest);
        LoginResponse loginResponse = authConverter.toLoginResponse(loginDto);
        TokenResponse tokenResponse = new TokenResponse(loginResponse.getTokenResponse());
        return new ResponseEntity(tokenResponse, HttpStatus.valueOf(loginResponse.getStatus()));
    }

    @PutMapping("/refresh")
    public ResponseEntity<TokenResponse>refresh(@RequestHeader("Refresh-Token") String refreshToken){
        TokenDto tokenDto = refreshTokenService.refresh(refreshToken);
        TokenResponse tokenResponse = authConverter.toTokenResponse(tokenDto);
        return new ResponseEntity<>(tokenResponse,HttpStatus.OK);
    }

}
