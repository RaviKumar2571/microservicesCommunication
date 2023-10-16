package com.commerce.customer.customerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import com.commerce.customer.customerservice.entity.Customer;

@Configuration
public class CustomerConfig {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	@Scope("prototype")
	public Customer customer() {
		return new Customer();
	}
}
