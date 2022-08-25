package com.wwg.gabozzago.domain.user.repository;

import com.wwg.gabozzago.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
