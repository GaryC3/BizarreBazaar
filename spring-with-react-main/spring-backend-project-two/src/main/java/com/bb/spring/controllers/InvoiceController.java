package com.bb.spring.controllers;

import java.util.List;
import java.util.Optional;

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

import com.bb.spring.beans.GameList;
import com.bb.spring.beans.Invoice;
import com.bb.spring.beans.UserList;
import com.bb.spring.repositories.GameListRepo;
import com.bb.spring.repositories.InvoiceRepo;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("invoice")
public class InvoiceController {
	
	
	@Autowired
	private GameListRepo gameListRepo; 
	
	@Autowired
	private UserList userList;
	
	@Autowired
	private InvoiceRepo invoiceRepo;
	
	
	// get by id to hold the game selected to buy from the front end
	@GetMapping
	public List<Invoice> getInvoice(@RequestBody UserList userList){
		 invoiceRepo.findAllById(userList.getId());
		 return
	}
	
	
}
