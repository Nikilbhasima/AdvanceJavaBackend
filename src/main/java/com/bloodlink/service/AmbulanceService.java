package com.bloodlink.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodlink.jpaRepository.AddressRepository;
import com.bloodlink.jpaRepository.AmbulanceRepository;
import com.bloodlink.jpaRepository.DriverPhoneRepository;
import com.bloodlink.model.Address;
import com.bloodlink.model.Ambulance;
import com.bloodlink.model.DriverPhone;
import com.bloodlink.modelDTO.AmbulanceDTO;

@Service
public class AmbulanceService {

	@Autowired
	private AmbulanceRepository ambRepo;
	
	@Autowired
	private DriverPhoneRepository driRepo;
	
	@Autowired
	private AddressRepository addRepo;
	
	public List<Ambulance> getAmbulance(){
		return ambRepo.findAll();
	}
	
	public String setAmbulanceData(AmbulanceDTO ambulanceDTO) {
		
		Optional<Address> address=addRepo.findById(ambulanceDTO.getAddress());
		
		List<DriverPhone> driverPhones=new ArrayList<>();
		for(DriverPhone d:ambulanceDTO.getPhoneD()) {
			DriverPhone driverP=new DriverPhone();
			driverP.setPhoneN(d.getPhoneN());
			driverPhones.add(driverP);
		}
		
		
		Ambulance ambulance=new Ambulance();
		
		ambulance.setHospital(ambulanceDTO.getHospital());
		ambulance.setHphone(ambulanceDTO.getHphone());
		ambulance.setDriver(ambulanceDTO.getDriver());
		ambulance.setPhoneD(driverPhones);
		ambulance.setAddressId(address.get());;
		
		ambRepo.save(ambulance);
		
//		for(DriverPhone d:ambulanceDTO.getPhoneD()) {
//					
//			DriverPhone driverPhone=new DriverPhone();
//			driverPhone.setAmbulance(ambulance);
//			driverPhone.setPhoneN(d.getPhoneN());
//			driRepo.save(driverPhone);
//		}
//		
		for(DriverPhone d: driverPhones) {
			DriverPhone driverPhone=new DriverPhone();
			driverPhone.setAmbulance(ambulance);
			driverPhone.setPhoneN(d.getPhoneN());
			driRepo.save(driverPhone);
		}
		System.out.println(ambulanceDTO);
		
		
		return "ambulance data inserted successfully";
	}
}
