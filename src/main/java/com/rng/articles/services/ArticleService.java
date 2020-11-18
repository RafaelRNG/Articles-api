package com.rng.articles.services;

import com.rng.articles.entities.Article;
import com.rng.articles.repositories.ArticleRepository;
import com.rng.articles.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    public Page<Article> pagination(Integer page, Integer linesPerPage, String direction, String orderBy){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        return articleRepository.findAll(pageRequest);
    }

    public Article findById(Long id){
        return articleRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found, ID: " + id));
    }

    public void save(Article article){
        articleRepository.save(article);
    }

    public Article update(Long id, Article article){
        Article articleUpdate = articleRepository.findById(id).get();
        article.setId(articleUpdate.getId());
        articleRepository.save(article);

        return article;
    }

    public void deleteById(Long id){
        articleRepository.deleteById(id);
    }
}