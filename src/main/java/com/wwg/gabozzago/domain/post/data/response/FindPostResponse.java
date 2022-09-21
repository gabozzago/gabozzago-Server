package com.wwg.gabozzago.domain.post.data.response;

import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FindPostResponse {
    private final String userName;
    private final String userImg;
    private final String address;
    private final String img;
    private final Boolean liked;
    public FindPostResponse(Post post, Boolean checkLiked) {
        this.userName = post.getUser().getName();
        this.userImg = post.getUser().getUserImg();
        this.address = post.getLocation();
        this.img = post.getPostImg();
        this.liked = checkLiked;
    }
}
