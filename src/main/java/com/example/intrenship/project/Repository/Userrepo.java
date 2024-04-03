package com.example.intrenship.project.Repository;

import com.example.intrenship.project.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Userrepo extends MongoRepository<User,Integer>
{

}
