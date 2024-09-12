package com.bloodlink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodlink.jpaRepository.AddressRepository;
import com.bloodlink.jpaRepository.CampaignRepository;
import com.bloodlink.model.Address;
import com.bloodlink.model.Campaign;
import com.bloodlink.modelDTO.CampaignDTO;

@Service
public class CampaignService {

	@Autowired
	private CampaignRepository campRepo;
	
	@Autowired
	private AddressRepository addRepo;
	
	public String insertData(CampaignDTO campaignDTO) {
		
		Optional<Address> address=addRepo.findById(campaignDTO.getAddress());
		
		Campaign campaign=new Campaign();
		
		campaign.setAddressId(address.get());;
		campaign.setOrganization(campaignDTO.getOrganization());
		campaign.setDate(campaignDTO.getDate());
		campaign.setStarting(campaignDTO.getStarting());
		campaign.setEnding(campaignDTO.getEnding());
		campaign.setPhoneN(campaignDTO.getPhoneN());
		campaign.setGmail(campaignDTO.getGmail());
		campaign.setVenue(campaignDTO.getVenue());
		campaign.setStatus(campaignDTO.getVenue());
		
		campRepo.save(campaign);
		return "data entered successfully";
	}
	
	
	
	public List<Campaign> getAllCampaignData(){
		
		return campRepo.findAll();
	}
}
