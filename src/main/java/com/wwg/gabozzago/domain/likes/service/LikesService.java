package com.wwg.gabozzago.domain.likes.service;

import org.springframework.transaction.annotation.Transactional;

public interface LikesService {
    void likes(Long postId, String email);
    void unlikes(Long postId, String email);


}
