package com.wwg.gabozzago.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;

    @Nullable()
    private String name;
    @Nullable()
    @Column(name = "user_img")
    private String userImg;

    @Column(name = "refresh_token")
    private String refreshToken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Post> postList;

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
}
