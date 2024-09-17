package com.bloodlink.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String location;

	@OneToMany(mappedBy = "addressId")
	private List<Donor> donorList;

	@OneToMany(mappedBy = "addressId")
	private List<RequestBlood> requestBloodList;

	@OneToMany(mappedBy = "address")
	private List<Ambulance> aList;

	@OneToMany(mappedBy = "addressId")
	private List<Campaign> campaignList;

	public List<Campaign> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(List<Campaign> campaignList) {
		this.campaignList = campaignList;
	}

	public List<Ambulance> getaList() {
		return aList;
	}

	public void setaList(List<Ambulance> aList) {
		this.aList = aList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Donor> getDonorList() {
		return donorList;
	}

	public void setDonorList(List<Donor> donorList) {
		this.donorList = donorList;
	}

	public List<RequestBlood> getRequestBloodList() {
		return requestBloodList;
	}

	public void setRequestBloodList(List<RequestBlood> requestBloodList) {
		this.requestBloodList = requestBloodList;
	}

}
