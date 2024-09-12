package com.bloodlink.modelDTO;

import java.util.List;

import com.bloodlink.model.DriverPhone;



public class AmbulanceDTO {
	
	private int id;

	private String hospital;

	private String hphone;


	private int address;

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


	public int getAddress() {
		return address;
	}


	public void setAddress(int address) {
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


	@Override
	public String toString() {
		return "AmbulanceDTO [id=" + id + ", hospital=" + hospital + ", hphone=" + hphone + ", address=" + address
				+ ", driver=" + driver + ", phoneD=" + phoneD + "]";
	}
	
}
