package com.rng.articles.controllers.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
    private Integer code;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date date;

    public ErrorMessage(String message, Integer code, Date date){
        this.message = message;
        this.code = code;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
