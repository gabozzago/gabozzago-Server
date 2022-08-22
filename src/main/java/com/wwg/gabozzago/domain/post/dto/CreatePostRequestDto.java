package com.wwg.gabozzago.domain.post.dto;

import com.wwg.gabozzago.domain.entity.Post;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreatePostRequestDto {
    private String title;
    private String location;
    private String post_img;
    private String content;
    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .location(location)
                .postImg(post_img)
                .build();

    }
}
