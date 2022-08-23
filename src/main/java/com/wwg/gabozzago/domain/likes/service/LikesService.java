package com.wwg.gabozzago.domain.likes.service;

public interface LikesService {
    void likes(Long postId, String loginEmail);
    void unlikes(Long postId, String loginEmail);


}
