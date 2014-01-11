package com.dbbasic.model;

import java.util.Date;

public class Usedcar {
	
	private int id;
	private int mileage;
	private String color;
	private int numberOfPhoto;
	private int numberOfAccident;
	private String dealingCondition;
	private int dealingPrice;
	private String dealingSolddate;
	private String detail;
	private String registrationDate;
	private int hits;
	private int carId;
	private String dealerEmail;
	
	
	public Usedcar (int mileage, String color, String dealingCondition, int dealingPrice, String detail, int carId, String dealerEmail) {
		this.mileage = mileage;
		this.color = color;
		this.numberOfPhoto = numberOfPhoto;
		this.numberOfAccident = numberOfAccident;
		this.dealingCondition = dealingCondition;
		this.dealingPrice = dealingPrice;
		this.dealingSolddate = dealingSolddate;
		this.detail = detail;
		this.registrationDate = registrationDate;
		this.hits = hits;
		this.carId = carId;
		this.dealerEmail = dealerEmail;
	}
	
	public Usedcar (int id, int mileage, String color, int numberOfPhoto, int numberOfAccident, String dealingCondition, int dealingPrice, String dealingSolddate, String detail, String registrationDate, int hits, int carId, String dealerEmail) {
		this.id = id;
		this.mileage = mileage;
		this.color = color;
		this.numberOfPhoto = numberOfPhoto;
		this.numberOfAccident = numberOfAccident;
		this.dealingCondition = dealingCondition;
		this.dealingPrice = dealingPrice;
		this.dealingSolddate = dealingSolddate;
		this.detail = detail;
		this.registrationDate = registrationDate;
		this.hits = hits;
		this.carId = carId;
		this.dealerEmail = dealerEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberOfPhoto() {
		return numberOfPhoto;
	}

	public void setNumberOfPhoto(int numberOfPhoto) {
		this.numberOfPhoto = numberOfPhoto;
	}

	public int getNumberOfAccident() {
		return numberOfAccident;
	}

	public void setNumberOfAccident(int numberOfAccident) {
		this.numberOfAccident = numberOfAccident;
	}

	public String getDealingCondition() {
		return dealingCondition;
	}

	public void setDealingCondition(String dealingCondition) {
		this.dealingCondition = dealingCondition;
	}

	public int getDealingPrice() {
		return dealingPrice;
	}

	public void setDealingPrice(int dealingPrice) {
		this.dealingPrice = dealingPrice;
	}

	public String getDealingSolddate() {
		return dealingSolddate;
	}

	public void setDealingSolddate(String dealingSolddate) {
		this.dealingSolddate = dealingSolddate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getDealerEmail() {
		return dealerEmail;
	}

	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}

	
}
