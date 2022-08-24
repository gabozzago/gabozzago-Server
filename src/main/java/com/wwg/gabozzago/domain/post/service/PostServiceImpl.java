package com.wwg.gabozzago.domain.post.service;

import com.wwg.gabozzago.domain.post.dto.PostSaveDto;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.processing.FilerException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    @Transactional
    public void save(PostSaveDto postSaveDto) throws FilerException {
        postRepository.save(postSaveDto.toEntity());
    }

}
