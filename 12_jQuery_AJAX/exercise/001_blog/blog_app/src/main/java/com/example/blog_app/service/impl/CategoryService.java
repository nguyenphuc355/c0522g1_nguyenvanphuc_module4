package com.example.blog_app.service.impl;

import com.example.blog_app.model.Category;
import com.example.blog_app.repository.ICategoryRepository;
import com.example.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(int id) {
        categoryRepository.delete(categoryRepository.findById(id));
    }
}
