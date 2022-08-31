package com.wwg.gabozzago.domain.user.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class MyPageResponse {
    private final String name;
    private final String userImg;
    private final List<String> postImg;
}
