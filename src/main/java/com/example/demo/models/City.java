package com.example.demo.models;



public class City {

	private Long city_id;
	
	private String city_name;
	
	private Long dist_id;
	
	private String dist_name;
	
	private Long state_id;
	
	private String state_name;

	public Long getCity_id() {
		return city_id;
	}

	public void setCity_id(Long city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
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

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public City(Long city_id, String city_name, Long dist_id, String dist_name, Long state_id, String state_name) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
		this.dist_id = dist_id;
		this.dist_name = dist_name;
		this.state_id = state_id;
		this.state_name = state_name;
	}
	
	public City() {}
	
}
