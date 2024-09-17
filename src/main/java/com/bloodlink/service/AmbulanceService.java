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
import com.bloodlink.transferData.AmbulanceDataTransfer;

@Service
public class AmbulanceService {

	@Autowired
	private AmbulanceRepository ambRepo;
	
	@Autowired
	private DriverPhoneRepository driRepo;
	
	@Autowired
	private AddressRepository addRepo;
	
	public List<AmbulanceDataTransfer> getAmbulance(){
		List<Ambulance> ambuList=ambRepo.findAll();
		List<AmbulanceDataTransfer> ambulanceDataTransfers=new ArrayList<>();
		for(Ambulance a:ambuList) {
			Optional<Address> address=addRepo.findById(a.getAddress().getId());
			if(address.isPresent()) {
				Address address2=address.get();
				AmbulanceDataTransfer ambulanceDataTransfer=new AmbulanceDataTransfer();
				ambulanceDataTransfer.setAddress(address2);
				ambulanceDataTransfer.setDriver(a.getDriver());
				ambulanceDataTransfer.setHospital(a.getHospital());
				ambulanceDataTransfer.setHphone(a.getHphone());
				ambulanceDataTransfer.setPhoneD(a.getPhoneD());
				ambulanceDataTransfer.setId(a.getId());
				ambulanceDataTransfers.add(ambulanceDataTransfer);
			}else {
				System.out.println("nikil err");
			}
			
			
		}
//		return ambRepo.findAll();
		return ambulanceDataTransfers;
	}
	
	public String setAmbulanceData(AmbulanceDTO ambulanceDTO) {
		
		Optional<Address> address=addRepo.findById(ambulanceDTO.getAddress());
		
		List<DriverPhone> driverPhones=new ArrayList<>();
		for(DriverPhone d:ambulanceDTO.getPhoneD()) {
			DriverPhone driverP=new DriverPhone();
			System.out.println("Setting phone in ambulance:"+d.getPhoneN());
			if(d.getPhoneN()!=null  && !d.getPhoneN().isEmpty()) {
				driverP.setPhoneN(d.getPhoneN());
				driverPhones.add(driverP);
			}
			
		}
		Ambulance ambulance=new Ambulance();
		
		ambulance.setHospital(ambulanceDTO.getHospital());
		ambulance.setHphone(ambulanceDTO.getHphone());
		ambulance.setDriver(ambulanceDTO.getDriver());
		ambulance.setPhoneD(driverPhones);
		ambulance.setAddress(address.get());;
		
		ambRepo.save(ambulance);
		
	
		for(DriverPhone d: driverPhones) {
			DriverPhone driverPhone=new DriverPhone();
			System.out.println("Driver Phone number:"+d.getPhoneN());
			if(d.getPhoneN()!=null  && !d.getPhoneN().isEmpty()) {
				driverPhone.setAmbulance(ambulance);
				driverPhone.setPhoneN(d.getPhoneN());
				driRepo.save(driverPhone);
			}
			
		}
		System.out.println(ambulanceDTO);
		
		
		return "ambulance data inserted successfully";
	}
	
	public String updateAmbulanceData(AmbulanceDTO ambulanceDTO) {
		System.out.println(ambulanceDTO.getAddress());
		System.out.println(ambulanceDTO.getHospital());
		Optional<Address> address=addRepo.findById(ambulanceDTO.getAddress());
		Address address2=address.get();
		
		List<DriverPhone> driverPhones=new ArrayList<>();
		for(DriverPhone d:ambulanceDTO.getPhoneD()) {
			DriverPhone driverPhone=new DriverPhone();
			if(!d.getPhoneN().isEmpty()) {
				driverPhone.setId(d.getId());
				driverPhone.setPhoneN(d.getPhoneN());
				driverPhones.add(driverPhone);
			}
			
		}
		
		Ambulance ambulance=new Ambulance();
		ambulance.setId(ambulanceDTO.getId());
		ambulance.setAddress(address2);
		ambulance.setDriver(ambulanceDTO.getDriver());
		ambulance.setHospital(ambulanceDTO.getHospital());
		ambulance.setHphone(ambulanceDTO.getHphone());
		ambulance.setPhoneD(driverPhones);
		
		ambRepo.save(ambulance);
		for(DriverPhone dd:driverPhones) {
			if(!dd.getPhoneN().isEmpty()) {
				dd.setAmbulance(ambulance);
				driRepo.save(dd);
			}
			
		}
		
		return "data updated successfully";
		
	}
	
	
	public long countAmbulance() {
		long count=ambRepo.countAmbulance();
		return count;
	}
	

}
