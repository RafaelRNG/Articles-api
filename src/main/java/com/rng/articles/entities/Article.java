package com.rng.articles.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rng.articles.entities.enums.ArticleStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String text;

    private Integer articleStatus;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Rating> ratings = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    public Article(){}

    public Article(Long id, String title, String text, ArticleStatus articleStatus, User user) {
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

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return getId().equals(article.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Article ");
        sb.append("\t title= '").append(getTitle());
        sb.append("\n \t text= '").append(getText());
        sb.append("\n \t status of your article= ").append(getArticleStatus());
        return sb.toString();
    }
}