package com.dbbasic.model;


public class Dealer {
	
	private String email;
	private String password;
	private String name;
	private String phone;
	private String admissionDate;
	private int numOfCompletion;
	
	public Dealer (String email, String password, String name, String phone, String admissionDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.admissionDate = admissionDate;
	}
	
	public Dealer (String email, String password, String name, String phone, String admissionDate, int numOfCompetion) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.admissionDate = admissionDate;
		this.numOfCompletion = numOfCompetion;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public int getNumOfCompletion() {
		return numOfCompletion;
	}
	public void setNumOfCompletion(int numOfCompletion) {
		this.numOfCompletion = numOfCompletion;
	}
	
	

}
