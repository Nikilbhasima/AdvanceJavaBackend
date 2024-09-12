package com.bloodlink.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	private String bloodGrp;

	@ManyToOne
	@JoinColumn(name="addressId")
	@JsonIgnore
	private Address addressId;

	private Date date;

	private String gmail;

	private String gender;

	private String phone;

	private String password;
	
	@OneToMany(mappedBy = "requester")
	private List<RequestBlood> reqList;
	
	@Lob
	@JdbcTypeCode(SqlTypes.VARBINARY)
	private byte[] imgData;
	

	private String Availability;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBloodGrp() {
		return bloodGrp;
	}

	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	
	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RequestBlood> getReqList() {
		return reqList;
	}

	public void setReqList(List<RequestBlood> reqList) {
		this.reqList = reqList;
	}

	public byte[] getImgData() {
		return imgData;
	}

	public void setImgData(byte[] imgData) {
		this.imgData = imgData;
	}

	

	public String getAvailability() {
		return Availability;
	}

	public void setAvailability(String availability) {
		Availability = availability;
	}



}
