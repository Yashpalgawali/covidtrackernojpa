package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.City;
import com.example.demo.models.State;
import com.example.demo.service.CityService;
import com.example.demo.service.DistrictService;
import com.example.demo.service.StateService;

@Controller
public class CityController {

	@Autowired
	StateService stateserv;
	
	@Autowired
	DistrictService distserv;
	
	@Autowired
	CityService cityserv;
	
	@GetMapping("/addcity")
	public String addCity(Model model)
	{
		List<State> slist= stateserv.getAllStates();
		model.addAttribute("slist", slist);
		return "AddCity";
	}
	
	@RequestMapping("/savecity")
	public String saveCity(@ModelAttribute("City")City city,RedirectAttributes attr)
	{
		boolean result = cityserv.isSaveCity(city);
		if(result)
		{
			attr.addFlashAttribute("response", "City is saved Successfully");
			return "redirect:/viewcity";
		}
		else {
			attr.addFlashAttribute("reserr", "City is not saved ");
			return "redirect:/viewcity";
		}
	}
	
	
	@GetMapping("/viewcity")
	public String viewCity(Model model)
	{
		List<City> slist= cityserv.getAllCities();
		
		slist.stream().forEach(e->System.err.println(e));
		
		model.addAttribute("clist", slist);
		return "ViewCity";
	}
	
	@RequestMapping("/editcitybyid/{id}")
	public String editCityById(@PathVariable("id") String id,Model model, RedirectAttributes attr)
	{
		City city =cityserv.getCityById(id);
		
		if(city!=null)
		{
			List<State> slist= stateserv.getAllStates();
			model.addAttribute("slist", slist);
			model.addAttribute("city", city);
			return "EditCity";
		}
		else {
			attr.addFlashAttribute("reserr", "No City found for given ID");
			return "redirect:/viewcity";
		}
	}
	
	@RequestMapping("/updatecity")
	public String updateCity(@ModelAttribute("City")City city,RedirectAttributes attr)
	{
		int res =cityserv.updateCity(city);
		if(res >0)
		{
			attr.addFlashAttribute("response", "City is updated Successfully");
			return "redirect:/viewcity";
		}
		else {
			attr.addFlashAttribute("reserr", "City is not updated ");
			return "redirect:/viewcity";
		}
	}

	@RequestMapping("/getcitybydistid/{id}")
	@ResponseBody
	public List<City> getCityByDistrictId(@PathVariable("id")String id)
	{
		return cityserv.getcitybydistid(id);
	}
	
}
