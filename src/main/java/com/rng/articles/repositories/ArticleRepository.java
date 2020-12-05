package com.rng.articles.repositories;

import com.rng.articles.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByUserId(Long id);

    @Query("SELECT u FROM Article u where lower(u.title) LIKE %:title%")
    Page<Article> search(@Param("title") String title, Pageable pageable);
}
