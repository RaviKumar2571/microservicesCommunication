package com.commerce.customer.customerservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.customer.customerservice.entity.Customer;
import com.commerce.customer.customerservice.repository.CustomerRepository;
import com.commerce.customer.customerservice.service.interfaces.CustomerServices;

@Service
public class CustomerServiceImpl implements CustomerServices{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer getCustomerById(Long id) {
		Customer retrievedCustomer = customerRepository.findById(id).get();
		return retrievedCustomer;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		Customer newCustomer = customerRepository.save(customer);
		return newCustomer;
	}
	
	
}
