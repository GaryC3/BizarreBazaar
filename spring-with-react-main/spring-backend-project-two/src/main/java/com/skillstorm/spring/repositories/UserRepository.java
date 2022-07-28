package com.skillstorm.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.spring.models.User;

@Repository 
public interface UserRepository extends JpaRepository<User,Integer>{
	// any methods you may want to define will go here
	
}
