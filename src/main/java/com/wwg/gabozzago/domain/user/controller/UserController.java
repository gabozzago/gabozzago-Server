package com.wwg.gabozzago.domain.user.controller;

import com.wwg.gabozzago.domain.user.data.dto.MyPageDto;
import com.wwg.gabozzago.domain.user.data.response.MyPageResponse;
import com.wwg.gabozzago.domain.user.service.UserService;
import com.wwg.gabozzago.domain.user.utils.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserConverter userConverter;

    @GetMapping("/mypage")
    public ResponseEntity<MyPageResponse> getMyPage(){
        MyPageDto myPageDto = userService.getMyPage();
        MyPageResponse myPageResponse =userConverter.toMyPageResponse(myPageDto);
        return new ResponseEntity<>(myPageResponse,HttpStatus.OK);
    }
}
