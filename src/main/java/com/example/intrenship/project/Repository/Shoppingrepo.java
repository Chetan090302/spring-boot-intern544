package com.example.intrenship.project.Repository;

import com.example.intrenship.project.Entity.Shopping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Shoppingrepo extends MongoRepository<Shopping,Integer>{
}
