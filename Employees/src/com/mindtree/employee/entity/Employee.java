package com.mindtree.employee.entity;

public class Employee {
	 private int empId;
	  private String empName;
	//  private int totalEmpInTrack;
	  private String trackName;
	  private String phone;
	  private String role;
	  
	public Employee(int empId, String empName, String trackName, String phone, String role) {
		super();
		this.empId = empId;
		this.empName = empName;
//		this.totalEmpInTrack = totalEmpInTrack;
		this.trackName = trackName;
		this.phone = phone;
		this.role = role;
	}

	public Employee() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

/*	public int getTotalEmpInTrack() {
		return totalEmpInTrack;
	}

	public void setTotalEmpInTrack(int totalEmpInTrack) {
		this.totalEmpInTrack = totalEmpInTrack;
	}*/

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	  
	  
	  
	}
