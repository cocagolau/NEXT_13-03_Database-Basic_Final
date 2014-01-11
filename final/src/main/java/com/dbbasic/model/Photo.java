package com.dbbasic.model;

public class Photo {
	
	private int id;
	private String partName;
	private String fileName;
	private int usedcarId;
	
	public Photo (String partName, String fileName, int usedcarId) {
		this.partName = partName;
		this.fileName = fileName;
		this.usedcarId = usedcarId;
	}
	
	public Photo (int id, String partName, String fileName, int usedcarId) {
		this.id = id;
		this.partName = partName;
		this.fileName = fileName;
		this.usedcarId = usedcarId;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getUsedcarId() {
		return usedcarId;
	}

	public void setUsedcarId(int usedcarId) {
		this.usedcarId = usedcarId;
	}
	
	

}
