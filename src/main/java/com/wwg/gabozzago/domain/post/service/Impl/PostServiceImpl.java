package com.wwg.gabozzago.domain.post.service.Impl;

import com.wwg.gabozzago.domain.post.dto.CreatePostRequestDto;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
import com.wwg.gabozzago.global.aws.service.AwsS3Service;
import com.wwg.gabozzago.domain.post.service.PostService;
import com.wwg.gabozzago.global.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final AwsS3Service awsS3Service;
    //게시물 생성
    @Override
    @Transactional
    public void save(CreatePostRequestDto createPostRequestDto){
        Post post = createPostRequestDto.toEntity();
        postRepository.save(post);
    }
    //게시물 삭제
    @Override
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(UserNotFoundException::new);
        postRepository.delete(post);

    }
}
