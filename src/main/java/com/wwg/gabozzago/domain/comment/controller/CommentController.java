package com.wwg.gabozzago.domain.comment.controller;

import com.wwg.gabozzago.domain.comment.data.dto.CommentUploadDto;
import com.wwg.gabozzago.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody CommentUploadDto commentUploadDto){
        return new ResponseEntity<>(commentService.addComment(commentUploadDto.getContent(),commentUploadDto.getPostId()), HttpStatus.OK);
    }
}
