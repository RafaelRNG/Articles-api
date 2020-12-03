package com.rng.articles.services;

import com.rng.articles.dto.ArticleDTO;
import com.rng.articles.dto.ArticleReturnDTO;
import com.rng.articles.entities.Article;
import com.rng.articles.entities.Review;
import com.rng.articles.entities.User;
import com.rng.articles.repositories.ArticleRepository;
import com.rng.articles.repositories.ReviewRepository;
import com.rng.articles.services.exception.DataIntegratyException;
import com.rng.articles.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

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
        try {
            articleRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ObjectNotFoundException("Object not found, ID: " + id);
        }
    }

    public Article fromDTO(ArticleDTO articleDTO){
        User user = userService.findById(articleDTO.getUser());

        return new Article(articleDTO.getId(), articleDTO.getTitle(), articleDTO.getText(), articleDTO.getArticleStatus(), user);
    }

    public ArticleReturnDTO fromReturnDTO(Long id) {
        List<Review> reviews = reviewRepository.findByArticleId(id);

        Article article = articleRepository.findById(id).get();

        return new ArticleReturnDTO(
                article.getId(),
                article.getTitle(),
                article.getText(),
                article.getArticleStatus(),
                article.getUser(),
                reviews);
    }
}