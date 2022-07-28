package com.wwg.gabozzago.domain.entity;

import lombok.*;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;
    private String name;
    private String password;
    private String user_img;
}
