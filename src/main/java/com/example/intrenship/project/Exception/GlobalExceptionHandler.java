package com.example.intrenship.project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ProductNotFound544> handleResourceNotFoundException(ProductNotFound ex)
    {
    return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
}