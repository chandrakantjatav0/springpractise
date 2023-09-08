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
import com.food.ordering.system.repository.OrderRepository;
import com.food.ordering.system.request.OrderRequest;
import com.food.ordering.system.response.OrderResponse;
import com.food.ordering.system.serviceImpl.OrderServiceImpl;

@RestController
@RequestMapping("/api/foodorder/order")
public class OrderController {
	@Autowired
	OrderServiceImpl orderServiceImpl;
	@Autowired
	OrderRepository orderRepository;

	@PostMapping("create")
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(orderServiceImpl.createOrder(orderRequest), HttpStatus.CREATED);
	}

	@GetMapping("getAll")
	public List<OrderResponse> getAllOrders() {
		return orderServiceImpl.getAllOrders();

	}

}
