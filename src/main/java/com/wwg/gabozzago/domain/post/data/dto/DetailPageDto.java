package com.wwg.gabozzago.domain.post.data.dto;

import com.wwg.gabozzago.domain.comment.data.dto.DetailPageCommentDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class DetailPageDto {
    private final String title;
    private final String img;
    private final String address;
    private final String description;
    private final Long likeCount;
    private final Boolean liked;
    private final List<DetailPageCommentDto> commentList;
    private final Long commentCount;
    private final Boolean mine;
}
