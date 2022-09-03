package com.wwg.gabozzago.domain.post.data.request;

import com.wwg.gabozzago.domain.image.entity.Img;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequestDto {
    private String title;
    private String content;
    private String location;
    private String postImg;
    public Post toEntity(User userInfo) {
        return Post.builder()
                .title(title)
                .content(content)
                .location(location)
                .postImg(postImg)
                .user(userInfo)
                .build();

    }
}
