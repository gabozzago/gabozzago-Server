package com.wwg.gabozzago.domain.comment.data.request;

import com.wwg.gabozzago.domain.comment.entity.Comment;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    private Long id;
    private String content;
    private String createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private User user;
    private Post post;

    // Dto -> Entity
    public Comment toEntity(){
        return Comment.builder()
                .id(id)
                .content(content)
                .createDate(createDate)
                .user(user)
                .post(post)
                .build();
    }
}
