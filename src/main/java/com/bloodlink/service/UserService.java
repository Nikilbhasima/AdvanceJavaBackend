package com.bloodlink.service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import com.bloodlink.jpaRepository.AddressRepository;
import com.bloodlink.jpaRepository.DonorRepository;
import com.bloodlink.model.Address;
import com.bloodlink.model.Donor;
import com.bloodlink.modelDTO.UserDTO;
import com.bloodlink.transferData.DonorData;



@Service
public class UserService {

	@Autowired
	private DonorRepository donorRepo;
	
	@Autowired
	private AddressRepository addRepo;
	
	public List<Donor> getAllData(){
		return donorRepo.findAll();
	}
	
	public String setUser(UserDTO usDto) {
		
		boolean isThere=donorRepo.existsByPhone(usDto.getPhone());
		if(isThere) {
			return "exist";
		}
		Optional<Address> address=addRepo.findById(usDto.getAddress());
		Donor donor=new Donor();
		donor.setUsername(usDto.getUsername());
		donor.setBloodGrp(usDto.getBloodGrp());
		donor.setDate(usDto.getDate());
		donor.setGender(usDto.getGender());
		donor.setAddressId(address.get());;
		String hashPassowrd=DigestUtils.sha256Hex(usDto.getPassword().getBytes());
//		donor.setPassword(usDto.getPassword());
		donor.setPassword(hashPassowrd);
		
		donor.setGmail(usDto.getGmail());
		donor.setPhone(usDto.getPhone());
		donor.setAvailability("available");
		
		donorRepo.save(donor);
		return "User inserted Successfully";
	}
	
	public boolean checkCredentialValidation(UserDTO userDTO) {
		
		String hpwd=DigestUtils.sha256Hex(userDTO.getPassword().getBytes());
		
		if(donorRepo.existsByPhoneAndPassword(userDTO.getPhone(),hpwd)) {
			return true;
		}else {
			return false;
		}	
	}
	
	public void uploadImg(MultipartFile file,int id) {
		System.out.println("i am pikachu");
		Optional<Donor> donor=donorRepo.findById(id);
		Donor donor2=donor.get();
		try {
			donor2.setImgData(file.getBytes());
			donorRepo.save(donor2);
		}catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public ResponseEntity<Resource> getImageData(int id) {
		Optional<Donor> donor=donorRepo.findById(id);
		
		if (donor.isPresent()) {
            Donor donor2 = donor.get();
            byte[] imgData = donor2.getImgData();
            if (imgData != null) {
                ByteArrayResource arrayResource = new ByteArrayResource(imgData);
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE);

                return ResponseEntity.ok()
                        .headers(headers)
                        .contentLength(imgData.length)
                        .body(arrayResource);
            } else {	
                return ResponseEntity.noContent().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	
	public DonorData getParticularUser(int id) {
		Optional<Donor> donor=donorRepo.findById(id);
		
		Donor donor2=donor.get();
		DonorData data=new DonorData();
		data.setId(donor2.getId());
		data.setUsername(donor2.getUsername());
		data.setBloodGrp(donor2.getBloodGrp());
		data.setDate(donor2.getDate());
		data.setGender(donor2.getGender());
		data.setGmail(donor2.getGmail());
		data.setPhone(donor2.getPhone());
		data.setImgData(donor2.getImgData());
		data.setAvailability(donor2.getAvailability());
		
		
		Optional<Address> address=addRepo.findById(donor2.getAddressId().getId());
		
		if(address.isPresent()) {
			Address address2=address.get();
			System.out.println(address2.getId());
			data.setAddress(address2.getLocation());
			return data;
		}else {
			System.out.println("no address found");
			return null;
		}
		
	}
	
	public Donor getByPhoneAndPassword(UserDTO dto) {
		String hpwd=DigestUtils.sha256Hex(dto.getPassword().getBytes());
		Donor donor=donorRepo.findByPhoneAndPassword(dto.getPhone(),hpwd);
		return donor;
	}
	
	public boolean checkingPassword(int id,UserDTO dto) {
		System.out.println("i was called");
		Optional<Donor> donor=donorRepo.findById(id);

		if(donor.isPresent()) {
			Donor donor2=donor.get();
			String password=dto.getPassword();
			String hpwd=DigestUtils.sha256Hex(dto.getPassword().getBytes());
			String passwordD=donor2.getPassword();
			if(hpwd.equals(passwordD)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean updateUserPassword(int id, UserDTO dto) {
		Optional<Donor> donor=donorRepo.findById(id);
		System.out.println("hello:"+id);
		if(donor.isPresent()) {
			Donor donor2=donor.get();
			String hpwd=DigestUtils.sha256Hex(dto.getPassword().getBytes());
			donor2.setPassword(hpwd);
			donorRepo.save(donor2);
			return true;
		}
		return false;
	}
	
	
	public void updateUserDetail(int id, UserDTO dto) {
		System.out.println(id);
		 Optional<Address> address=addRepo.findById(dto.getAddress());
		 Address address2=address.get();
		 
		 Optional<Donor> donor=donorRepo.findById(id);
		 Donor donor2=donor.get();
		 
		 donor2.setAddressId(address2);
		 donor2.setUsername(dto.getUsername());
		 donor2.setBloodGrp(dto.getBloodGrp());
		 donor2.setDate(dto.getDate());
		 donor2.setGmail(dto.getGmail());
		 donor2.setPhone(dto.getPhone());
		 
		 donorRepo.save(donor2);
	}
	
	public long countUser() {
		long users=donorRepo.getNumberOfUser();
		return users;
	}
}
