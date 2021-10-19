package com.nashtech.rookie.repository;

import com.nashtech.rookie.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
