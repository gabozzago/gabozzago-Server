package com.wwg.gabozzago.domain.post.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class LikedPostListResponse {
    private final List<LikedPostResponse> likedPostResponseList;
}
