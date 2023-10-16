package com.ecommerce.address.service.interfaces;

import com.ecommerce.address.entity.Address;

public interface AddressService {
	Address createAddress(Address address);
	
	Address getAddressById(Long id);
}
