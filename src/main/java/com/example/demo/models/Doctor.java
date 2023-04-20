package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

	private Long hosp_doc_id;
	
	private String hosp_doc_name;
	
	private String hosp_doc_email;
	
	private String hosp_doc_contact;
	
	private String hop_doc_address;
	
	private String qualification;
	
	private String specialization;
	
	private Long hosp_id;
	
	private Long desig_id;
	
}
