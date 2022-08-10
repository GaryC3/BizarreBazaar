package com.bb.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bb.spring.beans.GameList;

@Repository
public interface GameListRepo extends JpaRepository<GameList, Integer>{

	//@Query("FROM Invoice inve inner join game.userList user where user.id = ?1") // JPQL
	@Query("FROM GameList game LEFT JOIN Invoice inv where inv.id= ?1")
	List<GameList> findUnowned(int userid);

}
