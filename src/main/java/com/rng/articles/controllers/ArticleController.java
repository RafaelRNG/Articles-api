package com.rng.articles.controllers;

import com.rng.articles.dto.ArticleDTO;
import com.rng.articles.dto.ArticleReturnDTO;
import com.rng.articles.entities.Article;
import com.rng.articles.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> findAll(){
        return ResponseEntity.ok(articleService.findAll());
    }

    @GetMapping(path = "/page")
    public ResponseEntity<Page<Article>> pagination(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction,
            @RequestParam(name = "orderBy", defaultValue = "title") String orderBy){

         return ResponseEntity.ok(articleService.pagination(page, linesPerPage, direction, orderBy));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ArticleReturnDTO> findById(@PathVariable Long id){
        Article article = articleService.findById(id);


        return ResponseEntity.ok(articleService.fromReturnDTO(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ArticleDTO articleDTO){
        Article article = articleService.fromDTO(articleDTO);

        articleService.save(article);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(article.getId()).toUri()).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @Valid @RequestBody ArticleDTO articleDTO){
        Article article = articleService.fromDTO(articleDTO);

        articleService.update(id, article);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        articleService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}