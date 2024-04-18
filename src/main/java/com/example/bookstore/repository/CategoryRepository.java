package com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.model.Category;

public interface CategoryRepository extends JpaRepository <Category, Long>{
    
}
