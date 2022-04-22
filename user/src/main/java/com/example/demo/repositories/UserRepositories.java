package com.example.demo.repositories;

import com.example.demo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositories extends JpaRepository<UserEntity, Long> {
    UserEntity findUserById(long id);

    UserEntity findById(long id);

    List<UserEntity> deleteUserById(long id);

    List<UserEntity> findAll();
//        UserEntity findUserLoginInBy(String usaname);
}
