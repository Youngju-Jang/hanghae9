package com.sparta.hanghaestartproject.repository;

import com.sparta.hanghaestartproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
     Optional<User> findByUsername(String username);
     
     boolean existsByUsername(String username);
     
}

