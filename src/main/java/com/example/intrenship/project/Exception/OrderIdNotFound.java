package com.example.intrenship.project.Exception;

public class OrderIdNotFound extends RuntimeException {
        private String orderId;
        private String description;

    public OrderIdNotFound(String message, String orderId, String description) {
        super(message);
        this.orderId = orderId;
        this.description = description;
    }

    public OrderIdNotFound(String message, Throwable cause, String orderId, String description) {
        super(message, cause);
        this.orderId = orderId;
        this.description = description;
    }

    public String getOrderId() {
            return orderId;
        }

        public String getDescription() {
            return description;
        }
    }
