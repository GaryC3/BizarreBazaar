package com.bb.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bb.spring.beans.GameList;

@Repository
public interface GameListRepo extends JpaRepository<GameList, Integer>{

}
