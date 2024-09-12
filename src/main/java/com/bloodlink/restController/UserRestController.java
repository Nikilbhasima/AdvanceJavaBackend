package com.bloodlink.restController;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bloodlink.model.Donor;
import com.bloodlink.modelDTO.UserDTO;
import com.bloodlink.service.UserService;
import com.bloodlink.transferData.DonorData;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class UserRestController {
	
	@Autowired
	private UserService userSer;
	
	
	@GetMapping("/users")
	public List<Donor> getData(){
		return userSer.getAllData();
	}
	
	@GetMapping("/getUserData")
	public DonorData getUserData(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		return userSer.getParticularUser(donor.getId());
	}
	
	@PostMapping(value="/setUser", consumes = "application/json")
	public String insertUser(@RequestBody UserDTO userDTO ) {
		return userSer.setUser(userDTO);
	}
	
	@PostMapping("/checkCredential")
	public boolean checkCredential(@RequestBody UserDTO userDTO,HttpServletRequest request) {
		HttpSession session=request.getSession();
		boolean isThere=(boolean) userSer.checkCredentialValidation(userDTO);
		if(isThere) {
			Donor donor=userSer.getByPhoneAndPassword(userDTO);
			System.out.println(donor.getId());
			System.out.println(donor.getBloodGrp());
			session.setAttribute("userInfo", donor);
			return true;
		}
		return false;
	}
	
	
	@PostMapping("/upload")
	public void uploadDonorImg(@RequestParam("imgData") MultipartFile file,HttpServletRequest request ) {
		System.out.println("Hello before session");
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		userSer.uploadImg(file,donor.getId());
//		userSer.uploadImg(file,1);
		System.out.println("Uploading images");
	}
	
	@GetMapping("/getImg")
	public ResponseEntity<Resource> getDonorImg(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
	    return userSer.getImageData(donor.getId());
	}
	
	@PostMapping("/checkPassword")
	public boolean checkPassword(HttpServletRequest request, @RequestBody UserDTO dto) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		System.out.println(dto.getPassword());
		System.out.println("i am calling"+":"+donor.getUsername());
		if(userSer.checkingPassword(donor.getId(), dto)) {
			return true;
		}
		return false;
	}
	
	@PostMapping("/changePassword")
	public boolean changePassword(HttpServletRequest request,@RequestBody UserDTO dto) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		System.out.println("hello1"+donor.getId());
		
		if(userSer.updateUserPassword(donor.getId(), dto)) {
			return true;
		}
		
		return false;
	}
	
	@PostMapping("/changeUserDetail")
	public void ChangeUserDetail(HttpServletRequest request, @RequestBody UserDTO dto) {
		HttpSession session=request.getSession();
		Donor donor=(Donor) session.getAttribute("userInfo");
		userSer.updateUserDetail(donor.getId(), dto);
	}
	
	@PostMapping("/logout")
	public boolean logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		System.out.println("Session has been invalid");
		return true;
	}


}
