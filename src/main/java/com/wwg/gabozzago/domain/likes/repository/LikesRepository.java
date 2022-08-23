package com.wwg.gabozzago.domain.likes.repository;

import com.wwg.gabozzago.domain.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    @Modifying
    @Query(value = "INSERT INTO likes_tbl(post_id, user_id) VALUES(:postId, :userId)", nativeQuery = true)
    void likes(Long postId, String userId);

}