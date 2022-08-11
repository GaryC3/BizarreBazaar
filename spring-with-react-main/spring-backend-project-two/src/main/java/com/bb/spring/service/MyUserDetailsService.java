package com.bb.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bb.spring.beans.UserList;
import com.bb.spring.repositories.UserListRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
    private UserListRepo userListRepo;
	
	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return new User("foo", "foo", new ArrayList<>());
//	}
	public UserDetails loadUserByUsername(String name) {
        UserList user = userListRepo.findByName(name);
        if (user == null) {
            throw new UsernameNotFoundException(name);
        }
        return new MyUserPrincipal(user);
    }

}
