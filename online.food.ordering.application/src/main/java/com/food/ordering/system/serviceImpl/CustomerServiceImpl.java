package com.food.ordering.system.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.food.ordering.system.entity.Customer;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.helper.CustomerHelper;
import com.food.ordering.system.repository.CustomerRepository;
import com.food.ordering.system.request.CustomerRequest;
import com.food.ordering.system.response.CustomerResponse;
import com.food.ordering.system.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerHelper customerHelper;
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerResponse addCustomer(CustomerRequest customerRequest) throws ResourceNotFoundException {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String encryptPwd = bCrypt.encode(customerRequest.getPassword());
		customerRequest.setPassword(encryptPwd);

		Customer customer = customerHelper.customerFromcustomerRequest(customerRequest);
		customerRepository.save(customer);
		return customerHelper.customerResponseFromCustomer(customer);
	}

	@Override
	public List<CustomerResponse> getAllCustomers() {
		List<Customer> list = customerRepository.findAll();
		return list.stream().map(customerHelper::customerResponseFromCustomer).collect(Collectors.toList());
	}

	@Override
	public String authenticCustomer(CustomerRequest customerRequest) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		Customer customer = customerRepository.findByUsername(customerRequest.getUsername());

		if (bCrypt.matches(customerRequest.getPassword(), customer.getPassword())) {
			return "Authenticated Customer";
		} else {
			return "Incorrect Password";
		}
	}

}
