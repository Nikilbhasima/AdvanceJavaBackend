package com.bloodlink.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class BloodCampaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String organization;

	@OneToOne
	@JoinColumn(name = "address")
	private Address address;

	private String venue;
	private Time starting;
	private Time ending;

	private Date date;
	private String phone;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
