package com.Hexaview.springsecurityjpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hexaview.springsecurityjpa.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	// Creating Definatioon of method and then JPA provides implementation
	// JPA will create implementation 
	Optional<User> findByUserName(String userName);
	
}
