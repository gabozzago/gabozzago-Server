package com.wwg.gabozzago.domain.comment.entity;

import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Post post;

}
