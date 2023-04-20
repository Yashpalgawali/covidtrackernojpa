package com.example.demo.service;

import java.util.List;

import com.example.demo.models.City;

public interface CityService {

public boolean isSaveCity(City city);
	
	public City getCityById(String id);
	
	public List<City> getAllCities();
	
	public int updateCity(City city);
	
	public List<City> getcitybydistid(String did);
}
