package com.rng.articles.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rng.articles.entities.enums.ContactRule;
import com.rng.articles.entities.enums.UserRole;
import com.rng.articles.entities.enums.UserStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Integer userContactRule;

    private Integer userRole;

    private Integer userAdmiredUsers;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<Article>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Rating> ratings = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    public User(){}

    public User(Long id, String name, ContactRule userContactRule, UserRole userRole, UserStatus userAdmiredUsers){
        this.id = id;
        this.name = name;
        this.userContactRule = userContactRule.getCode();
        this.userRole = userRole.getCode();
        this.userAdmiredUsers = userAdmiredUsers.getCode();
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
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}