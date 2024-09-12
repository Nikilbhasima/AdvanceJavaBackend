package com.bloodlink.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodlink.model.Address;
import com.bloodlink.service.AddressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AddressRestController {

	@Autowired
	private AddressService addS;
	
	@GetMapping("/address")
	public List<Address> getAddressInfo(){
		return addS.getAllAddress();
	}
	@PostMapping("/setAddress")
	public String setAddressInfo(@RequestBody Address address) {
		
		return addS.setAddress(address);
	}
	
}
