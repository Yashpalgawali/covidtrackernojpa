package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Designation;

public interface DesignationService {

	public int saveDesignation(Designation desig );
	
	public List<Designation> getAllDesignations();
	
	public Designation getDesignationById(String id);
	
	public int updateDesignation(Designation desig);
	
}
