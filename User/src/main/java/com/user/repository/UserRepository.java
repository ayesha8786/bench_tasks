package com.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {

	Users findByUsername(String username);

}
