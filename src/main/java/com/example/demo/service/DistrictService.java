package com.example.demo.service;

import java.util.List;

import com.example.demo.models.District;

public interface DistrictService {

	public boolean isSaveDistrict(District dist);
	
	public List<District> getAllDistricts();
	
	public District getDistrictByDistId(String id);
	
	public int updateDistrict(District dist);
	
	public List<District> getDistrictByStateId(String stateid);
	
}
