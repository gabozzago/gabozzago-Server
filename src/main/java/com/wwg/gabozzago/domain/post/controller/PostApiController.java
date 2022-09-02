package com.wwg.gabozzago.domain.post.controller;


import com.wwg.gabozzago.domain.post.data.request.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.service.LikesService;
import com.wwg.gabozzago.domain.post.service.PostService;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.global.user.utils.UserUtils;
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
    private final UserUtils userUtils;
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
    public ResponseEntity<?> addLike(@PathVariable Long postId){
        User user = userUtils.getCurrentUser();
        boolean result = false;

        if (user != null){
            result = likesService.addLike(postId);
        }
        return result ?
                new ResponseEntity<>("좋아요 성공",HttpStatus.OK) : new ResponseEntity<>("좋아요 중복으로 인한 실패!!",HttpStatus.BAD_REQUEST);
    }

    //좋아요 취소
    @DeleteMapping("/unlikes/{postId}")
    public ResponseEntity<?> unlikes(@PathVariable Long postId){
        likesService.unlikes(postId);
        return new ResponseEntity<>("좋아여 취소 성공",HttpStatus.OK);
    }
}
