package com.bb.spring.beans;

public class AuthResponse {

	private String email;
	private int id;
	private String accessToken;
	private String admin;
	
	public AuthResponse() {
	}

	public AuthResponse(String email, int id, String admin, String accessToken) {
		super();
		this.email = email;
		this.id = id;
		this.admin = admin;
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

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	

	
}
