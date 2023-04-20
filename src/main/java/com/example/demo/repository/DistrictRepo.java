package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.District;

public interface DistrictRepo {

public boolean isSaveDistrict(District dist);
	
	public List<District> getAllDistricts();
	
	public District getDistrictByDistId(String id);
	
	public int updateDistrict(District dist);
	
	public List<District> getDistrictByStateId(String stateid);
	
}
