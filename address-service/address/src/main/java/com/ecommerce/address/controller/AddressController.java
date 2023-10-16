package com.ecommerce.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.address.entity.Address;
import com.ecommerce.address.service.interfaces.AddressService;

@RestController
@RequestMapping("/geographicAddress")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("/address")
	public ResponseEntity<Address> createAddress(@RequestBody Address address){
		Address newAddress = addressService.createAddress(address);
		return new ResponseEntity<Address>(newAddress, HttpStatus.CREATED);
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable Long id){
		Address retrievedAddress = addressService.getAddressById(id);
		return new ResponseEntity<Address>(retrievedAddress, HttpStatus.OK);
	}
}
