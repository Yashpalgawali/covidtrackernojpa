package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.District;
import com.example.demo.repository.DistrictRepo;

@Service("distserv")
public class DistrictServImpl implements DistrictService {

	@Autowired
	DistrictRepo distrepo;
	
	@Override
	public boolean isSaveDistrict(District dist) {
		// TODO Auto-generated method stub
		return distrepo.isSaveDistrict(dist);
	}

	@Override
	public List<District> getAllDistricts() {
		// TODO Auto-generated method stub
		return distrepo.getAllDistricts();
	}

	@Override
	public District getDistrictByDistId(String id) {
		// TODO Auto-generated method stub
		return distrepo.getDistrictByDistId(id);
	}

	@Override
	public int updateDistrict(District dist) {
		// TODO Auto-generated method stub
		return distrepo.updateDistrict(dist);
	}

	@Override
	public List<District> getDistrictByStateId(String stateid) {
		// TODO Auto-generated method stub
		return distrepo.getDistrictByStateId(stateid);
	}

}
