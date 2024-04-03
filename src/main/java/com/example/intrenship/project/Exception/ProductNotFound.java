package com.example.intrenship.project.Exception;

public class ProductNotFound extends RuntimeException{
    private String message;
    public ProductNotFound(String message)
    {
        super(message);
        this.message = message;
    }

    public ProductNotFound(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
