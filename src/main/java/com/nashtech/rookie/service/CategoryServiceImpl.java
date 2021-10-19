package com.nashtech.rookie.service;

import com.nashtech.rookie.model.Category;
import com.nashtech.rookie.repository.CategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService{
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category deleteById(int id) {
        Category category = this.findById(id);
        if(category != null){
            categoryRepository.deleteById(id);
        }
        return category;
    }
}
