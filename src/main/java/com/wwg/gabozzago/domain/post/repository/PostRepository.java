package com.wwg.gabozzago.domain.post.repository;

import com.wwg.gabozzago.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
