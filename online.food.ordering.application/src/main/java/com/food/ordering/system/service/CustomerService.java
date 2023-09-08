package com.food.ordering.system.service;

import java.util.List;

import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.request.CustomerRequest;
import com.food.ordering.system.response.CustomerResponse;

public interface CustomerService {

	CustomerResponse addCustomer(CustomerRequest customerRequest) throws ResourceNotFoundException;

	List<CustomerResponse> getAllCustomers();
	
	String authenticCustomer(CustomerRequest customerRequest);

}
