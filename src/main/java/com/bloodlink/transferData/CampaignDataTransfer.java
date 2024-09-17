package com.bloodlink.transferData;

import java.sql.Date;
import java.time.LocalTime;

public class CampaignDataTransfer {
private int id;
	
	private String organization;
	
	private String address;
	
	private String venue;
	
	private LocalTime starting;
	
	private LocalTime ending;
	
	private Date date;
	
	private String phoneN;
	
	private String gmail;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public LocalTime getStarting() {
		return starting;
	}

	public void setStarting(LocalTime starting) {
		this.starting = starting;
	}

	public LocalTime getEnding() {
		return ending;
	}

	public void setEnding(LocalTime ending) {
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
