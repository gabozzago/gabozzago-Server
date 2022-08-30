package com.wwg.gabozzago.domain.likes.service;

public interface LikesService {
    void likes(Long postId);
    void unlikes(Long postId);


}
