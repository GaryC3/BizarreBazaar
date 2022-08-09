package com.bb.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.bb.spring.beans.UserList;

@Repository
public interface UserListRepo extends JpaRepository<UserList, String>{
	
	UserList findByEmail(String email);
}
