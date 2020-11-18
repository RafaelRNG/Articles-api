package com.rng.articles.dto;

import com.rng.articles.entities.enums.ContactRule;
import com.rng.articles.entities.enums.UserRole;
import com.rng.articles.entities.enums.UserStatus;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDTO {

    private Long id;
    @NotNull(message = "null values are not allowed")
    @NotEmpty(message = "empty values are not allowed")
    @Length(min = 5, max = 120, message = "name between 5 and 120 characters is required")
    private String name;

    @NotNull(message = "null values are not allowed")
    private Integer userContactRule;

    @NotNull(message = "null values are not allowed")
    private Integer userRole;

    @NotNull(message = "null values are not allowed")
    private Integer userAdmiredUsers;

    public UserDTO(Long id, String name, ContactRule userContactRule, UserRole userRole, UserStatus userAdmiredUsers) {
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
}