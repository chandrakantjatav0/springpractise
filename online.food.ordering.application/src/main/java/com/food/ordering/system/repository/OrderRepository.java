package com.food.ordering.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.ordering.system.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	Order findByCustomer_IdAndRestaurantMenu_Id(Long customerId, Long restaurantMenuId);
	
}