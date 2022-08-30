package com.wwg.gabozzago.domain.auth.service.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.wwg.gabozzago.domain.auth.dto.request.LoginRequestDto;
import com.wwg.gabozzago.domain.auth.dto.response.LoginResponseDto;
import com.wwg.gabozzago.domain.auth.dto.response.TokenResponseDto;
import com.wwg.gabozzago.domain.auth.service.LoginService;
import com.wwg.gabozzago.domain.auth.utils.AuthUtils;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.user.repository.UserRepository;
import com.wwg.gabozzago.global.security.exception.InvalidTokenException;
import com.wwg.gabozzago.global.user.exception.UserNotFoundException;
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
    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        Integer status;
        try {
            GoogleIdToken idToken = authUtils.generateIdToken(loginRequestDto.getIdToken());
            if (idToken == null)
                throw new InvalidTokenException();
            //토큰 생성
            String email = idToken.getPayload().getEmail();
            TokenResponseDto tokenResponseDto = authUtils.generateTokenResponse(email);

            //유저가 존재할때
            if (userRepository.existsUserByEmail(email)) {
                User user = userRepository.findUserByEmail(email).orElseThrow(UserNotFoundException::new);
                user.updateRefreshToken(tokenResponseDto.getRefreshToken());
                status = 200;
            } else { //유저가 존재하지 않을때
                status = 201;
                User user = new User(email, tokenResponseDto.getRefreshToken());
                userRepository.save(user);
            }
            return new LoginResponseDto(tokenResponseDto, status);
        } catch (InvalidTokenException e) {
            throw new RuntimeException(e);
        } catch (UserNotFoundException | GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
