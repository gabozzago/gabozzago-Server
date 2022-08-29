package com.wwg.gabozzago.domain.likes.service;

public interface LikesService {
    void likes(Long postId, String Email);
    void unlikes(Long postId, String Email);


}
