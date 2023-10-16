package com.ecommerce.address.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.address.entity.Address;
import com.ecommerce.address.repository.AddressRepository;
import com.ecommerce.address.service.interfaces.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public Address createAddress(Address address) {
		Address newAddress = addressRepository.save(address);
		return newAddress;
	}

	@Override
	public Address getAddressById(Long id) {
		Address retrievedAddress = addressRepository.findById(id).get();
		return retrievedAddress;
	}
	
	
}
