package com.wwg.gabozzago.domain.like.repository;

import com.wwg.gabozzago.domain.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<PostLike, Long> {
}
