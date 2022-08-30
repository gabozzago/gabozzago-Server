package com.wwg.gabozzago.domain.post.dto;

import com.wwg.gabozzago.domain.post.entity.Post;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequestDto {
    private String title;
    private String content;
    private String location;
    private String postImg;
    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .location(location)
                .postImg(postImg)
                .build();

    }
}
