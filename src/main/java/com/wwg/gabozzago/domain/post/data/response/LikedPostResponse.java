package com.wwg.gabozzago.domain.post.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LikedPostResponse {
    private final String userName;
    private final String userImg;
    private final String title;
    private final String location;
    private final String postImg;
    private final boolean likeStatus;
}
