package com.bb.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.spring.beans.Discount;
import com.bb.spring.beans.GameList;
import com.bb.spring.repositories.DiscountRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("discount")
public class DiscountController {
	
	@Autowired
	private DiscountRepo discountRepo;
	
	@GetMapping
	public List<Discount> getDiscount(){
		return discountRepo.findAll();
	}
	
	@PutMapping("/{genre}")
	public Discount save(@RequestBody Discount discount, @PathVariable String genre) {
		System.out.println(genre);
		if(discountRepo.existsById(genre)) {
			discount.setGenre(genre);
			return discountRepo.save(discount);
		}else {
			throw new IllegalArgumentException("There is no such listing  ");
			
		}
	}
	@PostMapping
	@Transactional
	public ResponseEntity<Discount> save(@RequestBody Discount discount){
		return new ResponseEntity<>(discountRepo.save(discount), HttpStatus.ACCEPTED);
	}

}
