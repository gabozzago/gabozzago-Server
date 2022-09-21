package com.wwg.gabozzago.domain.post.controller;


import com.wwg.gabozzago.domain.post.data.request.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.data.request.FindPostRequest;
import com.wwg.gabozzago.domain.post.data.response.*;
import com.wwg.gabozzago.domain.post.service.LikesService;
import com.wwg.gabozzago.domain.post.service.PostService;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.global.user.utils.UserUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostApiController {
    private final PostService postService;
    private final LikesService likesService;
    private final UserUtils userUtils;

    public PostApiController(@Lazy PostService postService, @Lazy LikesService likesService, @Lazy UserUtils userUtils) {
        this.postService = postService;
        this.likesService = likesService;
        this.userUtils = userUtils;
    }

    //게시물 생성
    @PostMapping("/create")
    public ResponseEntity<Void> save(@RequestBody CreatePostRequestDto createPostRequestDto){
            postService.save(createPostRequestDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //게시물 수정
    @PostMapping("/edit/{postId}")
    public ResponseEntity<Void> update(@PathVariable Long postId ,@RequestBody PostUpdateResponse response) {
        postService.update(postId, response);
        return new ResponseEntity<>(HttpStatus.OK);
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

    //메인페이지
    @GetMapping
    public ResponseEntity<MainPageResponse> getMainPage(){
        MainPageResponse mainPageList = postService.getMainPage();
        return new ResponseEntity<>(mainPageList,HttpStatus.OK);
    }

    //좋아요 누른 게시물
    @GetMapping("/likes")
    public ResponseEntity<LikedPostListResponse> getLikedPostList(){
        LikedPostListResponse likedPostList = postService.getLikedPostList();
        return new ResponseEntity<>(likedPostList,HttpStatus.OK);
    }
    @GetMapping("/detail/{postId}")
    public ResponseEntity<DetailPageResponse> getDetailPage(@PathVariable Long postId){
        DetailPageResponse pageResponse = postService.getDetailPage(postId);
        return new ResponseEntity<>(pageResponse,HttpStatus.OK);
    }
    @GetMapping("find")
    public ResponseEntity<List<FindPostResponse>> getSearchPost(@RequestParam FindPostRequest findPostRequest){
        List<FindPostResponse> findPostResponse = postService.getFindPost(findPostRequest.getTitle());
        return new ResponseEntity<>(findPostResponse,HttpStatus.OK);
    }
}
