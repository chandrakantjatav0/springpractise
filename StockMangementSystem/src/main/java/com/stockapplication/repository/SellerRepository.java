package com.stockapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockapplication.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

	Seller findByUsername(String username);

}
