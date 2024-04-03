package com.example.intrenship.project.Entity;

import org.springframework.data.annotation.Id;

public class Transaction {

    @Id
    public Integer orderId;
    public Integer userId;
    public Integer amount;
    public String TransactionId;
    public String status;

    public Transaction()
    {

    }

    public Transaction(Integer orderId, Integer userId, Integer amount,String transactionId, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.amount=amount;
        this.TransactionId = transactionId;
        this.status = status;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
