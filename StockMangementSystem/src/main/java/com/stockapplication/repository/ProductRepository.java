package com.stockapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockapplication.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
