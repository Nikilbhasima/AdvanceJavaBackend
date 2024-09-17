package com.bloodlink.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodlink.model.Campaign;
import com.bloodlink.modelDTO.CampaignDTO;
import com.bloodlink.service.CampaignService;
import com.bloodlink.transferData.CampaignDataTransfer;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class CampaignRestController {

	@Autowired
	private CampaignService campS;
	
	@GetMapping("/campaignData")
	public List<CampaignDataTransfer> getCampaignDetail(){
		return campS.getAllCampaignData();
	}
	
	@PostMapping("/insertCampaign")
	public String insertCampaignData(@RequestBody CampaignDTO campaignDTO ) {
		System.out.println("i was called:"+campaignDTO.getAddress());
		System.out.println("organization:"+campaignDTO.getOrganization());
		return campS.insertData(campaignDTO);
	}
	
	@PutMapping("/updateCampaignData")
	public String updateCampaignData(@RequestBody CampaignDTO campaignDTO) {
		System.out.println(campaignDTO.getOrganization());
		System.out.println(campaignDTO.getId());
		return campS.updateCampaign(campaignDTO);
	}
	
	@DeleteMapping("/deleteCampaign/{id}")
	public boolean deleteCampaign(@PathVariable("id") int id) {
		if(campS.cancelCampaign(id)) {
			System.out.println("campaign deleted successfully");
			return true;
		}
		return false;
	}
	
	@GetMapping("/numberOfCampaign")
	public long numberOfCampaign() {
		return campS.countCampaign();
	}
}
