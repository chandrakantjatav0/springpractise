package com.stockapplication.service;

import java.util.List;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.request.CustomerRequest;
import com.stockapplication.response.CustomerResponse;

public interface CustomerService {
	String addCustomer(CustomerRequest customerRequest) throws ResourceNotFoundException;

	String authenticateCustomer(CustomerRequest customerRequest) ;

	List<CustomerResponse> getAllCustomer();
}
