package com.stockapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stockapplication.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("Select as from Order as where as.product.id = :productid And as.seller.id = :sellerid ")
	Order findByProductIdandSellerId(Integer productid, Integer sellerid);

}
