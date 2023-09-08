package com.stockapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockapplication.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByUsername (String username);
	
}
