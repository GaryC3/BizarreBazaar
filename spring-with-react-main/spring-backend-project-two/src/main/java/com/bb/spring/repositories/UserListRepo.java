package com.bb.spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bb.spring.beans.UserList;

@Repository
public interface UserListRepo extends JpaRepository<UserList, Integer>{
	
	Optional<UserList> findByEmail(String email);
}
