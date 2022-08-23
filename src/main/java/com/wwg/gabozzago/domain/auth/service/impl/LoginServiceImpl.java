package com.wwg.gabozzago.domain.auth.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwg.gabozzago.domain.auth.dto.GoogleLoginDto;
import com.wwg.gabozzago.domain.auth.dto.request.LoginRequestDto;
import com.wwg.gabozzago.domain.auth.dto.response.LoginResponseDto;
import com.wwg.gabozzago.domain.auth.service.LoginService;
import com.wwg.gabozzago.domain.entity.User;
import com.wwg.gabozzago.domain.user.repository.UserRepository;
import com.wwg.gabozzago.global.security.JwtTokenProvider;
import com.wwg.gabozzago.global.security.properties.GoogleProperties;
import com.wwg.gabozzago.global.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final GoogleProperties googleProperties;
    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = UriComponentsBuilder.fromHttpUrl(googleProperties.getAuthUrl()+"/tokeninfo")
                            .queryParam("id_token",loginRequestDto.getIdToken()).toUriString();
        String result = restTemplate.getForObject(requestUrl, String.class);

        try {
            GoogleLoginDto userInfo = objectMapper.readValue(result, new TypeReference<GoogleLoginDto>(){});
            String accessToken = jwtTokenProvider.generateAccessToken(userInfo.getEmail());
            String refreshToken = jwtTokenProvider.generateRefreshToken(userInfo.getEmail());
            Integer accessExp = 60*15;
            Integer refreshExp = 60*60*24*7;
            Integer status;

            Optional<User> findUserInfo = userRepository.findUserByEmail(userInfo.getEmail());

            if(findUserInfo.isPresent()){
                User user = findUserInfo.orElseThrow(UserNotFoundException::new);
                user.updateRefreshToken(refreshToken);
                status = 200;
            }
            else{
                status = 201;
                User user = new User(userInfo.getEmail(),null,null,refreshToken,null);
                userRepository.save(user);
            }
            return new LoginResponseDto (accessToken,refreshToken,accessExp,refreshExp,status);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
