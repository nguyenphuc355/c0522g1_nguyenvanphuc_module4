package com.example.blog_app.repository;

import com.example.blog_app.dto.IBlogDto;
import com.example.blog_app.model.BlogApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<BlogApp, Integer> {
    BlogApp findById(int id);

    @Query(value = "select * from blog_app where name_blog like %:name%", nativeQuery = true)
    Page<BlogApp> searchName(@Param("name") String name, Pageable pageable);

    @Query(value = "select * from blog_app order by date_created ", nativeQuery = true)
    Page<BlogApp> findAll(Pageable pageable);

    @Query(value = "SELECT b.name_blog as blogName, c.name as categoryName " +
            "FROM blog_app b join category c" +
            " on b.category_id = c.id", nativeQuery = true)
    List<IBlogDto> listByDto();
}
