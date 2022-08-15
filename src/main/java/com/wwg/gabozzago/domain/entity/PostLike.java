package com.wwg.gabozzago.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PostLike {
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"post_List"})
    private User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Post post;


}
