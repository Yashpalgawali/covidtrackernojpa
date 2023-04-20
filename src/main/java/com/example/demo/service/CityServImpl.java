package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.City;
import com.example.demo.repository.CityRepository;

@Service("cityserv")
public class CityServImpl implements CityService {
	
	@Autowired
	CityRepository cityrepo;
	
	@Override
	public boolean isSaveCity(City city) {
		// TODO Auto-generated method stub
		return cityrepo.isSaveCity(city);
	}

	@Override
	public City getCityById(String id) {
		// TODO Auto-generated method stub
		return cityrepo.getCityById(id);
	}

	@Override
	public List<City> getAllCities() {
		// TODO Auto-generated method stub
		return cityrepo.getAllCities();
	}

	@Override
	public int updateCity(City city) {
		// TODO Auto-generated method stub
		return cityrepo.updateCity(city);
	}

	@Override
	public List<City> getcitybydistid(String did) {
		// TODO Auto-generated method stub
		return cityrepo.getcitybydistid(did);
	}

}
