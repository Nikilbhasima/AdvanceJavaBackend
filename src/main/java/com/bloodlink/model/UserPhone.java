package com.bloodlink.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


public class UserPhone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = "reqId")
	private RequestBlood reqeuster;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public RequestBlood getReqeuster() {
		return reqeuster;
	}

	public void setReqeuster(RequestBlood reqeuster) {
		this.reqeuster = reqeuster;
	}

	

	
	
	
}
