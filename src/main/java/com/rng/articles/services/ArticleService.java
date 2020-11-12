package com.rng.articles.services;

import com.rng.articles.entities.Article;
import com.rng.articles.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article findById(Long id){
        return articleRepository.findById(id).get();
    }
}