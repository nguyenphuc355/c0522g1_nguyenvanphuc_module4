package com.example.blog_app.repository;

import com.example.blog_app.model.BlogApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<BlogApp, Integer> {
    BlogApp findById(int id);
}
