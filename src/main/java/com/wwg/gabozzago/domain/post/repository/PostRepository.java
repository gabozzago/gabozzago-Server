package com.wwg.gabozzago.domain.post.repository;

import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p.postImg from Post p")
    List<String> getPostImg(User userInfo);

    void deletePostsByUser(User userInfo);
    Boolean existsByUserAndUser(User user,Post post);
}
