package com.ecommerce.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
