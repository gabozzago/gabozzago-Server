package com.wwg.gabozzago.domain.user.entity;

import com.wwg.gabozzago.domain.post.entity.Post;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class User {
    @Id
    private String email;
    @Nullable()
    private String name;
    @Nullable()
    @Column(name = "user_img")
    private String userImg;

    @Column(name = "refresh_token")
    private String refreshToken;

    @OneToMany(mappedBy = "user")
    private List<Post> postList;

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
    public User(String email, String refreshToken){
        this.email = email;
        this.refreshToken = refreshToken;
        this.name = null;
        this.userImg = null;
    }
}

