package com.wwg.gabozzago.domain.post.entity;

import com.wwg.gabozzago.domain.comment.entity.Comment;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.likes.entity.Likes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String location;
    @Column(name = "post_img")
    private String postImg;

    @Column(name = "content")
    private String content;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Likes> likesList;


    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;
}
