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

import com.bb.spring.beans.GameList;
import com.bb.spring.beans.Invoice;
import com.bb.spring.beans.InvoiceLines;
import com.bb.spring.repositories.GameListRepo;
import com.bb.spring.repositories.InvoiceLineRepo;
import com.bb.spring.repositories.InvoiceRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("invoicelines")
public class InvoiceLinesController {
	
	@Autowired
	private InvoiceLineRepo invoiceLineRepo;
	
	@Autowired
	private InvoiceRepo invoiceRepo;
	
	@Autowired
	private GameListRepo gameListRepo;
	
	@GetMapping
	public List<GameList> getGameList(){
		return gameListRepo.findAll();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<InvoiceLines> save(@RequestBody InvoiceLines invoiceLine){
		return new ResponseEntity<>(invoiceLineRepo.save(invoiceLine), HttpStatus.CREATED);
	}

}
