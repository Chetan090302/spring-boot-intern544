package com.example.intrenship.project.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="user")
public class User
{
    @Id
    private Integer userId;
    public User()
    {

    }
    public User(Integer userId)
    {
        this.userId = userId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
