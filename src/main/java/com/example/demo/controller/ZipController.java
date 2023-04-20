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
import com.example.demo.models.Zip;
import com.example.demo.service.CityService;
import com.example.demo.service.StateService;
import com.example.demo.service.ZipService;

@Controller
public class ZipController {

	@Autowired
	CityService cityserv;
	
	@Autowired
	ZipService zipserv;
	
	@Autowired
	StateService stateserv;
	
	@GetMapping("/addzip")
	public String addZip(Model model)
	{
		List<State> slist = stateserv.getAllStates();
		
		model.addAttribute("slist", slist);
		return "AddZip";
	}
	
	@GetMapping("/viewzip")
	public String viewZip(Model model)
	{
		List<Zip> zlist = zipserv.getAllZips();
		
		model.addAttribute("zlist", zlist);
		return "ViewZip";
	}
	
	@RequestMapping("/savezip")
	public String saveZipCode(@ModelAttribute("Zip")Zip zip,RedirectAttributes attr)
	{
		boolean res = zipserv.saveZipCode(zip);
		if(res)
		{
			attr.addFlashAttribute("response", "ZipCode is saved successfully");
			return "redirect:/viewzip";
		}
		else{
			attr.addFlashAttribute("reserr", "ZipCode is not saved ");
			return "redirect:/viewzip";
		}
	}
	
	@RequestMapping("/editzipbyid/{id}")
	public String editZipCode(@PathVariable("id") String id,Model model, RedirectAttributes attr)
	{
		Zip zip = zipserv.getZipByZipId(id);
		if(zip!=null)
		{
			List<State> slist = stateserv.getAllStates();
			
			model.addAttribute("slist", slist);
			model.addAttribute("zip", zip);
			
			return "EditZip";
		}
		else {
			model.addAttribute("reserr", "No Zip Code found for given ID");
			return "redirect:/viewzip";
		}
	}
	
	@RequestMapping("/updatezip")
	public String updateZip(@ModelAttribute("Zip")Zip zip,RedirectAttributes attr)
	{
		int res = zipserv.updateZipCode(zip);
		
		if(res > 0)
		{
			attr.addFlashAttribute("response", "ZipCode is update successfully");
			return "redirect:/viewzip";
		}
		else{
			attr.addFlashAttribute("reserr", "ZipCode is not updated ");
			return "redirect:/viewzip";
		}
	}
	
	
	@RequestMapping("/getzipbycityid/{id}")
	@ResponseBody
	public List<Zip> getZipCodesByCityId(@PathVariable("id") String id)
	{
		List<Zip> zlist = zipserv.getZipByCityId(id);
		return zlist;
	}
	
}
