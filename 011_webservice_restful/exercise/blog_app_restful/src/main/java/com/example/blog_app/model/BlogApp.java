package com.example.blog_app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity

public class BlogApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String creatorName;
    private String nameBlog;
    @Column(columnDefinition = "Date")
    private String dateCreated;
    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonBackReference
    private Category category;

    public BlogApp() {
    }

    public BlogApp(int id, String creatorName, String nameBlog, String dateCreated, String content) {
        this.id = id;
        this.creatorName = creatorName;
        this.nameBlog = nameBlog;
        this.dateCreated = dateCreated;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
