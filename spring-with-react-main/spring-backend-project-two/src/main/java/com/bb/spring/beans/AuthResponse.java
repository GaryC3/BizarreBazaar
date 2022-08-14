package com.bb.spring.beans;

public class AuthResponse {

	private String email;
	private int id;
	private String accessToken;
	
	public AuthResponse() {
	}

	public AuthResponse(String email, int id, String accessToken) {
		super();
		this.email = email;
		this.id = id;
		this.accessToken = accessToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	
}
