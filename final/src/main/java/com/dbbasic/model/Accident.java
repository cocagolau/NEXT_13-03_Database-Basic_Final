package com.dbbasic.model;

public class Accident {
	private int id;
	private String date;
	private String detail;
	private int usedcarId;
	
	public Accident (String date, String detail, int usedcarId) {
		this.date = date;
		this.detail = detail;
		this.usedcarId = usedcarId;
	}
	
	public Accident (int id, String date, String detail, int usedcarId) {
		this.id = id;
		this.date = date;
		this.detail = detail;
		this.usedcarId = usedcarId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getUsedcarId() {
		return usedcarId;
	}

	public void setUsedcarId(int usedcarId) {
		this.usedcarId = usedcarId;
	}
	
	
}
