package com.bloodlink.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bloodlink.model.Donor;
import com.bloodlink.model.RequestBlood;
import com.bloodlink.modelDTO.RequestDonorDTO;
import com.bloodlink.service.RequestBloodService;
import com.bloodlink.transferData.RequestDataTransfer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class RequestBloodRestController {

	@Autowired
	private RequestBloodService reqBloS;
	
	@GetMapping("/getRequestBlood")
	public List<RequestBlood> getRequestBloodData(){
		return reqBloS.getRequestBlood();
	}
	
	@PostMapping("/insertRequestBloodDetail")
	public boolean insertRequestBloodDetail(@RequestBody RequestDonorDTO requestDonorDTO,HttpServletRequest request) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		if(reqBloS.insertRequestData(requestDonorDTO,donor.getId())) {
			return true;
		}
		
		return false;
	}
	
	@GetMapping("/getRequestDetail")
	public List<RequestDataTransfer> getRequestDetail(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		
		return reqBloS.getRequestData(donor.getId(),donor);
	}
	
	@PutMapping("/closeRequestBlood/{id}")
	public boolean closeRequestBlood(@PathVariable("id") int id) {
		System.out.println("Requested id is:"+id);
		if(reqBloS.updateState(id)) {
			return true;
		}
		return false;
		
	}
	
	@GetMapping("/getRequestedBlood")
	public List<RequestDataTransfer> getRequestedBlood(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		
		List<RequestDataTransfer> dataTransfers=reqBloS.getRequestBloodDetail(donor.getBloodGrp(),donor.getId());
		
		return dataTransfers;
		
	}
	
	@PostMapping("/registerDonorRequest/{id}")
	public boolean registerDonorRequest(HttpServletRequest request,@PathVariable("id") int id) {
		System.out.println("Hello your are going to register");
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		if(reqBloS.recordUser(donor.getId(), id)) {
			reqBloS.updateStatus(donor.getId());
			return true;
		}
		
		return false;
	}
	
	@GetMapping("/getDonorList")
	public List<RequestDonorDTO> getDonorList(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		return reqBloS.findListOfDonor(donor.getId());
	}
	
	@GetMapping("getParticipatedList")
	public List<RequestBlood> getParticipatedList(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		
		return reqBloS.findParticipatedRequest(donor.getId());
	}
	
	@PutMapping("/makeUnavailable")
	public void setUnavailable(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		
		reqBloS.updateUnavailable(donor.getId());
		
	}
	
	@PutMapping("/makeAvailable")
	public void makeAvailable(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		reqBloS.updateAvailable(donor.getId());
	}
}
