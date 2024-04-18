package com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom methods, e.g., findByName(String name);
}