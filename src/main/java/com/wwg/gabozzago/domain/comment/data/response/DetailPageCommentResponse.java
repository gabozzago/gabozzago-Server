package com.wwg.gabozzago.domain.comment.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class DetailPageCommentResponse {
    private final String userName;
    private final String img;
    private final String content;
    private final LocalDateTime date;
    private final Boolean mine;

    public DetailPageCommentResponse(String name, String userImg, String content, LocalDateTime createDate, boolean mine) {
        this.userName = name;
        this.img = userImg;
        this.content = content;
        this.date = createDate;
        this.mine = mine;
    }
}
