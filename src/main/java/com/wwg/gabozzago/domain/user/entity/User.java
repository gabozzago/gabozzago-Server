package com.wwg.gabozzago.domain.user.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;


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

