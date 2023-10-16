package com.commerce.customer.customerservice.controller;

import com.commerce.customer.customerservice.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.commerce.customer.customerservice.entity.Customer;
import com.commerce.customer.customerservice.entity.CustomerResponse;
import com.commerce.customer.customerservice.service.interfaces.CustomerServices;

@RestController
@RequestMapping("/customerManagment")
public class CustomerController {
	
	@Autowired
	CustomerServices customerServices;
	
	@Autowired
	Customer customer;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> createNewCustomer(@RequestBody CustomerResponse customerResponse){
		
		ResponseEntity<Address> newAddress =  restTemplate.postForEntity("http://localhost:8082/geographicAddress/address", customerResponse.getAddress(), Address.class);
		Address address = newAddress.getBody();
		Long addressId = address.getAddressId();

		customer.setEmailId(customerResponse.getEmailId());
		customer.setFirstName(customerResponse.getFirstName());
		customer.setLastName(customerResponse.getLastName());
		customer.setAddressId(addressId);
		
		Customer newCustomer = customerServices.createCustomer(customer);
		return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> retrieveCustomer(@PathVariable ("id") Long customerId){
		Customer retrievedCustomer = customerServices.getCustomerById(customerId);
		return new ResponseEntity<Customer>(retrievedCustomer, HttpStatus.OK);
	}

}
