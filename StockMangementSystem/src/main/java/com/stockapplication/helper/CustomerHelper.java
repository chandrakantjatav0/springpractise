package com.stockapplication.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.Customer;
import com.stockapplication.repository.CustomerRepository;
import com.stockapplication.request.CustomerRequest;
import com.stockapplication.response.CustomerResponse;

@Component
public class CustomerHelper {
	@Autowired
	CustomerRepository customerRepo;

	public Customer customerFromCustomerRequest(CustomerRequest customerRequest) throws ResourceNotFoundException {
		Customer customer = new Customer();
		if (customerRequest.getId() != null) {
			customer = this.customerRepo.findById(customerRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No customer found by this id"));
		}
		customer.setName(customerRequest.getName());
		customer.setAddress(customerRequest.getAddress());
		customer.setUsername(customerRequest.getUsername());
		customer.setPassword(customerRequest.getPassword());
		return customer;
	}

	public CustomerResponse customerResponseFromCustomer(Customer customer) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setId(customer.getId());
		customerResponse.setName(customer.getName());
		customerResponse.setAddress(customer.getAddress());
		customerResponse.setPassword(customer.getPassword());
		customerResponse.setUsername(customer.getUsername());
		return customerResponse;

	}

}
