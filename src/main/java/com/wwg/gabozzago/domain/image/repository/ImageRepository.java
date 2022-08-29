package com.wwg.gabozzago.domain.image.repository;

import com.wwg.gabozzago.domain.image.entity.Img;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Img, Long> {
}
