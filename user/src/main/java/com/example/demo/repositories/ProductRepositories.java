package com.example.demo.repositories;

import com.example.demo.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositories extends JpaRepository<ProductEntity, Long> {

}
