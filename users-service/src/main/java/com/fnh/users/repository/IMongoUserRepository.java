package com.fnh.users.repository;

import com.fnh.users.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMongoUserRepository extends MongoRepository<User,String> {
}


