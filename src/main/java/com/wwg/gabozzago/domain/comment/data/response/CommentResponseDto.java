package com.wwg.gabozzago.domain.comment.data.response;

import com.wwg.gabozzago.domain.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String content;
    private String creatDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String userEmail;
    private Long postId;

    // Entity -> Dto
    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.creatDate = String.valueOf(comment.getCreateDate());
        this.userEmail = comment.getUser().getEmail();
        this.postId = comment.getPost().getId();
        this.content = comment.getContent();
    }
}
