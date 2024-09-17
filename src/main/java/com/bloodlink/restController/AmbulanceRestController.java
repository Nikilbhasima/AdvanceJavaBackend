package com.bloodlink.restController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodlink.model.Ambulance;
import com.bloodlink.modelDTO.AmbulanceDTO;
import com.bloodlink.service.AmbulanceService;
import com.bloodlink.transferData.AmbulanceDataTransfer;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AmbulanceRestController {
	
	@Autowired
	private AmbulanceService ambS;
	
	@PostMapping("/insertAmbulanceData")
	public String insertAmbulanceDetail(@RequestBody AmbulanceDTO ambulanceDTO) {
		return ambS.setAmbulanceData(ambulanceDTO);
	}
	
	@GetMapping("/getAmbulanceData")
	public List<AmbulanceDataTransfer> getAmbulances(){
		return ambS.getAmbulance();
	}
	
	@PostMapping("/updateAmbulanceDetail")
	public String updateAmbulanceDetail(@RequestBody AmbulanceDTO ambulanceDTO) {
		
		return ambS.updateAmbulanceData(ambulanceDTO);
	}
	
	@GetMapping("numberOfAmbulance")
	public long numberOfAmbulance() {
		return ambS.countAmbulance();
	}
	
}
