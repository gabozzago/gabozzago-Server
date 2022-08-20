package com.wwg.gabozzago.domain.user.repository;

import com.wwg.gabozzago.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
