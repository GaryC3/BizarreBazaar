package com.bb.spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bb.spring.beans.UserList;

@Repository
public interface UserListRepo extends JpaRepository<UserList, Integer>{
	
//	@Modifying
//	@Query("select username password active roles from userlist where username = ?")
	Optional<UserList> findByUsername(String username);

}
