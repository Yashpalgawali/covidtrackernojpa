package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Zip;

public interface ZipService {
	
	public boolean saveZipCode(Zip zip );
	
	public Zip getZipByZipId(String zid);
	
	public List<Zip> getAllZips();
	
	public  List<Zip> getZipByCityId(String cid);
	
	public int updateZipCode(Zip zip);
}
