package com.rng.articles.dto;

import com.rng.articles.entities.enums.RatingValue;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class RatingDTO {

     private Long id;

     @NotNull(message = "null values are not allowed")
     private Integer ratingValue;
     private Date ratingTimestamp;

    private Long user;

    private Long article;

    public RatingDTO(Long id, RatingValue ratingValue, Date ratingTimestamp, Long user, Long article) {
        this.id = id;
        this.ratingValue = ratingValue.getCode();
        this.ratingTimestamp = ratingTimestamp;
        this.user = user;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RatingValue getRatingValue() {
        return RatingValue.toEnum(this.ratingValue);
    }

    public void setRatingValue(RatingValue ratingValue) {
        this.ratingValue = ratingValue.getCode();
    }


    public Date getRatingTimestamp() {
        return ratingTimestamp;
    }

    public void setRatingTimestamp(Date ratingTimestamp) {
        this.ratingTimestamp = ratingTimestamp;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getArticle() {
        return article;
    }

    public void setArticle(Long article) {
        this.article = article;
    }
}