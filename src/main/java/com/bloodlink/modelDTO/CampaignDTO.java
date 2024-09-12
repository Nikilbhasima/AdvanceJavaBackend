package com.bloodlink.modelDTO;

import java.sql.Date;
import java.sql.Time;

import com.bloodlink.model.Address;



public class CampaignDTO {
	
	private int id;
	
	private String organization;
	
	private int address;
	
	private String venue;
	
	private Time starting;
	
	private Time ending;
	
	private Date date;
	
	private String phoneN;
	
	private String gmail;
	
	private String status;

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

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
