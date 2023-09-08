package com.food.ordering.system.service;

import java.util.List;

import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.request.OrderLineItemRequest;
import com.food.ordering.system.response.OrderLineItemResponse;

public interface OrderLineItemService {

	public OrderLineItemResponse addOrders(OrderLineItemRequest orderLineItemRequest) throws ResourceNotFoundException;

	List<OrderLineItemResponse> getAllOrderLineItem();
	
	

}
