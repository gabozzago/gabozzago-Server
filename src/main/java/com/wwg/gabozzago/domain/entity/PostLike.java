package com.wwg.gabozzago.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class PostLike {
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Post post;


}
