
package com.bloodlink.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodlink.jpaRepository.AddressRepository;
import com.bloodlink.jpaRepository.CampaignRepository;
import com.bloodlink.model.Address;
import com.bloodlink.model.Campaign;
import com.bloodlink.modelDTO.CampaignDTO;
import com.bloodlink.transferData.CampaignDataTransfer;

@Service
public class CampaignService {

	@Autowired
	private CampaignRepository campRepo;
	
	@Autowired
	private AddressRepository addRepo;
	
	public String insertData(CampaignDTO campaignDTO) {
		
		Optional<Address> address=addRepo.findById(campaignDTO.getAddress());
		
		if(address.isPresent()) {
			Campaign campaign=new Campaign();
			
			campaign.setAddressId(address.get());;
			campaign.setOrganization(campaignDTO.getOrganization());
			campaign.setDate(campaignDTO.getDate());
			campaign.setStarting(campaignDTO.getStarting());
			campaign.setEnding(campaignDTO.getEnding());
			campaign.setPhoneN(campaignDTO.getPhoneN());
			campaign.setGmail(campaignDTO.getGmail());
			campaign.setVenue(campaignDTO.getVenue());

			
			campRepo.save(campaign);
			return "data entered successfully";
		}
		return "address is not comming";
		
		
	}
	
	public List<CampaignDataTransfer> getAllCampaignData(){
		
		List<Campaign> campaignList=campRepo.findAll();
		
		
		List<CampaignDataTransfer> campaignDataTransfers=new ArrayList<>();
		
		for(Campaign camp:campaignList) {
			System.out.println(camp.getAddressId().getId());
			Optional<Address> address=addRepo.findById(camp.getAddressId().getId());
			if(address.isPresent()) {
				Address address2=address.get();
				CampaignDataTransfer campaignDataTransfer=new CampaignDataTransfer();
				campaignDataTransfer.setAddress(address2.getLocation());
				campaignDataTransfer.setId(camp.getId());
				campaignDataTransfer.setOrganization(camp.getOrganization());
				campaignDataTransfer.setDate(camp.getDate());
				campaignDataTransfer.setStarting(camp.getStarting());
				campaignDataTransfer.setEnding(camp.getEnding());
				campaignDataTransfer.setGmail(camp.getGmail());
				campaignDataTransfer.setPhoneN(camp.getPhoneN());
				campaignDataTransfer.setVenue(camp.getVenue());
				campaignDataTransfers.add(campaignDataTransfer);
			}else {
				System.out.println("address not found");
			}
			
		}
		return campaignDataTransfers;
	}
	
	public String updateCampaign(CampaignDTO campaignDTO) {
		Optional<Campaign> campaign=campRepo.findById(campaignDTO.getId());
		if(campaign.isPresent()) {
			Campaign campaign2=campaign.get();
			 
			Optional<Address> address=addRepo.findById(campaignDTO.getAddress());
			Address address2=new Address();
			if(address.isPresent()) {
			address2=address.get();
			}else {
				System.out.println("Address not found");
			}
			campaign2.setId(campaignDTO.getId());
			campaign2.setAddressId(address2);
			campaign2.setDate(campaignDTO.getDate());
			campaign2.setStarting(campaignDTO.getStarting());
			campaign2.setEnding(campaignDTO.getEnding());
			campaign2.setPhoneN(campaignDTO.getPhoneN());
			campaign2.setGmail(campaignDTO.getGmail());
			campaign2.setOrganization(campaignDTO.getOrganization());
			campaign2.setVenue(campaignDTO.getVenue());
			
			
			campRepo.save(campaign2);
			return "campaign data updated";
		}
		else {
			System.out.println("campaing not found");
			return "campaign data not updated";
		}
		
	}
	
	public boolean cancelCampaign(int id) {
		  Optional<Campaign> campaign = campRepo.findById(id);
		    if (campaign.isPresent()) {
		        campRepo.deleteById(id);
		        return true;
		    } else {
		        return false;
		    }
	}
	
	public long countCampaign() {
		long count=campRepo.countCampaign();
		return count;
	}
}
