package com.wwg.gabozzago.domain.post.controller;


import com.wwg.gabozzago.domain.post.data.request.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostApiController {
    private final PostService postService;
    //게시물 생성
    @PostMapping("/create")
    public ResponseEntity<Void> save(@RequestBody CreatePostRequestDto createPostRequestDto){
            postService.save(createPostRequestDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //게시물 삭제
    @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void>delete(@PathVariable Long id){
             postService.delete(id);
             return new ResponseEntity<>(HttpStatus.OK);
    }
}
