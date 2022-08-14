package com.bb.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bb.spring.beans.GameList;
import com.bb.spring.beans.Invoice;

@Repository
public interface GameListRepo extends JpaRepository<GameList, Integer>{

	//@Query("FROM Invoice inv inner join game.invoice inv where inv.userList.id = ?1") // JPQL
	@Query("FROM GameList game LEFT JOIN game.invoice inv ON inv.userList.id = ?1 WHERE inv.gameList.gameid IS NULL")
	//@Query("SELECT gameid FROM GameList game MINUS SELECT gameid FROM game.invoice.gameList")
	List<GameList> findUnowned(@Param("userid") int userid);
	
	@Query("FROM GameList game INNER JOIN game.invoice inv ON inv.userList.id = ?1")
	List<GameList> findOwned(@Param("userid") int userid);

}
