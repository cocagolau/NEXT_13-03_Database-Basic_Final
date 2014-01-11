package com.dbbasic.model;

public class Subview {
	private int id;
	private String fileName;
	private int hits;
	private int price;
	private String carName;
	private String companyName;
		
	public Subview (int id, String fileName, int hits, int price, String carName, String companyName) {
		this.id = id;
		this.fileName = fileName;
		this.hits = hits;
		this.price = price;
		this.carName = carName;
		this.companyName = companyName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



}
