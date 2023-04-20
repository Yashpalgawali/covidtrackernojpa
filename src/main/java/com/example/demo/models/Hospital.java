package com.example.demo.models;

public class Hospital {


	private Long hosp_id;
	
	private String hosp_name;
	
	private String hosp_email;
	
	private String hosp_address;
	
	private String hosp_contact;
	
	private String hosp_reg_num;
	
	private Long zip_id;
	
	private String zipcode;
	
	private Long dist_id ;
	
	private String dist_name;
	
	private Long city_id ;
	
	private String city_name;
	
	private Long  state_id;
	
	private String state_name;

	public Long getHosp_id() {
		return hosp_id;
	}

	public void setHosp_id(Long hosp_id) {
		this.hosp_id = hosp_id;
	}

	public String getHosp_name() {
		return hosp_name;
	}

	public void setHosp_name(String hosp_name) {
		this.hosp_name = hosp_name;
	}

	public String getHosp_email() {
		return hosp_email;
	}

	public void setHosp_email(String hosp_email) {
		this.hosp_email = hosp_email;
	}

	public String getHosp_address() {
		return hosp_address;
	}

	public void setHosp_address(String hosp_address) {
		this.hosp_address = hosp_address;
	}

	public String getHosp_contact() {
		return hosp_contact;
	}

	public void setHosp_contact(String hosp_contact) {
		this.hosp_contact = hosp_contact;
	}

	public String getHosp_reg_num() {
		return hosp_reg_num;
	}

	public void setHosp_reg_num(String hosp_reg_num) {
		this.hosp_reg_num = hosp_reg_num;
	}

	public Long getZip_id() {
		return zip_id;
	}

	public void setZip_id(Long zip_id) {
		this.zip_id = zip_id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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

	public Hospital(Long hosp_id, String hosp_name, String hosp_email, String hosp_address, String hosp_contact,
			String hosp_reg_num, Long zip_id, String zipcode, Long dist_id, String dist_name, Long city_id,
			String city_name, Long state_id, String state_name) {
		super();
		this.hosp_id = hosp_id;
		this.hosp_name = hosp_name;
		this.hosp_email = hosp_email;
		this.hosp_address = hosp_address;
		this.hosp_contact = hosp_contact;
		this.hosp_reg_num = hosp_reg_num;
		this.zip_id = zip_id;
		this.zipcode = zipcode;
		this.dist_id = dist_id;
		this.dist_name = dist_name;
		this.city_id = city_id;
		this.city_name = city_name;
		this.state_id = state_id;
		this.state_name = state_name;
	}

	public Hospital() {}
	
	
}
