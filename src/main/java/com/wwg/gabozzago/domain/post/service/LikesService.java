package com.wwg.gabozzago.domain.post.service;

public interface LikesService {
    boolean addLike(Long postId);
    void unlikes(Long postId);


}
