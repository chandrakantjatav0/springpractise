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
import com.food.ordering.system.repository.CustomerRepository;
import com.food.ordering.system.request.CustomerRequest;
import com.food.ordering.system.response.CustomerResponse;
import com.food.ordering.system.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping("/api/foodorder/customer")
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(customerServiceImpl.addCustomer(customerRequest), HttpStatus.CREATED);
	}

	@PostMapping("authenticateCustomer")
	public String authenticCustomer(@RequestBody CustomerRequest customerRequest) {
		return customerServiceImpl.authenticCustomer(customerRequest);
	}

	@GetMapping("getAll")
	public List<CustomerResponse> getAllCustomers() {
		return customerServiceImpl.getAllCustomers();

	}
	
}
