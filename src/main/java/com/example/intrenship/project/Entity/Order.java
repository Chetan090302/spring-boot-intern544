package com.example.intrenship.project.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(value = "orders")
public class Order
{
	    @Id
    	private Integer orderId;
		private Integer userId;
		private Integer quantity;
		private Integer amount;
	    private LocalDate time;
		private String coupon;

	public Order()
	{

	}
	public Order(Integer orderId, Integer userId, Integer quantity, Integer amount, String coupon,LocalDate time) {
		this.orderId = orderId;
		this.userId = userId;
		this.quantity = quantity;
		this.amount = amount;
		this.time=time;
		this.coupon = coupon;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}
}
