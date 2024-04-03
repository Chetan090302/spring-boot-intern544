package com.example.intrenship.project.Entity;

import com.example.intrenship.project.Repository.Shoppingrepo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Shopping {
    @Id
    private Integer ordered;
    private Integer price;
    private Integer available;
    public Shopping()
    {

    }
    public Shopping(Integer ordered, Integer price, Integer available) {
        this.ordered = ordered;
        this.price = price;
        this.available = available;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}