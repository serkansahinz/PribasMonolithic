package com.pribas.pribasmonolithic.repository;

import com.pribas.pribasmonolithic.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
}
