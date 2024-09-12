package com.bloodlink.modelDTO;

import java.sql.Date;

import java.util.List;
import com.bloodlink.model.RequestBlood;


public class UserDTO {
	
	private int id;

	private String username;

	private String bloodGrp;

	private int address;

	private Date date;

	private String gmail;

	private String gender;

	private String phone;

	private String password;
	
	private List<RequestBlood> reqList;
	
	private byte[] imgData;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBloodGrp() {
		return bloodGrp;
	}

	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RequestBlood> getReqList() {
		return reqList;
	}

	public void setReqList(List<RequestBlood> reqList) {
		this.reqList = reqList;
	}

	public byte[] getImgData() {
		return imgData;
	}

	public void setImgData(byte[] imgData) {
		this.imgData = imgData;
	}
	
}
