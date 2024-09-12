package com.bloodlink.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Ambulance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String hospital;

	private String hphone;

	@ManyToOne
	@JoinColumn(name="addressId")
	@JsonIgnore
	private Address addressId;

	private String driver;

	@OneToMany(mappedBy = "ambulance")
	@JsonManagedReference
	private List<DriverPhone> phoneD;
	

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public List<DriverPhone> getPhoneD() {
		return phoneD;
	}

	public void setPhoneD(List<DriverPhone> phoneD) {
		this.phoneD = phoneD;
	}

}
