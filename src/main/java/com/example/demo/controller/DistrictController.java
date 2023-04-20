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

import com.example.demo.models.District;
import com.example.demo.models.State;
import com.example.demo.service.DistrictService;
import com.example.demo.service.StateService;

@Controller
public class DistrictController {

	@Autowired
	StateService stateserv;
	
	@Autowired
	DistrictService distserv;
	
	@GetMapping("/adddistrict")
	public String addDistrict(Model model)
	{
		List<State> slist = stateserv.getAllStates();
		model.addAttribute("slist", slist);
		return "AddDistrict";
	}
	
	@RequestMapping("/savedistrict")
	public String saveDistrict(@ModelAttribute("District")District district,RedirectAttributes attr)
	{
		boolean res = distserv.isSaveDistrict(district); 
		if(res)
		{
			attr.addFlashAttribute("response", "District is saved Successfully");
			return "redirect:/viewdistrict";
		}
		else{
			attr.addFlashAttribute("reserr", "District is not saved ");
			return "redirect:/viewdistrict";
		}
	}
	
	@GetMapping("/viewdistrict")
	public String viewdistrict(Model model)
	{
		List<District> dlist = distserv.getAllDistricts();
		
		model.addAttribute("dlist", dlist);
		return "ViewDistricts";
	}
	
	@RequestMapping("/editdistbyid/{id}")
	public String editDistrictById(@PathVariable("id")String id, Model model, RedirectAttributes attr)
	{
		District dist =  distserv.getDistrictByDistId(id);
		
		if(dist!=null)
		{
			List<State> slist = stateserv.getAllStates();
			model.addAttribute("slist", slist);
			model.addAttribute("district", dist);
			return "EditDistrict";
		}	
		else {
			attr.addFlashAttribute("reserr", "No District found for given Id");
			return "redirect:/viewdistrict";
		}
	}
	
	@RequestMapping("/updatedistrict")
	public String updateDistrict(@ModelAttribute("District")District dist,RedirectAttributes attr)
	{
		int res = distserv.updateDistrict(dist);
		if(res > 0 )
		{
			attr.addFlashAttribute("response", "District is updated successfully");
			return "redirect:/viewdistrict";
		}
		else {
			attr.addFlashAttribute("reserr", " District is not updated ");
			return "redirect:/viewdistrict";
		}
	}
	
	@RequestMapping("/getdistbystateid/{id}")
	@ResponseBody
	public List<District> getDistrictByStateId(@PathVariable("id")String id,RedirectAttributes attr)
	{
		List<District> dlist = distserv.getDistrictByStateId(id);
		
		return dlist;
	}
}
