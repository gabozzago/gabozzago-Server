package com.wwg.gabozzago.domain.auth.service.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.wwg.gabozzago.domain.auth.data.dto.LoginDto;
import com.wwg.gabozzago.domain.auth.data.dto.TokenDto;
import com.wwg.gabozzago.domain.auth.data.request.LoginRequest;
import com.wwg.gabozzago.domain.auth.service.LoginService;
import com.wwg.gabozzago.domain.auth.utils.AuthUtils;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.user.repository.UserRepository;
import com.wwg.gabozzago.global.security.exception.InvalidTokenException;
import com.wwg.gabozzago.global.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final AuthUtils authUtils;
    @Override
    public LoginDto login(LoginRequest loginRequest){

        HttpStatus status;
        try {
            GoogleIdToken idToken = authUtils.generateIdToken(loginRequest.getIdToken());
            if (idToken == null)
                throw new InvalidTokenException();
            //토큰 생성
            String email = idToken.getPayload().getEmail();
            TokenDto tokenResponse = authUtils.generateTokenResponse(email);

            //유저가 존재할때
            if (userRepository.existsUserByEmail(email)) {
                User user = userRepository.findUserByEmail(email).orElseThrow(UserNotFoundException::new);
                user.updateRefreshToken(tokenResponse.getRefreshToken());
                status = HttpStatus.OK;
            } else { //유저가 존재하지 않을때
                status = HttpStatus.CREATED;
                User user = new User(email, tokenResponse.getRefreshToken());
                userRepository.save(user);
            }
            return new LoginDto(tokenResponse, status);
        } catch (InvalidTokenException e) {
            throw new RuntimeException(e);
        } catch (UserNotFoundException | GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
