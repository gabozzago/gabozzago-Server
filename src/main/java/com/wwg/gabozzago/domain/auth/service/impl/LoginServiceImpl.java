package com.wwg.gabozzago.domain.auth.service.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.wwg.gabozzago.domain.auth.data.dto.LoginDto;
import com.wwg.gabozzago.domain.auth.data.dto.TokenDto;
import com.wwg.gabozzago.domain.auth.data.request.LoginRequest;
import com.wwg.gabozzago.domain.auth.service.LoginService;
import com.wwg.gabozzago.domain.auth.utils.AuthUtils;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.user.repository.UserRepository;
import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.InvalidTokenException;
import com.wwg.gabozzago.global.error.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
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
        Integer status;
        try {
            GoogleIdToken idToken = authUtils.generateIdToken(loginRequest.getIdToken());
            if (idToken == null)
                throw new InvalidTokenException(ErrorCode.INVALID_TOKEN_EXCEPTION);
            //토큰 생성
            String email = idToken.getPayload().getEmail();
            TokenDto tokenResponse = authUtils.generateTokenResponse(email);

            //유저가 존재할때
            if (userRepository.existsUserByEmail(email)) {
                User user = userRepository.findUserByEmail(email).orElseThrow(()->new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
                user.updateRefreshToken(tokenResponse.getRefreshToken());
                status = 200;
            } else { //유저가 존재하지 않을때
                status = 201;
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
