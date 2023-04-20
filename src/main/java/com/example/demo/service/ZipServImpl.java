package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Zip;
import com.example.demo.repository.ZipRepo;

@Service("zipserv")
public class ZipServImpl implements ZipService {

	@Autowired
	ZipRepo ziprepo;
	
	
	@Override
	public boolean saveZipCode(Zip zip) {
		// TODO Auto-generated method stub
		return ziprepo.saveZipCode(zip);
	}

	@Override
	public Zip getZipByZipId(String zid) {
		// TODO Auto-generated method stub
		return ziprepo.getZipByZipId(zid);
	}

	@Override
	public List<Zip> getAllZips() {
		// TODO Auto-generated method stub
		return ziprepo.getAllZips();
	}

	@Override
	public  List<Zip> getZipByCityId(String cid) {
		// TODO Auto-generated method stub
		return ziprepo.getZipByCityId(cid);
	}

	@Override
	public int updateZipCode(Zip zip) {
		// TODO Auto-generated method stub
		return ziprepo.updateZipCode(zip);
	}

}
