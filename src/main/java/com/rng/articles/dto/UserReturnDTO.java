package com.rng.articles.dto;

import com.rng.articles.entities.Article;
import com.rng.articles.entities.Rating;
import com.rng.articles.entities.Review;
import com.rng.articles.entities.enums.ContactRule;
import com.rng.articles.entities.enums.UserRole;
import com.rng.articles.entities.enums.UserStatus;

import java.util.ArrayList;
import java.util.List;

public class UserReturnDTO {

    private Long id;

    private String name;

    private Integer userContactRule;

    private Integer userRole;

    private Integer userAdmiredUsers;

    private List<Article> articles;

    private List<Review> reviews;

    public UserReturnDTO(Long id, String name, ContactRule userContactRule, UserRole userRole, UserStatus userAdmiredUsers, List<Article> articles, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.userContactRule = userContactRule.getCode();
        this.userRole = userRole.getCode();
        this.userAdmiredUsers = userAdmiredUsers.getCode();
        this.articles = articles;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactRule getUserContactRule(){
        return ContactRule.toEnum(this.userContactRule);
    }

    public void setUserContactRule(ContactRule userContactRule){
        this.userContactRule = userContactRule.getCode();
    }

    public UserRole getUserRole(){
        return UserRole.toEnum(this.userRole);
    }

    public void setUserRole(UserRole userRole){
        this.userRole = userRole.getCode();
    }

    public UserStatus getUserAdmiredUsers(){
        return UserStatus.toEnum(this.userAdmiredUsers);
    }

    public void setUserAdmiredUsers(UserStatus userAdmiredUsers){
        this.userAdmiredUsers = userAdmiredUsers.getCode();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}