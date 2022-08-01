package com.bb.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.spring.beans.UserList;
import com.bb.spring.repositories.UserListRepo;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("userlist/")
public class UserListController {
	
	@Autowired
	private UserListRepo userListRepo;
	
	@GetMapping
	public List<UserList> getUserList(){
		return userListRepo.findAll();
	}

}
