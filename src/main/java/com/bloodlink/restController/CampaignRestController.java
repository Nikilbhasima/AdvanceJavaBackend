package com.bloodlink.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodlink.model.Campaign;
import com.bloodlink.modelDTO.CampaignDTO;
import com.bloodlink.service.CampaignService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class CampaignRestController {

	@Autowired
	private CampaignService campS;
	
	@GetMapping("/campaignData")
	public List<Campaign> getCampaignDetail(){
		return campS.getAllCampaignData();
	}
	
	@PostMapping("/insertCampaign")
	public String insertCampaignData(@RequestBody CampaignDTO campaignDTO ) {
		
		return campS.insertData(campaignDTO);
	}
}
