package com.bb.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bb.spring.beans.MyUserDetails;
import com.bb.spring.beans.UserList;
import com.bb.spring.repositories.UserListRepo;

@Service
public class BbUserDetailsService implements UserDetailsService{

	@Autowired
	UserListRepo userListRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserList> user = userListRepo.findByUsername(username);
		// checks if username is in the database, throws exception if not found
		user.orElseThrow(() -> new UsernameNotFoundException(username + " Not Found")); 
		// returning the userlist instance from database from repo, converted into myuserdetails instance
		return user.map(MyUserDetails::new).get(); 
	}

}
