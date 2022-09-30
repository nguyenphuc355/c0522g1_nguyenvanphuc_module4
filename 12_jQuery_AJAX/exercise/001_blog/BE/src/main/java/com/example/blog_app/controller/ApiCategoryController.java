package com.example.blog_app.controller;

import com.example.blog_app.model.BlogApp;
import com.example.blog_app.model.Category;
import com.example.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category/v1")
@CrossOrigin("*")
public class ApiCategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> showCategory() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findBlogAppById(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


}
