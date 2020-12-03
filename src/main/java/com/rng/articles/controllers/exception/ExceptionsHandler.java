package com.rng.articles.controllers.exception;

import com.rng.articles.services.exception.DataIntegratyException;
import com.rng.articles.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorMessage> ObjectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest httpServletRequest){

        ErrorMessage errorMessage = new ErrorMessage(objectNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value(), new Date());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(DataIntegratyException.class)
    public ResponseEntity<ErrorMessage> DataIntegraty(DataIntegratyException dataIntegratyException, HttpServletRequest httpServletRequest){
        ErrorMessage errorMessage = new ErrorMessage(dataIntegratyException.getMessage(), HttpStatus.BAD_REQUEST.value(), new Date());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> validationException(MethodArgumentNotValidException method, HttpServletRequest httpServletRequest){
        ErrorValidation errorValidation = new ErrorValidation(method.getMessage(), HttpStatus.BAD_REQUEST.value(), new Date());

        for(FieldError fieldError: method.getBindingResult().getFieldErrors()){
            errorValidation.addErrors(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorValidation);
    }
}
