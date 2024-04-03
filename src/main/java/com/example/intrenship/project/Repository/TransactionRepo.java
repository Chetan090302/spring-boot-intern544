package com.example.intrenship.project.Repository;

import com.example.intrenship.project.Entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepo extends MongoRepository<Transaction,Integer> {
    List<Transaction> findByuserId(Integer userId);

    List<Transaction> findByorderId(Integer orderId);
}
