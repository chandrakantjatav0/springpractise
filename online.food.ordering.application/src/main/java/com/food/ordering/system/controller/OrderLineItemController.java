package com.food.ordering.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.request.OrderLineItemRequest;
import com.food.ordering.system.response.OrderLineItemResponse;
import com.food.ordering.system.serviceImpl.OrderLineItemServiceImpl;


@RestController
@RequestMapping("/api/foodorder/orderlineItem")
public class OrderLineItemController {
	@Autowired
	OrderLineItemServiceImpl orderLineItemServiceImpl;

	@PostMapping("/orders")
	public ResponseEntity<OrderLineItemResponse> addOrders(@RequestBody OrderLineItemRequest orderLineItemRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(orderLineItemServiceImpl.addOrders(orderLineItemRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	List<OrderLineItemResponse> getAllOrderLineItem() {
		return orderLineItemServiceImpl.getAllOrderLineItem();
	}

}
