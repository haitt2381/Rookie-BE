package com.nashtech.rookie.service;

import com.nashtech.rookie.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    Category save(Category category);
    Category deleteById(int id);
}
