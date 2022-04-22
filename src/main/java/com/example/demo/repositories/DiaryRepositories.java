package com.example.demo.repositories;

import com.example.demo.entity.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepositories extends JpaRepository<DiaryEntity, Long> {
    DiaryEntity findAllById(long id);

    DiaryEntity findAllByName(String name);

    DiaryEntity findByName(String name);
}
