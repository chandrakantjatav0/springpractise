package com.food.ordering.system.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.ordering.system.entity.Customer;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.repository.CustomerRepository;
import com.food.ordering.system.repository.OrderRepository;
import com.food.ordering.system.request.CustomerRequest;
import com.food.ordering.system.response.CustomerResponse;

@Component
public class CustomerHelper {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OrderRepository orderRepository;

	public Customer customerFromcustomerRequest(CustomerRequest customerRequest) throws ResourceNotFoundException {
		Customer customer;
		if (customerRequest.getId() != null) {
			customer = this.customerRepository.findById(customerRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No customer Found by this!.."));
		} else {
			customer = new Customer();
		}
		customer.setName(customerRequest.getName());
		customer.setLocation(customerRequest.getLocation());
		customer.setEmail(customerRequest.getEmail());
		customer.setPaymenttype(customerRequest.getPaymenttype());
		customer.setUsername(customerRequest.getUsername());
		customer.setPassword(customerRequest.getPassword());

		return customer;
	}

	public CustomerResponse customerResponseFromCustomer(Customer customer) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setId(customer.getId());
		customerResponse.setName(customer.getName());
		customerResponse.setEmail(customer.getEmail());
		customerResponse.setLocation(customer.getLocation());
		customerResponse.setPaymenttype(customer.getPaymenttype());
		customerResponse.setUsername(customer.getUsername());
		customerResponse.setPassword(customer.getPassword());
		return customerResponse;

	}

}
