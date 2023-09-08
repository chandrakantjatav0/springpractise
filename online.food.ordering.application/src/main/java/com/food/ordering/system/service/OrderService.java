package com.food.ordering.system.service;

import java.util.List;

import com.food.ordering.system.entity.Order;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.request.OrderRequest;
import com.food.ordering.system.response.OrderResponse;

public interface OrderService {

	OrderResponse createOrder(OrderRequest orderRequest) throws ResourceNotFoundException;

	List<OrderResponse> getAllOrders();

	Order findByCustomerIdandRestauranMenutId(Long customerId, Long restaurantMenuId);
	
	//Order findByProduct(Long productId);
	
}
