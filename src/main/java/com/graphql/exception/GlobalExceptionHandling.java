package com.graphql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ex.getMessage());
    }
}
