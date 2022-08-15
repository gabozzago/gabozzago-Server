package com.wwg.gabozzago.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private LocalDateTime create_Date;

    @PrePersist
    public void create_Date() {
        this.create_Date = LocalDateTime.now();
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"post_List"})
    private User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Post post;

}
