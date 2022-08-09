package com.bb.spring.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bb.spring.CustomUserDetails;
import com.bb.spring.beans.UserList;
import com.bb.spring.repositories.UserListRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	
	private UserListRepo userListRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserList user = userListRepo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		
		return new CustomUserDetails(user);
	}
	

}
