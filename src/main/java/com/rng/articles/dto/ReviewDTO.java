package com.rng.articles.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ReviewDTO {

    private Long id;
    private Date reviewTimestamp;

    @NotNull(message = "null values are not allowed")
    @NotEmpty(message = "empty values are not allowed")
    @Length(min = 5, max = 120, message = "reviewTitle between 5 and 120 characters is required")
    private String reviewTitle;

    @NotNull(message = "null values are not allowed")
    @NotEmpty(message = "empty values are not allowed")
    private String reviewBody;

    private Long user;

    private Long article;

    public ReviewDTO(Long id, Date reviewTimestamp, String reviewTitle, String reviewBody, Long user, Long article) {
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