package com.food.ordering.system.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.ordering.system.entity.FoodItem;
import com.food.ordering.system.entity.Order;
import com.food.ordering.system.entity.OrderLineItem;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.repository.FoodItemRepository;
import com.food.ordering.system.repository.OrderLineItemRepository;
import com.food.ordering.system.repository.OrderRepository;
import com.food.ordering.system.request.OrderLineItemRequest;
import com.food.ordering.system.response.OrderLineItemResponse;

@Component
public class OrderLineItemHelper {
	@Autowired
	OrderLineItemRepository orderLineItemRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	FoodItemRepository foodItemRepository;

	public OrderLineItem orderLineItemFromOrderLineItemRequest(OrderLineItemRequest orderLineItemRequest)
			throws ResourceNotFoundException {
		OrderLineItem orderLineItem;
		if (orderLineItemRequest.getId() != null) {
			orderLineItem = this.orderLineItemRepository.findById(orderLineItemRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No Orders Was Created by this id!.."));
		} else {
			orderLineItem = new OrderLineItem();
		}
		orderLineItem.setQuantity(orderLineItemRequest.getQuantity());

		// fooditem
		FoodItem foodItem = foodItemRepository.findById(orderLineItemRequest.getFooditemid())
				.orElseThrow(() -> new ResourceNotFoundException("No Food was Created for  bulk order by this id!.."));
		orderLineItem.setFoodItem(foodItem);

		// order
		Order order = orderRepository.findById(orderLineItemRequest.getOrderId())
				.orElseThrow(() -> new ResourceNotFoundException("No Order Was Created for bulk order by this id!.."));
		orderLineItem.setOrder(order);

		return orderLineItem;
	}

	public OrderLineItemResponse orderLineItemResponseFromOrderLineItem(OrderLineItem orderLineItem) {
		OrderLineItemResponse orderLineItemResponse = new OrderLineItemResponse();
		orderLineItemResponse.setId(orderLineItem.getId());
		orderLineItemResponse.setQuantity(orderLineItem.getQuantity());
		// fooditem
		orderLineItemResponse.setFooditemid(orderLineItem.getFoodItem().getId());
		orderLineItemResponse.setName(orderLineItem.getFoodItem().getName());
		orderLineItemResponse.setDescription(orderLineItem.getFoodItem().getDescription());

		// order
		orderLineItemResponse.setOrderid(orderLineItem.getOrder().getId());
		// orderLineItemResponse.setOrderquantity(orderLineItem.getOrder().getQuantity());
		orderLineItemResponse.setTotalAmount(orderLineItem.getAmount());
		orderLineItemResponse.setOrderdate(orderLineItem.getOrder().getOrderdate());
		orderLineItemResponse.setOrderstatus(orderLineItem.getOrder().getOrderstatus());
		return orderLineItemResponse;
	}
}