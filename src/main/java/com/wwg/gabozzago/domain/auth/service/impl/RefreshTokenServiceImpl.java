package com.wwg.gabozzago.domain.auth.service.impl;

import com.wwg.gabozzago.domain.auth.service.RefreshTokenService;
import com.wwg.gabozzago.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final JwtTokenProvider jwtTokenProvider;


}
