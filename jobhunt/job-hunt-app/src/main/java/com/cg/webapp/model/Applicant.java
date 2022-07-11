package com.cg.webapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Applicant {
	@Id
	private String name;
	private String address;
	private String gender;
	private long contact;
	private String emailId;
	private int passOutYear;
	private String branch;
	private String UniversityName;
	public String getAddress() {
		return address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getname() {
		return name;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getPassOutYear() {
		return passOutYear;
	}
	public void setPassOutYear(int passOutYear) {
		this.passOutYear = passOutYear;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getUniversityName() {
		return UniversityName;
	}
	public void setUniversityName(String universityName) {
		UniversityName = universityName;
	}


}
