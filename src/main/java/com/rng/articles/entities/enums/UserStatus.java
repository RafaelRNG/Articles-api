package com.rng.articles.entities.enums;

public enum UserStatus {

    PENDING(1, "PENDING"),
    ACTIVE(2, "ACTIVE"),
    INACTIVE(3, "INACTIVE");

    private Integer code;
    private String title;

    private UserStatus(Integer code, String title){
        this.code = code;
        this.title = title;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static UserStatus toEnum(Integer code){
        if(code == null) return null;

        for(UserStatus userStatus : UserStatus.values()){
            if(code.equals(userStatus.getCode())) return userStatus;
        }

        throw new IllegalArgumentException("Invalid ID" + code);
    }
}