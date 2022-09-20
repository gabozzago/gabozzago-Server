package com.wwg.gabozzago.domain.comment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime createDate;
    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
    @ManyToOne()
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne()
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    public void update(String content) {
        this.content = content;
    }
}
