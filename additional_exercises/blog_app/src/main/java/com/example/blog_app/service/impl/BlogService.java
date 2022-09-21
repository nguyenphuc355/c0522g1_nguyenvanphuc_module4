package com.example.blog_app.service.impl;

import com.example.blog_app.dto.IBlogDto;
import com.example.blog_app.model.BlogApp;
import com.example.blog_app.repository.IBlogRepository;
import com.example.blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<BlogApp> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(BlogApp blogApp) {
        blogRepository.save(blogApp);
    }

    @Override
    public BlogApp findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void update(BlogApp blogApp) {
        blogRepository.save(blogApp);
    }

    @Override
    public void remove(int id) {
        blogRepository.delete(findById(id));
    }

    @Override
    public Page<BlogApp> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<BlogApp> findByName(Pageable pageable,String name) {
        return blogRepository.searchName(name,pageable);
    }

    @Override
    public List<IBlogDto> searchByDto() {
        return blogRepository.listByDto();
    }

}
