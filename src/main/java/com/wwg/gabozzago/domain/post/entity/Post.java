package com.wwg.gabozzago.domain.post.entity;

import com.wwg.gabozzago.domain.comment.entity.Comment;
import com.wwg.gabozzago.domain.image.entity.Img;
import com.wwg.gabozzago.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private String postImg;

    @Column(name = "content")
    private String content;

    @Transient
    @Column(name = "likes_count")
    private long likesCount;

    @Transient
    @Column(name = "likes_state")
    private boolean likesState;

    @ManyToOne()
    @OnDelete( action = OnDeleteAction.CASCADE)
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Likes> likesList;

    @OneToMany(mappedBy = "post")
    private List<Comment> commentList;

}
