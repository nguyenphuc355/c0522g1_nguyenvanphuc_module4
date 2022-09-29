package com.example.blog_app.service;

import com.example.blog_app.model.BlogApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<BlogApp> findAll();

    void save(BlogApp blogApp);

    BlogApp findById(int id);

    void update(BlogApp blogApp);

    void remove(int id);

    Page<BlogApp> findAll(Pageable pageable);

    List<BlogApp> findByName(String name);
}
