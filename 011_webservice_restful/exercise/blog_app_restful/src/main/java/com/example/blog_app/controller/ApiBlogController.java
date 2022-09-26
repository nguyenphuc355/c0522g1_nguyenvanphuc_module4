package com.example.blog_app.controller;

import com.example.blog_app.model.BlogApp;
import com.example.blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blog/v1")
public class ApiBlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<BlogApp>> showBlogApp() {
        List<BlogApp> blogAppList = blogService.findAll();

        if (blogAppList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogAppList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogApp> findBlogAppById(@PathVariable int id) {
        BlogApp blogApps = blogService.findById(id);
        if (blogApps == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogApps, HttpStatus.OK);
    }
}
