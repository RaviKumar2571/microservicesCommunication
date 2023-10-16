package com.commerce.customer.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.customer.customerservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
