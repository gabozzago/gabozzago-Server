package com.wwg.gabozzago.domain.auth.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.wwg.gabozzago.domain.auth.dto.request.LoginRequestDto;
import com.wwg.gabozzago.domain.auth.dto.response.LoginResponseDto;
import com.wwg.gabozzago.domain.auth.dto.response.TokenResponseDto;
import com.wwg.gabozzago.domain.auth.service.LoginService;
import com.wwg.gabozzago.domain.entity.User;
import com.wwg.gabozzago.domain.user.repository.UserRepository;
import com.wwg.gabozzago.global.security.JwtTokenProvider;
import com.wwg.gabozzago.global.security.exception.InvalidTokenException;
import com.wwg.gabozzago.global.security.properties.GoogleProperties;
import com.wwg.gabozzago.global.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final GoogleProperties googleProperties;
    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(googleProperties.getClientId()))
                .build();

        try {
            GoogleIdToken idToken = verifier.verify(loginRequestDto.getIdToken());
            if(idToken == null) {
                throw new InvalidTokenException();
            }
            //토큰 생성
            String email = idToken.getPayload().getEmail();
            String accessToken = jwtTokenProvider.generateAccessToken(email);
            String refreshToken = jwtTokenProvider.generateRefreshToken(email);
            Integer accessExp = 60 * 15;
            Integer refreshExp = 60 * 60 * 24 * 7;
            Integer status;

            Optional<User> findUserInfo = userRepository.findUserByEmail(email);
            //유저가 존재할때
            if (findUserInfo.isPresent()) {
                User user = findUserInfo.orElseThrow(UserNotFoundException::new);
                user.updateRefreshToken(refreshToken);
                status = 200;
            } else { //유저가 존재하지 않을때
                status = 201;
                User user = User.builder()
                        .email(email)
                        .refreshToken(refreshToken)
                        .build();
                userRepository.save(user);
            }
            return new LoginResponseDto(accessToken, refreshToken, accessExp, refreshExp, status);

        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
