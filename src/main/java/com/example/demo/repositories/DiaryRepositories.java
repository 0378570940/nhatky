package com.example.demo.repositories;

import com.example.demo.entity.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepositories extends JpaRepository<DiaryEntity, Long> {
    DiaryEntity findAllById(long id);

    DiaryEntity findAllByTime(String time);

    DiaryEntity findByName(String name);
}
