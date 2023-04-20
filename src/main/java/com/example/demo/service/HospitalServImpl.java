package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Hospital;
import com.example.demo.repository.HospitalRepository;

@Service("hospserv")
public class HospitalServImpl implements HospitalService {

	@Autowired
	HospitalRepository hosprepo;
	
	@Override
	public boolean isSaveHospital(Hospital hosp) {
		// TODO Auto-generated method stub
		return hosprepo.isSaveHospital(hosp);
	}

	@Override
	public List<Hospital> getAllHospitals() {
		// TODO Auto-generated method stub
		return hosprepo.getAllHospitals();
	}

	@Override
	public Hospital getHospitalByHospId(String hospid) {
		// TODO Auto-generated method stub
		return hosprepo.getHospitalByHospId(hospid);
	}

	@Override
	public int updateHospital(Hospital hosp) {
		// TODO Auto-generated method stub
		return hosprepo.updateHospital(hosp);
	}

}
