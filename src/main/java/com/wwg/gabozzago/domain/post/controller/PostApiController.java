package com.wwg.gabozzago.domain.post.controller;


import com.wwg.gabozzago.domain.likes.service.LikesService;
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
    private final LikesService likesService;
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

    //좋아요
    @PostMapping("/likes/{postId}")
    public ResponseEntity<?> likes(@PathVariable Long postId){
        likesService.likes(postId);
        return  new ResponseEntity<>("좋아여 성공",HttpStatus.OK);
    }

    @DeleteMapping("/unlikes/{postId}")
    public ResponseEntity<?> unlikes(@PathVariable Long postId){
        likesService.unlikes(postId);
        return new ResponseEntity<>("좋아여 취소 성공",HttpStatus.OK);
    }
}
