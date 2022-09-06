package com.wwg.gabozzago.domain.comment.controller;

import com.wwg.gabozzago.domain.comment.data.request.CommentRequestDto;
import com.wwg.gabozzago.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentApiController {
    private final CommentService commentService;

    // 댓글 생성
    @PostMapping("/{id}")
    public ResponseEntity<?> addComment(@PathVariable Long postId, @RequestBody CommentRequestDto commentRequestDto){
        return new ResponseEntity<>(commentService.addComment(postId,commentRequestDto),HttpStatus.CREATED);
    }
}
