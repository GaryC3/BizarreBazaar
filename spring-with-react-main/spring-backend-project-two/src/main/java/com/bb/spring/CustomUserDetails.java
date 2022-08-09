package com.bb.spring;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bb.spring.beans.UserList;

public class CustomUserDetails implements UserDetails{
	
	private UserList userList;
	
	
	public CustomUserDetails(UserList userList) {
		super();
		this.userList = userList;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(userList.getRole()));
	}

	@Override
	public String getPassword() {
		return userList.getPassword();
	}

	@Override
	public String getUsername() {
		return userList.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
