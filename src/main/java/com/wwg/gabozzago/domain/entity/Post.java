package com.wwg.gabozzago.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String post_img;
    private String content;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;

    @JsonIgnoreProperties({"post"})
    @OneToMany(mappedBy = "post")
    private List<PostLike> likeList;
}
