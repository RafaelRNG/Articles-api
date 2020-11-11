package com.rng.articles.entities.enums;

public enum UserRole {
    ADMIN(1, "ADMIN"),
    ARTICLE_SUBMITTER(2, "ARTICLE_SUBMITTER"),
    ARTICLE_REVIEWER(3, "ARTICLE_REVIEWER");

    private Integer code;
    private String title;

    private UserRole(Integer code, String title){
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

    public static UserRole toEnum(Integer code){
        if(code == null) return null;

        for(UserRole userRole : UserRole.values()){
            if(code.equals(userRole.getCode())) return userRole;
        }
        throw new IllegalArgumentException("Invalid ID " + code);
    }
}
