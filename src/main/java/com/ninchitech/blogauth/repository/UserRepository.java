package com.ninchitech.blogauth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ninchitech.blogauth.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	Optional<User> findByUsername(String username);
	List<User> findBuyUsernameIn(List<String> usernames);
	Boolean existsByUsername(String username);
	Boolean exitsByEmail(String email);
	
}
