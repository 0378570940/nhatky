package com.example.demo.repositories;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserId(Long userId);
    UserEntity findByAdmin(String admin);

    UserEntity findAllByToken(String token);
}
