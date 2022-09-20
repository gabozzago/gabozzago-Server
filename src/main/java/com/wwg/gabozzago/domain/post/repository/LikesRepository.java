package com.wwg.gabozzago.domain.post.repository;

import com.wwg.gabozzago.domain.post.entity.Likes;
import com.wwg.gabozzago.domain.post.entity.Post;
import com.wwg.gabozzago.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    void deleteByPostAndUser(Post post, User user);

    Optional<Likes> findByPostAndUser(Post post, User user);

    List<Likes> findByPost(Post post);
    Boolean existsByPostAndUser(User user,Post post);
}
