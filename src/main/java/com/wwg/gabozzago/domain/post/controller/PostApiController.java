package com.wwg.gabozzago.domain.post.controller;


import com.wwg.gabozzago.domain.post.dto.PostSaveDto;
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


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void save(@RequestBody PostSaveDto postSaveDto) throws FilerException {
            postService.save(postSaveDto);
    }

}
