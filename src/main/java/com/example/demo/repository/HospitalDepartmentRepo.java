package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.HospitalDepartment;

public interface HospitalDepartmentRepo {

	public int addHospitalDepartment(HospitalDepartment hdept);
	
	public List<HospitalDepartment> getAllHospitalDepartments();
	
	public HospitalDepartment gethospitalDepartmentByDeptId(String depid);
	
	public  int updateHospitalDeparment(HospitalDepartment hdept);
	
	public List<HospitalDepartment> getHospitalDepartmentsByHospitalId(String hosp_id);
	
}
