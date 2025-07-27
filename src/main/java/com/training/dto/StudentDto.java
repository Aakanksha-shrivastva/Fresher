package com.training.dto;

import java.util.Set;

public class StudentDto {

    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private String gender;
    private Set<Integer> courseid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Set<Integer> getCourseid() {
		return courseid;
	}
	public void setCourseid(Set<Integer> courseid) {
		this.courseid = courseid;
	}
	
	
}
