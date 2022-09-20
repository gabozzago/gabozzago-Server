package com.wwg.gabozzago.domain.comment.data.request;

import com.wwg.gabozzago.domain.comment.entity.Comment;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    private String content;
    private Long postId;
}
