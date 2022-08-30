package com.wwg.gabozzago.domain.auth.utils.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.wwg.gabozzago.domain.auth.data.dto.TokenDto;
import com.wwg.gabozzago.domain.auth.utils.AuthUtils;
import com.wwg.gabozzago.global.security.JwtTokenProvider;
import com.wwg.gabozzago.global.security.properties.GoogleProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthUtilsImpl implements AuthUtils {
    private final JwtTokenProvider jwtTokenProvider;
    private final GoogleProperties googleProperties;


    @Override
    public TokenDto generateTokenResponse(String email) {
        String accessToken = jwtTokenProvider.generateAccessToken(email);
        String refreshToken = jwtTokenProvider.generateRefreshToken(email);
        Integer accessExp = 60 * 15;
        Integer refreshExp = 60 * 60 * 24 * 7;
        return new TokenDto(accessToken,refreshToken,accessExp,refreshExp);
    }
    public GoogleIdToken generateIdToken(String idToken) throws GeneralSecurityException, IOException {
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(googleProperties.getClientId()))
                .build();
        return verifier.verify(idToken);
    }
}
