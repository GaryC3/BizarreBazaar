package com.bb.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bb.spring.beans.Invoice;

@Repository
public interface InvoiceRepo extends JpaRepository<Invoice, Integer>{

	@Query("FROM Invoice inv inner join inv.userList user where user.id = ?1") // JPQL
	public List<Invoice> findByUserId(int name);
	
}
