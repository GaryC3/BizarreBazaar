package com.bb.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bb.spring.beans.InvoiceLines;

@Repository
public interface InvoiceLineRepo extends JpaRepository<InvoiceLines, Integer>{

	@Query("FROM InvoiceLines inv inner join inv.userList user where user.id = ?1") // JPQL
	public List<InvoiceLines> findByUserId(int name);

	@Transactional
	@Modifying
	@Query("delete from InvoiceLines inv where inv.id = ?1")
	public void deleteByUserId(int realuserid);

//	@Query("FROM InvoiceLines inv inner join inv.userList user where user.id = ?1 inner join fir.gameList game where game.gameid = ?2") // JPQL
//	public List<InvoiceLines> getByUserAndGame(int id, int gameid);
	
	
	@Query("FROM InvoiceLines WHERE userList.id = ?1 AND gameList.gameid = ?2") // JPQL
	public List<InvoiceLines> getByUserAndGame(int id, int gameid);
	
}
