package com.wwg.gabozzago.controller;


import com.wwg.gabozzago.domain.post.dto.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Controller
public class PostApiController {
    private final PostService postService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post/create")
    public void save(@Valid @ModelAttribute CreatePostRequestDto requestDto) {
        postService.save(requestDto);
    }

}
