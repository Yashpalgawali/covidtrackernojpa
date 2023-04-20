package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.Zip;

public interface ZipRepo {

	public boolean saveZipCode(Zip zip );
	
	public Zip getZipByZipId(String zid);
	
	public List<Zip> getAllZips();
	
	public List<Zip> getZipByCityId(String cid);
	
	public int updateZipCode(Zip zip);
}
