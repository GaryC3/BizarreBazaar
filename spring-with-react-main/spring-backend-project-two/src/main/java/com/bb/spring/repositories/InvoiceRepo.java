package com.bb.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bb.spring.beans.Invoice;

@Repository
public interface InvoiceRepo extends JpaRepository<Invoice, Integer>{

}
