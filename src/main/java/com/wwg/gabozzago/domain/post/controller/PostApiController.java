package com.wwg.gabozzago.domain.post.controller;


import com.wwg.gabozzago.domain.likes.service.LikesService;
import com.wwg.gabozzago.domain.post.dto.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.FilerException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostApiController {
    private final PostService postService;
    private final LikesService likesService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void save(@RequestBody CreatePostRequestDto createPostRequestDto) throws FilerException {
            postService.save(createPostRequestDto);
    }

    @PostMapping("/{postId}/likes")
    public ResponseEntity<?> likes(@PathVariable Long postId){
        likesService.likes(postId);
        return new ResponseEntity<>("좋아여 성공",HttpStatus.OK);
    }

    @DeleteMapping("/{postId}/unlikes")
    public ResponseEntity<?> unlikes(@PathVariable Long postId){
        likesService.unlikes(postId);
        return new ResponseEntity<>("좋아여 취소 성공",HttpStatus.OK);
    }
}
