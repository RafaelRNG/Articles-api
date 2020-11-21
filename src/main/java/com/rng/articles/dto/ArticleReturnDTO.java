package com.rng.articles.dto;

import com.rng.articles.entities.Review;
import com.rng.articles.entities.User;
import com.rng.articles.entities.enums.ArticleStatus;

import java.util.ArrayList;
import java.util.List;

public class ArticleReturnDTO {

    private Long id;
    private String title;
    private String text;
    private Integer articleStatus;
    private User user;

    private List<Review> reviews;

    public ArticleReturnDTO(Long id, String title, String text, ArticleStatus articleStatus, User user, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.articleStatus = articleStatus.getCode();
        this.user = user;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArticleStatus getArticleStatus(){
        return ArticleStatus.toEnum(this.articleStatus);
    }

    public void setArticleStatus(ArticleStatus articleStatus){
        this.articleStatus = articleStatus.getCode();
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}