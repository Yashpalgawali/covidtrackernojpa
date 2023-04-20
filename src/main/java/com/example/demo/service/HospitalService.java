package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Hospital;

public interface HospitalService {

public boolean isSaveHospital(Hospital hosp);
	
	public List<Hospital> getAllHospitals();
	
	public Hospital getHospitalByHospId(String hospid);
	
	public int updateHospital(Hospital hosp);
	
	
}
