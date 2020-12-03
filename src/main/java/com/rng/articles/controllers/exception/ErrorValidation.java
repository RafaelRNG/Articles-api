package com.rng.articles.controllers.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorValidation extends ErrorMessage{

    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ErrorValidation(String message, Integer code, Date date){
        super(message, code, date);
    }

    public List<FieldMessage> getErrors(){
        return this.errors;
    }

    public void addErrors(String name, String message){
        errors.add(new FieldMessage(name, message));
    }
}
