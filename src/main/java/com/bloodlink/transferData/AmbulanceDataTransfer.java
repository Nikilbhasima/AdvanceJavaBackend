package com.bloodlink.transferData;

import java.util.List;

import com.bloodlink.model.Address;
import com.bloodlink.model.DriverPhone;

;

public class AmbulanceDataTransfer {
	private int id;

	private String hospital;

	private String hphone;

	private Address address;

	private String driver;

	private List<DriverPhone> phoneD;

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

	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
