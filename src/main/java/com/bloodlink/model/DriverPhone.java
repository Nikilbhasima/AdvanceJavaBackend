package com.bloodlink.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DriverPhone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String phoneN;
	
	@ManyToOne
	@JoinColumn(name="driverID")
	 @JsonBackReference
	private Ambulance ambulance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneN() {
		return phoneN;
	}

	public void setPhoneN(String phoneN) {
		this.phoneN = phoneN;
	}

	public Ambulance getAmbulance() {
		return ambulance;
	}

	public void setAmbulance(Ambulance ambulance) {
		this.ambulance = ambulance;
	}

	@Override
	public String toString() {
		return "DriverPhone [id=" + id + ", phoneN=" + phoneN + ", ambulance=" + ambulance + "]";
	}

	

}
