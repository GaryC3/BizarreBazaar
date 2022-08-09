package com.bb.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.spring.beans.Invoice;
import com.bb.spring.beans.InvoiceLines;
import com.bb.spring.repositories.InvoiceLineRepo;
import com.bb.spring.repositories.InvoiceRepo;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("invoicelines")
public class InvoiceLinesController {
	
	@Autowired
	private InvoiceLineRepo invoiceLineRepo;
	
	@Autowired
	private InvoiceRepo invoiceRepo;
	
	@GetMapping
	public List<Invoice> getInvoice(@RequestBody ObjectNode node){
		int userid = node.get("id").asInt();
		 return invoiceRepo.findByUserId(userid);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<InvoiceLines> save(@RequestBody InvoiceLines invoiceLine){
		return new ResponseEntity<>(invoiceLineRepo.save(invoiceLine), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<InvoiceLines> delete(@PathVariable String userid){
		int realuserid = Integer.parseInt(userid);
		invoiceLineRepo.deleteByUserId(realuserid);
		return ResponseEntity.noContent().build();
	}
}
