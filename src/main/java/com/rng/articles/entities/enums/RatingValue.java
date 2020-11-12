package com.rng.articles.entities.enums;

public enum RatingValue {

    FIVE_NEGATIVE_POINT(1, "FIVE_NEGATIVE_POINT"),
    A_NEGATIVE_POINT(2, "A_NEGATIVE_POINT"),
    NEUTRAL(3, "NEUTRAL"),
    A_POSITIVE_POINT(4, "A_POSITIVE_POINT"),
    FIVE_POSITIVE_POINT(5, "FIVE_POSITIVE_POINT");

    private Integer code;
    private String title;

    private RatingValue(Integer code, String title){
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

    public static RatingValue toEnum(Integer code){
        if(code == null) return null;

        for(RatingValue ratingValue : RatingValue.values()){
            if(code.equals(ratingValue.getCode())) return ratingValue;
        }

        throw new IllegalArgumentException("Invalid ID " + code);
    }
}