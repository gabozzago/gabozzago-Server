package com.wwg.gabozzago.domain.post.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostUpdateResponse {
    private final String title;
    private final String content;
    private final String postImg;
}
