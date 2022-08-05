package com.bb.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.spring.beans.UserList;
import com.bb.spring.repositories.UserListRepo;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("userlist")
public class UserListController {
	
	@Autowired
	private UserListRepo userListRepo;
	
	@GetMapping
	public List<UserList> getUserList(){
		return userListRepo.findAll();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<UserList> save(@RequestBody UserList userlist){
		return new ResponseEntity<>(userListRepo.save(userlist), HttpStatus.CREATED);
	}

}
