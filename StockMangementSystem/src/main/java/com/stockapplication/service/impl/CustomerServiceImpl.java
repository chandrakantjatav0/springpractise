package com.stockapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.helper.CustomerHelper;
import com.stockapplication.model.Customer;
import com.stockapplication.repository.CustomerRepository;
import com.stockapplication.request.CustomerRequest;
import com.stockapplication.response.CustomerResponse;
import com.stockapplication.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private CustomerHelper customerHelper;

	@Override
	public String addCustomer(CustomerRequest customerRequest) throws ResourceNotFoundException {
		BCryptPasswordEncoder bycrpt = new BCryptPasswordEncoder();
		String encryptPwd = bycrpt.encode(customerRequest.getPassword());
		customerRequest.setPassword(encryptPwd);

		Customer customer = customerHelper.customerFromCustomerRequest(customerRequest);
		customerRepo.save(customer);
		// return customerHelper.customerResponseFromCustomer(customer);
		return "Customer saved in Database Succcesfully";
	}

	@Override
	public List<CustomerResponse> getAllCustomer() {
		List<Customer> list = customerRepo.findAll();
		return list.stream().map(customerHelper::customerResponseFromCustomer).collect(Collectors.toList());
	}

	@Override
	public String authenticateCustomer(CustomerRequest customerRequest)  {
		BCryptPasswordEncoder bycrpt = new BCryptPasswordEncoder();
		Customer customer = customerRepo.findByUsername(customerRequest.getUsername());

//		if (customer.isPresent()) {
//			Customer dbcustomer = opcustomer.get();

		if (bycrpt.matches(customerRequest.getPassword(), customer.getPassword())) {
			return "Authenticated Customer";
		} else {
			return "Incorrect Password";
		}
		// throw new ResourceNotFoundException("No customer found by this Id!!!");
	}

}
