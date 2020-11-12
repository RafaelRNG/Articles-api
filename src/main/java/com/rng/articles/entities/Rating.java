package com.rng.articles.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rng.articles.entities.enums.RatingValue;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer ratingValue;
    private Date ratingTimestamp;

    /*
    * Futuramente criar uma lógica
    * onde avalição do usuário é feito
    * atráves do artigo em que ele postou
    * e nao feito diretamente diretamente
    */
    @ManyToOne
    private User user;

    @ManyToOne
    private Article article;

    public Rating(){}

    public Rating(Long id, RatingValue ratingValue, Date ratingTimestamp, User user, Article article) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        Rating rating = (Rating) o;
        return getId().equals(rating.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}