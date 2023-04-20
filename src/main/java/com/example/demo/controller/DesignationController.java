package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Designation;
import com.example.demo.models.Hospital;
import com.example.demo.service.DesignationService;
import com.example.demo.service.HospitalService;

@Controller
public class DesignationController {

	@Autowired
	DesignationService desigserv;
	
	@Autowired
	HospitalService hospserv;
	
	@GetMapping("/adddesignation")
	public String addDesignation(Model model)
	{
		List<Hospital> hlist = hospserv.getAllHospitals();
		
		model.addAttribute("hlist", hlist);
		return "AddDesignation";
	}
	
	@GetMapping("/viewdesignation")
	public String viewDesignation(Model model)
	{
		List<Designation> dlist = desigserv.getAllDesignations();
		model.addAttribute("dlist", dlist);
		
		return "ViewDesignation";
	}
	
	
	@RequestMapping("/savedesignation")
	public String saveDesignation(@ModelAttribute("Designation")Designation desig,RedirectAttributes attr)
	{
		int res = desigserv.saveDesignation(desig);
		
		if(res > 0)
		{
			attr.addFlashAttribute("response", "Designation is saved Successfully");
			return "redirect:/viewdesignation";
		}
		else {
			attr.addFlashAttribute("reserr", "Designation is not saved ");
			return "redirect:/viewdesignation";
		}
	}
	
	@GetMapping("/editdesigbyid/{id}")
	public String editDesignationById(@PathVariable("id") String id,Model model ,RedirectAttributes attr)
	{
		Designation desig = desigserv.getDesignationById(id);
		if(desig!=null)
		{
			List<Hospital> hlist = hospserv.getAllHospitals();
			
			model.addAttribute("hlist", hlist);
			model.addAttribute("desig", desig);
			return "EditDesignation";
		}
		else {
			attr.addFlashAttribute("reserr", "No Designation for given Id");
			return "redirect:/viewdesignation";
		}
	}
	
	@RequestMapping("/updatedesignation")
	public String updateDesignation(@ModelAttribute("Designation") Designation desig,RedirectAttributes attr)
	{
		int res  = desigserv.updateDesignation(desig);
		if(res>0)
		{
			attr.addFlashAttribute("response", "Designation is updated Successfully");
			return "redirect:/viewdesignation";
		}
		else {
			attr.addFlashAttribute("reserr", "Designation is not updated");
			return "redirect:/viewdesignation";
		}
	}

}
