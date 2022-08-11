package com.bb.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.spring.repositories.UserListRepo;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.bb.spring.beans.UserList;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("login")
public class SecurityController {
	
	@Autowired
	private UserListRepo userListRepo;
	
	@GetMapping
	public Optional<UserList> getUsername(@RequestBody ObjectNode node){
		String username = node.get("username").asText();
		return userListRepo.findByUsername(username);
	}

}
