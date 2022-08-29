package com.wwg.gabozzago.domain.likes.entity;

import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.user.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Likes {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Post post;



}
