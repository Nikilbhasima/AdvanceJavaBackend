package com.bloodlink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodlink.jpaRepository.AddressRepository;
import com.bloodlink.model.Address;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addRepo;
	
	public List<Address> getAllAddress() {
		 return addRepo.findAll();
	}
	
	public String setAddress(Address address) {
		addRepo.save(address);
		return "successful transaction";
	}
}
