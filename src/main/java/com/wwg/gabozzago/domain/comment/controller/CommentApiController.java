package com.wwg.gabozzago.domain.comment.controller;

import com.wwg.gabozzago.domain.comment.data.request.CommentRequestDto;
import com.wwg.gabozzago.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class CommentApiController {
    private final CommentService commentService;

    // 댓글 생성
    @PostMapping("/{postId}/comment")
    public ResponseEntity<?> addComment(@PathVariable Long postId, @RequestBody CommentRequestDto commentRequestDto){
        return new ResponseEntity<>(commentService.addComment(postId,commentRequestDto),HttpStatus.CREATED);
    }

    //댓글 삭제
    @DeleteMapping("/{postId}/comment/{commentId}")
    public ResponseEntity<?> delete(@PathVariable Long commentId, @PathVariable Long postId) {
        commentService.delete(commentId);
        return new ResponseEntity<>("댓글 삭제 성공!!",HttpStatus.OK);
    }
}
