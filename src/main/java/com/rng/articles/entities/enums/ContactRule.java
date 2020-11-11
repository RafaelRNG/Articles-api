package com.rng.articles.entities.enums;

public enum ContactRule {

    NONE(1, "NONE"),
    NETWORK_ONLY(2, "NETWORK_ONLY"),
    ADMIRED_ONLY(3, "ADMIRED_ONLY"),
    ALL_USERS(4, "ALL_USERS");

    private Integer code;
    private String title;

    private ContactRule(Integer code, String title){
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

    public static ContactRule toEnum(Integer code){
        if(code == null) return null;

        for(ContactRule contactRule : ContactRule.values()){
            if(code.equals(contactRule.getCode())) return contactRule;
        }

        throw new IllegalArgumentException("Invalid ID " + code);
    }
}