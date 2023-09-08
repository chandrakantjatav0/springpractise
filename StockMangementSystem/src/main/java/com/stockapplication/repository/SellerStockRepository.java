package com.stockapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockapplication.model.SellerStock;

public interface SellerStockRepository extends JpaRepository<SellerStock, Integer> {

	SellerStock findByProductIdAndSellerId(Integer productid, Integer sellerid);

	SellerStock findByProductId(Integer productid);

}
