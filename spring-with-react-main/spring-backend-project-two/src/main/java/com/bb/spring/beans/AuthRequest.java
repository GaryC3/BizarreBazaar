package com.bb.spring.beans;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

public class AuthRequest {
	
	@Email
	private String email;
	
	@Length(min = 3, max = 10)
	private String password;
	
	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AuthRequest [email=" + email + ", password=" + password + "]";
	} 
	
	
	

}
