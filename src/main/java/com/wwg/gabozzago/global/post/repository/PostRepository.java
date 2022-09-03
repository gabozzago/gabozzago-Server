package com.wwg.gabozzago.global.post.repository;

import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p.postImg from Post p")
    List<String> getPostImg(User userInfo);

    void deletePostsByUser(User userInfo);
}
