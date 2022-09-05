package com.example.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<?> notFoundResonse(){
        return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
    }

}
