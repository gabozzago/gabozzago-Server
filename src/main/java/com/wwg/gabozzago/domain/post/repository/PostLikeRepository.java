package com.wwg.gabozzago.domain.post.repository;

import com.wwg.gabozzago.domain.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
}
