package com.wwg.gabozzago.web;

import static org.assertj.core.api.Assertions.assertThat;

import com.wwg.gabozzago.domain.entity.Post;
import com.wwg.gabozzago.domain.post.dto.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootConfiguration

public class PostApiControllerTest {
    @Autowired
    PostRepository postRepository;

    @Test
    public void save() {
        //파라미터 생성
        Post post = Post.builder()
                .title("1번 게시글 제목")
                .content("1번 게시글 내용")
                .build();
                //게시글 저장



    }


}
