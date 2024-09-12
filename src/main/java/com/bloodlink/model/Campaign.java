package com.bloodlink.model;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Campaign {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String organization;
	
	@ManyToOne
	@JoinColumn(name="addressId")
	@JsonIgnore
	private Address addressId;
	
	private String venue;
	
	private Time starting;
	
	private Time ending;
	
	private Date date;
	
	private String phoneN;
	
	private String gmail;
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Time getStarting() {
		return starting;
	}

	public void setStarting(Time starting) {
		this.starting = starting;
	}

	public Time getEnding() {
		return ending;
	}

	public void setEnding(Time ending) {
		this.ending = ending;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhoneN() {
		return phoneN;
	}

	public void setPhoneN(String phoneN) {
		this.phoneN = phoneN;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
		
}
