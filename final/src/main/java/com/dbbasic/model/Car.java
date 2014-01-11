package com.dbbasic.model;

public class Car {

	private int id;
	private String companyName;
	private String name;
	private String type;
	private String engineType;
	private int engineDisplacement;
	private String engineGasType;
	private float engineGasEfficiency;
	private int engineOutput;
	private String driveType;
	private String gearbox;
	private int passenger;
	private int modelYear;
	
	
	public Car (int id, String companyName, String name, String type, String engineType, int engineDisplacement, String engineGasType, float engineGasEfficiency, int engineOutput, String driveType, String gearbox, int passenger, int modelYear) {
		this.id = id;
		this.companyName = companyName;
		this.name = name;
		this.type = type;
		this.engineType = engineType;
		this.engineDisplacement = engineDisplacement;
		this.engineGasType = engineGasType;
		this.engineGasEfficiency = engineGasEfficiency;
		this.engineOutput = engineOutput;
		this.driveType = driveType;
		this.gearbox = gearbox;
		this.passenger = passenger;
		this.modelYear = modelYear;
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getEngineType() {
		return engineType;
	}


	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}


	public int getEngineDisplacement() {
		return engineDisplacement;
	}


	public void setEngineDisplacement(int engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}


	public String getEngineGasType() {
		return engineGasType;
	}


	public void setEngineGasType(String engineGasType) {
		this.engineGasType = engineGasType;
	}


	public float getEngineGasEfficiency() {
		return engineGasEfficiency;
	}


	public void setEngineGasEfficiency(float engineGasEfficiency) {
		this.engineGasEfficiency = engineGasEfficiency;
	}


	public int getEngineOutput() {
		return engineOutput;
	}


	public void setEngineOutput(int engineOutput) {
		this.engineOutput = engineOutput;
	}


	public String getDriveType() {
		return driveType;
	}


	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}


	public String getGearbox() {
		return gearbox;
	}


	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}


	public int getPassenger() {
		return passenger;
	}


	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}


	public int getModelYear() {
		return modelYear;
	}


	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	
	
	
	
	
}
