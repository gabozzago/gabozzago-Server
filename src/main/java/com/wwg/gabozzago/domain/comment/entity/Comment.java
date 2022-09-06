package com.wwg.gabozzago.domain.comment.entity;

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
    @CreatedDate
    private String createDate;

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

}
