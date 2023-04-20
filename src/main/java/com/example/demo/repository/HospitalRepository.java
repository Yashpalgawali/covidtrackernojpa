package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.Hospital;

public interface HospitalRepository {

	public boolean isSaveHospital(Hospital hosp);
	
	public List<Hospital> getAllHospitals();
	
	public Hospital getHospitalByHospId(String hospid);
	
	public int updateHospital(Hospital hosp);
}