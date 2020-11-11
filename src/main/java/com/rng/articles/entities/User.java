package com.rng.articles.entities;

import com.rng.articles.entities.enums.ContactRule;
import com.rng.articles.entities.enums.UserRole;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Integer userContactRule;

    private Integer userRole;

    public User(){}

    public User(Long id, String name, ContactRule userContactRule, UserRole userRole){
        this.id = id;
        this.name = name;
        this.userContactRule = userContactRule.getCode();
        this.userRole = userRole.getCode();
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