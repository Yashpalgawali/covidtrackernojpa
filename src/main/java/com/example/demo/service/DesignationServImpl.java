package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Designation;
import com.example.demo.repository.DesignationRepo;

@Service("desigserv")
public class DesignationServImpl implements DesignationService {

	@Autowired
	DesignationRepo desigrepo;
	
	@Override
	public int saveDesignation(Designation desig) {
		// TODO Auto-generated method stub
		return desigrepo.saveDesignation(desig);
	}

	@Override
	public List<Designation> getAllDesignations() {
		// TODO Auto-generated method stub
		return desigrepo.getAllDesignations();
	}

	@Override
	public Designation getDesignationById(String id) {
		// TODO Auto-generated method stub
		return desigrepo.getDesignationById(id);
	}

	@Override
	public int updateDesignation(Designation desig) {
		// TODO Auto-generated method stub
		return desigrepo.updateDesignation(desig);
	}

}
