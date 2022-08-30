package com.wwg.gabozzago.domain.post.controller;


import com.wwg.gabozzago.domain.post.dto.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.FilerException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostApiController {
    private final PostService postService;
    //게시물 생성
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void save(@RequestBody CreatePostRequestDto createPostRequestDto) throws FilerException {
            postService.save(createPostRequestDto);
    }
    //게시물 삭제
    @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable Long id){
             postService.delete(id);
    }
}
