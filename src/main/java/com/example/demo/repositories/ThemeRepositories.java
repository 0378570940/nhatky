package com.example.demo.repositories;

import com.example.demo.entity.ThemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepositories extends JpaRepository<ThemeEntity, Long> {

    ThemeEntity findAllByThemeId(long id);
}
