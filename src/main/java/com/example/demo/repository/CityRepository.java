package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.City;

public interface CityRepository {

	public boolean isSaveCity(City city);
	
	public City getCityById(String id);
	
	public List<City> getAllCities();
	
	public int updateCity(City city);
	
	public List<City> getcitybydistid(String did);
	
}
