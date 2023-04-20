package com.example.demo.models;


public class Designation {

	
	private Long desig_id;
	
	private String desig_name;
	
	private Long hosp_id;
	
	private Hospital hospital;
	
	

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Long getHosp_id() {
		return hosp_id;
	}

	public void setHosp_id(Long hosp_id) {
		this.hosp_id = hosp_id;
	}

	public Long getDesig_id() {
		return desig_id;
	}

	public void setDesig_id(Long desig_id) {
		this.desig_id = desig_id;
	}

	public String getDesig_name() {
		return desig_name;
	}

	public void setDesig_name(String desig_name) {
		this.desig_name = desig_name;
	}
	
	
	
	
}
