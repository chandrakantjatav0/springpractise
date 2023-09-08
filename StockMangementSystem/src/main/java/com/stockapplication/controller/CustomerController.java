package com.stockapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.request.CustomerRequest;
import com.stockapplication.response.CustomerResponse;
import com.stockapplication.service.impl.CustomerServiceImpl;

@RestController
@RequestMapping("/api/stocknew/customer")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@PostMapping("/save")
	public String addCustomer(@RequestBody CustomerRequest customerRequest) throws ResourceNotFoundException {
		return customerServiceImpl.addCustomer(customerRequest);
	}

	@PostMapping("/authenticateCustomer")
	public String authenticateCustomers(@RequestBody CustomerRequest customerRequest)  {
		return customerServiceImpl.authenticateCustomer(customerRequest);
	}

	@GetMapping("getAll")
	public List<CustomerResponse> getAllCustomer() {
		return customerServiceImpl.getAllCustomer();
	}

}