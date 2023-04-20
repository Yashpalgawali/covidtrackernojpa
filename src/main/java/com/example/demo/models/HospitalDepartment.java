package com.example.demo.models;

import lombok.Data;

@Data
public class HospitalDepartment {

	
	private Long hosp_dept_id;
	
	private String hosp_dept_name;
	
	private Long hosp_id;
	
	private Hospital hospital;
	
}
