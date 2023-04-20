package com.example.demo.models;

public class District {

	private Long dist_id;
	
	private String dist_name;
	
	private Long state_id;

	private String state_name;
	
	
	
	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public Long getDist_id() {
		return dist_id;
	}

	public void setDist_id(Long dist_id) {
		this.dist_id = dist_id;
	}

	public String getDist_name() {
		return dist_name;
	}

	public void setDist_name(String dist_name) {
		this.dist_name = dist_name;
	}

	public Long getState_id() {
		return state_id;
	}

	public void setState_id(Long state_id) {
		this.state_id = state_id;
	}
	
	
	
}
