package com.wwg.gabozzago.domain.post.Dto;

import com.wwg.gabozzago.domain.entity.Post;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PostDto {
    private String title;
    private String location;
    private String post_img;
    private String content;
}
