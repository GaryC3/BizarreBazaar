package com.bb.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bb.spring.beans.InvoiceLines;

@Repository
public interface InvoiceLineRepo extends JpaRepository<InvoiceLines, Integer>{

}
