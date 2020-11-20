package com.rng.articles.dto;

import com.rng.articles.entities.enums.ArticleStatus;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ArticleDTO {

    private Long id;

    @NotNull(message = "null values are not allowed")
    @NotEmpty(message = "empty values are not allowed")
    @Length(min = 5, max = 120, message = "title between 5 and 120 characters is required")
    private String title;

    @NotNull(message = "null values are not allowed")
    @NotEmpty(message = "empty values are not allowed")
    private String text;

    @NotNull(message = "null values are not allowed")
    private Integer articleStatus;

    @NotNull(message = "null values are not allowed")
    private Long user;

    public ArticleDTO(Long id, String title, String text, ArticleStatus articleStatus, Long user) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.articleStatus = articleStatus.getCode();
        this.user = user;
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

    public ArticleStatus getArticleStatus(){
        return ArticleStatus.toEnum(this.articleStatus);
    }

    public void setArticleStatus(ArticleStatus articleStatus){
        this.articleStatus = articleStatus.getCode();
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}