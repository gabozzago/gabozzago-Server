package com.wwg.gabozzago.domain.post.controller;


import com.wwg.gabozzago.domain.post.dto.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/post") //TODO 지인호 | /api/v1/post 로 rename 하는게 좋아보여요. (하위호환성을 위한 버저닝 처리)
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
