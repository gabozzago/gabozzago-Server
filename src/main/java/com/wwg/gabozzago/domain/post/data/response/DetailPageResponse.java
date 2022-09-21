package com.wwg.gabozzago.domain.post.data.response;

import com.wwg.gabozzago.domain.comment.data.response.DetailPageCommentResponse;
import com.wwg.gabozzago.domain.post.entity.Likes;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class DetailPageResponse {
    private final String title;
    private final String img;
    private final String address;
    private final String description;
    private final Long likeCount;
    private final Boolean liked;
    private final List<DetailPageCommentResponse> commentList;
    private final Long commentCount;
    private final Boolean mine;

    public DetailPageResponse(User user, Post postInfo, List<DetailPageCommentResponse> commentList, List<Likes> likes, Boolean liked, Boolean mine) {
        this.title = postInfo.getTitle();
        this.img = postInfo.getPostImg();
        this.address = postInfo.getLocation();
        this.description = postInfo.getContent();
        this.likeCount = likes.stream().count();
        this.liked = liked;
        this.commentList = commentList;
        this.commentCount = commentList.stream().count();
        this.mine = mine;
    }

}
