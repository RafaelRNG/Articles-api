package com.rng.articles.controllers.exception;

import com.rng.articles.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorMessage> ObjectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest httpServletRequest){

        ErrorMessage errorMessage = new ErrorMessage(objectNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value(), new Date());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
