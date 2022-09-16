package com.example.blog_app.service;

import com.example.blog_app.model.BlogApp;

import java.util.List;

public interface IBlogService {
    List<BlogApp> findAll();

    void save(BlogApp blogApp);

    BlogApp findById(int id);

    void update(BlogApp blogApp);

    void remove(int id);

}
