package com.wwg.gabozzago.web;


import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)


public class PostApiControllerTest {
    @Autowired
    PostRepository postRepository;

    @Test @DisplayName("포스트 저장 성공테스트")
    public void save() {
        //파라미터 생성
        Post post = Post.builder()
                .title("1번 게시글 제목")
                .content("1번 게시글 내용")
                .build();

                //게시글 저장



    }


}
