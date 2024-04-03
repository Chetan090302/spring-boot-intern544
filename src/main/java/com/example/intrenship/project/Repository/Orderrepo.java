package com.example.intrenship.project.Repository;

import com.example.intrenship.project.Entity.Order;
import com.example.intrenship.project.Entity.Shopping;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Orderrepo extends MongoRepository<Order,Integer>
{
    List<Order> findByuserId(Integer userId);
}
