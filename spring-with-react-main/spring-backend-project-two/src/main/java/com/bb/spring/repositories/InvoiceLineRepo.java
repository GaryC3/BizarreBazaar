package com.bb.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bb.spring.beans.InvoiceLines;

@Repository
public interface InvoiceLineRepo extends JpaRepository<InvoiceLines, Integer>{

	@Query("FROM InvoiceLines inv inner join inv.userList user where user.id = ?1") // JPQL
	public List<InvoiceLines> findByUserId(int name);


	@Modifying
	@Query("delete from InvoiceLines inv where inv.userList.id=:realuserid")
	public void deleteByUserId(@Param("realuserid") int realuserid);
	
}
