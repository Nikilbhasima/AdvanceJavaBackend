package com.bloodlink.model;

import java.sql.Date;


import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class RequestBlood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String bloodGrp;

	@ManyToOne
	@JoinColumn(name="addressId")
	@JsonIgnore
	private Address addressId;
	
	private int unit;

	private Date date;

	private String cases;

	private LocalTime time;

	private String Hospital;

	private String phone;

	private String contact;
	
	private String patient;
	
	private String status;

	@ManyToOne
	@JoinColumn(name = "reqId")
	@JsonIgnore
	private Donor requester;
	

	@ManyToMany
	@JoinTable(name="request_donor",joinColumns = {@JoinColumn(name="requestId")},
	inverseJoinColumns = {@JoinColumn(name="donorId")})
	@JsonIgnore
	private List<Donor> acceptedList;

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

	

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
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
		return Hospital;
	}

	public void setHospital(String hospital) {
		Hospital = hospital;
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

	public Donor getRequester() {
		return requester;
	}

	public void setRequester(Donor requester) {
		this.requester = requester;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Donor> getAcceptedList() {
		return acceptedList;
	}

	public void setAcceptedList(List<Donor> acceptedList) {
		this.acceptedList = acceptedList;
	}


	
	

}
