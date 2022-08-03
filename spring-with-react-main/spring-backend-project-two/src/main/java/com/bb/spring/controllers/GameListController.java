package com.bb.spring.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.spring.beans.GameList;
import com.bb.spring.repositories.GameListRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("gameList")
public class GameListController {
	
	@Autowired
	private GameListRepo gameListRepo;
	
	@GetMapping
	public List<GameList> getGameList(){
		return gameListRepo.findAll();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<GameList> save(@RequestBody GameList gameList){
		return new ResponseEntity<>(gameListRepo.save(gameList), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{gameid}")
	public ResponseEntity<GameList> delete(@PathVariable int gameid){
		gameListRepo.deleteById(gameid);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{gameid}")
	public GameList update(@RequestBody GameList gameList, @PathVariable int gameid) {
		if(gameListRepo.existsById(gameid)) {
			gameList.setGameid(gameid);
			return gameListRepo.save(gameList);
		}else {
			throw new IllegalArgumentException("There is no such listing  ");
			
		}
	}

}
