	package com.bloodlink.service;




import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodlink.jpaRepository.AddressRepository;
import com.bloodlink.jpaRepository.DonorRepository;
import com.bloodlink.jpaRepository.RequestBloodRepository;
import com.bloodlink.mailHandler.SendMail;
import com.bloodlink.model.Address;
import com.bloodlink.model.Donor;
import com.bloodlink.model.RequestBlood;
import com.bloodlink.modelDTO.RequestDonorDTO;
import com.bloodlink.transferData.RequestDataTransfer;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RequestBloodService {
	@Autowired
	private RequestBloodRepository reqBloRep;
	
	@Autowired
	private AddressRepository addRepo;
	
	@Autowired
	private DonorRepository donorRepo;
	
	@Autowired
	private SendMail sMail;
	
	public List<RequestBlood> getRequestBlood(){
		
		return reqBloRep.findAll();
	}
	
	public boolean insertRequestData(RequestDonorDTO requestDonorDTO,int id) {
		
		Optional<Address> address=addRepo.findById(requestDonorDTO.getAddressId());
		Optional<Donor> donor=donorRepo.findById(id);
		
		RequestBlood requestBlood=new RequestBlood();
		requestBlood.setPatient(requestDonorDTO.getPatient());
		requestBlood.setAddressId(address.get());
		requestBlood.setRequester(donor.get());
		requestBlood.setBloodGrp(requestDonorDTO.getBloodGrp());
		requestBlood.setCases(requestDonorDTO.getCases());
		requestBlood.setDate(requestDonorDTO.getDate());
		requestBlood.setTime(requestDonorDTO.getTime());
		requestBlood.setHospital(requestDonorDTO.getHospital());
		requestBlood.setUnit(requestDonorDTO.getUnit());
		requestBlood.setContact(requestDonorDTO.getContact());
		requestBlood.setPhone(requestDonorDTO.getPhone());
		requestBlood.setStatus("open");
		
		
		List<String> gmailList=donorRepo.findGmailByBloodGrp(requestDonorDTO.getBloodGrp());
		
		System.out.println("list of gmail are:"+gmailList);
		
//		sMail.postMail(gmailList,requestBlood);
		
		reqBloRep.save(requestBlood);
		return true;
	}
	
	public List<RequestDataTransfer> getRequestData(int id,Donor donor) {

		List<RequestBlood> bloods=reqBloRep.findByRequester(donor);
//		List<RequestBlood> bloods=reqBloRep.findByRequester(id);
		
		List<RequestDataTransfer> dataTransferts=new ArrayList<>();
		
		for(RequestBlood blood:bloods) {
			
			if(!blood.getStatus().equals("close")) {
				RequestDataTransfer dataTransfer=new RequestDataTransfer();
				Optional<Address> address=addRepo.findById(blood.getId());
				Address address2=address.get();
				
				dataTransfer.setId(blood.getId());
				dataTransfer.setBloodGrp(blood.getBloodGrp());
				dataTransfer.setCases(blood.getCases());
				dataTransfer.setPhone(blood.getPhone());
				dataTransfer.setDate(blood.getDate());
				dataTransfer.setTime(blood.getTime());
				dataTransfer.setHospital(blood.getHospital());
				dataTransfer.setAddress(address2.getLocation());
				dataTransfer.setUnit(blood.getUnit());
				dataTransfer.setPatient(blood.getPatient());
				dataTransfer.setContact(blood.getContact());
				dataTransferts.add(dataTransfer);	
			}
		}
		return dataTransferts;
	}
	
	
	public boolean updateState(int id) {
		Optional<RequestBlood> blood=reqBloRep.findById(id);
		if(blood.isPresent()) {
			RequestBlood blood2=blood.get();
			blood2.setStatus("close");
			reqBloRep.save(blood2);
			return true;
		}
		return false;
	}
	
	public List<RequestDataTransfer> getRequestBloodDetail(String bloodGrp,int id) {
		List<RequestBlood> bloodList=reqBloRep.findByBloodGrp(bloodGrp);
		
		List<RequestDataTransfer> dataTransfers=new ArrayList<>();
		
		for(RequestBlood blood:bloodList) {
			if(id!=blood.getRequester().getId()) {
				if(!blood.getStatus().equals("close")) {
					Optional<Address> address=addRepo.findById(blood.getId());
					Address address2=address.get();
					
					RequestDataTransfer dataTransfer=new RequestDataTransfer();
					
					dataTransfer.setAddress(address2.getLocation());
					dataTransfer.setId(blood.getId());
					dataTransfer.setBloodGrp(blood.getBloodGrp());
					dataTransfer.setCases(blood.getCases());
					dataTransfer.setContact(blood.getContact());
					dataTransfer.setDate(blood.getDate());
					dataTransfer.setPatient(blood.getPatient());
					dataTransfer.setPhone(blood.getPhone());
					dataTransfer.setDate(blood.getDate());
					dataTransfer.setUnit(blood.getUnit());
					dataTransfer.setHospital(blood.getHospital());
					dataTransfer.setTime(blood.getTime());
					
					dataTransfers.add(dataTransfer);
				}
			}
		}
		
		return dataTransfers;
	}
	
	public boolean recordUser(int userId,int reqID) {
		Optional<Donor> d=donorRepo.findById(userId);
		Donor donor=d.get();
		Optional<RequestBlood> b=reqBloRep.findById(reqID);
		RequestBlood blood=b.get();
		List<Donor> donorList=new ArrayList<>();
		donorList.add(donor);
		
		for(Donor donors:blood.getAcceptedList()) {
			donorList.add(donors);
		}
		blood.setAcceptedList(donorList);
		reqBloRep.save(blood);
		return true;
	}
	
	public void updateStatus(int id) {
		Optional<Donor> donor=donorRepo.findById(id);
		if(donor.isPresent()) {
			Donor donor2=donor.get();
			donor2.setAvailability("no");
			donorRepo.save(donor2);
		}
	}
	
	public void updateAvailable(int id) {
		Optional<Donor> donor=donorRepo.findById(id);
		if(donor.isPresent()) {
			Donor donor2=donor.get();
			donor2.setAvailability("available");
			donorRepo.save(donor2);
		}
	}
	
	public void updateUnavailable(int id) {
		Optional<Donor> donor=donorRepo.findById(id);
		if(donor.isPresent()) {
			Donor donor2=donor.get();
			donor2.setAvailability("no");
			donorRepo.save(donor2);
		}
	}
	
	
	
	
	
	
	public List<RequestDonorDTO> findListOfDonor(int id) {
	    
	    Optional<Donor> donor=donorRepo.findById(id);
	    
	    if(donor.isPresent()) {
	    	Donor donor3=donor.get();
	    	List<RequestBlood> requestBloodList=reqBloRep.findByRequester(donor3);
//	    	List<RequestBlood> newRequestBloodList=new ArrayList<>();
	    	List<RequestDonorDTO> rddList=new  ArrayList<>();
	    	for(RequestBlood rb:requestBloodList) {
	    	RequestDonorDTO rdd=new RequestDonorDTO();
	    	rdd.setBloodGrp(rb.getBloodGrp());
	    	rdd.setPatient(rb.getPatient());
	    	rdd.setCases(rb.getCases());
	    	rdd.setContact(rb.getContact());
	    	rdd.setId(rb.getId());
	    	rdd.setHospital(rb.getHospital());
	    	rdd.setDate(rb.getDate());
	    	rdd.setTime(rb.getTime());
	    	rdd.setPhone(rb.getPhone());
	    	rdd.setStatus(rb.getStatus());
	    		List<Donor>	donors=reqBloRep.findDonorsByRequestBloodId(rb.getId());
	    		for(Donor dd:donors) {
	    			System.out.println(dd.getUsername());
	    		}
	    		rdd.setDonorlist(donors);
//	    		newRequestBloodList.add(rb);
	    		rddList.add(rdd);
	    	}
	    	
	    	return rddList;
	    }
	    return null;
	}
	
	
	
	public List<RequestBlood> findParticipatedRequest(int donorId) {
		
		List<RequestBlood> requestList= donorRepo.findParticipatedRequestsByDonor(donorId);
		return requestList;
	}
	
	
}
