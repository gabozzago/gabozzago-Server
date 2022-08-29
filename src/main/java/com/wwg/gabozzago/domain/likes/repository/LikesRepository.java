package com.wwg.gabozzago.domain.likes.repository;

import com.wwg.gabozzago.domain.likes.entity.Likes;
import com.wwg.gabozzago.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

    @Modifying
    @Query(value = "INSERT INTO likes_tbl(post_id, user_id) VALUES(:postId, :userId)", nativeQuery = true)
    void likes(Long postId, String userId);

    @Modifying
    @Query(value = "DELETE FROM likes_tbl WHERE post_id = :postId AND user_id = :userId", nativeQuery = true)
    void unlikes(Long postId, String userId);
}
