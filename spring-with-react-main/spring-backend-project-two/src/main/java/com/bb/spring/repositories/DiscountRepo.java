package com.bb.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bb.spring.beans.Discount;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, String>{

}
