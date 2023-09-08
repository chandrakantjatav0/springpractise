package com.stockapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.request.OrderRequest;
import com.stockapplication.response.OrderResponse;
import com.stockapplication.service.impl.OrderServiceImpl;

@RestController
@RequestMapping("/api/stocknew/order")
public class OrderController {
	@Autowired
	OrderServiceImpl orderServiceImpl;

	@PostMapping("/createdByCustomer")
	public ResponseEntity<OrderResponse> orderByCustomer(@RequestBody OrderRequest orderRequest)
			throws ResourceNotFoundException {
	return new ResponseEntity<OrderResponse>(orderServiceImpl.orderByCustomer(orderRequest),HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	List<OrderResponse> getAllOrders() {
		return orderServiceImpl.getAllOrders();

	}

}
