package com.rng.articles.entities.enums;

public enum ArticleStatus {

    PUBLIC(1, "PUBLIC"),
    PRIVATE(2, "PRIVATE"),
    REMOVED(3, "REMOVED");

    private Integer code;
    private String title;

    private ArticleStatus(Integer code, String title){
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

    public static ArticleStatus toEnum(Integer code){
        if(code == null) return null;

        for(ArticleStatus articleStatus : ArticleStatus.values()){
            if(code.equals(articleStatus.getCode())) return articleStatus;
        }

        throw new IllegalArgumentException("Invalid ID " + code);
    }
}