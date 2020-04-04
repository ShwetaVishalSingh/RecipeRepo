package com.recipe.se.recipes.business.domain.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class InvalidParameterExceptionHandler extends RuntimeException{

    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity handleConstraintViolationException(Exception ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
