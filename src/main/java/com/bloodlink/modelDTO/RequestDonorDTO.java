package com.bloodlink.modelDTO;

import java.sql.Date;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import com.bloodlink.model.Donor;




public class RequestDonorDTO {
	private int id;

	private String bloodGrp;

	private int addressId;

	private int unit;

	private Date date;

	private String cases;

	private LocalTime time;

	private String hospital;

	private String phone;

	private String contact;
	
	private String patient;
	
	private String status;
	
	private List<Donor> donorlist;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBloodGrp() {
		return bloodGrp;
	}

	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCases() {
		return cases;
	}

	public void setCases(String cases) {
		this.cases = cases;
	}

	
	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public List<Donor> getDonorlist() {
		return donorlist;
	}

	public void setDonorlist(List<Donor> donorlist) {
		this.donorlist = donorlist;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
