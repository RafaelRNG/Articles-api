package com.rng.articles.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date reviewTimestamp;
    private String reviewTitle;

    @Column(columnDefinition = "TEXT")
    private String reviewBody;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @ManyToOne
    private Article article;

    public Review(){}

    public Review(Long id, Date reviewTimestamp, String reviewTitle, String reviewBody, User user, Article article) {
        this.id = id;
        this.reviewTimestamp = reviewTimestamp;
        this.reviewTitle = reviewTitle;
        this.reviewBody = reviewBody;
        this.user = user;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReviewTimestamp() {
        return reviewTimestamp;
    }

    public void setReviewTimestamp(Date reviewTimestamp) {
        this.reviewTimestamp = reviewTimestamp;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
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
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return getId().equals(review.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}