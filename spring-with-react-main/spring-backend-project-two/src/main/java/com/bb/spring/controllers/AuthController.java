package com.bb.spring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.spring.beans.AuthRequest;
import com.bb.spring.beans.AuthResponse;
import com.bb.spring.beans.UserList;
import com.bb.spring.jwt.JwtTokenUtil;
import com.bb.spring.repositories.UserListRepo;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtTokenUtil jwtUtil;
	
	@Autowired
	private UserListRepo userListRepo;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @RequestHeader @Valid AuthRequest request){
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			UserList user = (UserList) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
			System.out.println(accessToken);
			return ResponseEntity.ok()
					.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization" + accessToken)
					.body(response);
		}catch(BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> signup(@RequestBody @Valid ObjectNode node){
		System.out.println("create");
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String first = node.get("first_name").asText();
		String last = node.get("last_name").asText();
		String email = node.get("email").asText();
		String rawPasword = node.get("password").asText();
		String encodedPassword = passwordEncoder.encode(rawPasword);
		
		UserList newUser = new UserList();
		
		newUser.setFirst_name(first);
		newUser.setLast_name(last);
		newUser.setEmail(email);
		newUser.setPassword(encodedPassword);
		
		System.out.println(newUser);
		System.out.println(newUser);
				
		return new ResponseEntity<>(userListRepo.save(newUser), HttpStatus.CREATED);
		
	}
}
