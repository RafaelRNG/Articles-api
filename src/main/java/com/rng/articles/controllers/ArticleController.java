package com.rng.articles.controllers;

import com.rng.articles.entities.Article;
import com.rng.articles.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Article> findById(@PathVariable Long id){
        return ResponseEntity.ok(articleService.findById(id));
    }
}