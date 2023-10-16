package com.commerce.customer.customerservice.service.interfaces;

import com.commerce.customer.customerservice.entity.Customer;

public interface CustomerServices {
	Customer getCustomerById(Long id);
	
	Customer createCustomer(Customer customer);
}
