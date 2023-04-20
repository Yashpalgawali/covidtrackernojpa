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

import com.example.demo.models.Hospital;
import com.example.demo.models.State;
import com.example.demo.service.HospitalService;
import com.example.demo.service.StateService;

@Controller
public class HospitalController {

	@Autowired
	StateService stateserv;
	
	
	@Autowired
	HospitalService hospserv;
	
	@GetMapping("/addhospital")
	public String addHospital(Model model)
	{
		List<State> slist = stateserv.getAllStates();
		model.addAttribute("slist",slist);
		
		return "AddHospital";
	}
	
	@RequestMapping("/savehospital")
	public String saveHospital(@ModelAttribute("Hospital")Hospital hosp,RedirectAttributes attr )
	{
		boolean res = hospserv.isSaveHospital(hosp);
		
		if(res) {
			attr.addFlashAttribute("response", "Hospital is saved successfully");
			return "redirect:/viewhospitals";
		}
		else {
			attr.addFlashAttribute("reserr", "Hospital is not saved ");
			return "redirect:/viewhospitals";
		}
	}
	
	@GetMapping("/viewhospitals")
	public String getAllHospitals(Model model,RedirectAttributes attr)
	{
		List<Hospital> hlist = hospserv.getAllHospitals();
		
		model.addAttribute("hlist", hlist);
		return "ViewHospitals";
	}
	
	@RequestMapping("/edithospbyid/{id}")
	public String editHospital(@PathVariable("id")String id, Model model ,RedirectAttributes attr)
	{
		Hospital hosp = hospserv.getHospitalByHospId(id);
		
		if(hosp !=null)
		{
			List<State> slist = stateserv.getAllStates();
			
			model.addAttribute("slist",slist);
			model.addAttribute("hosp", hosp);
			return "EditHospital";
		}
		else {
			attr.addFlashAttribute("reserr", "Hospital not found for given Id");
			return "redirect:/viewhospitals";
		}
	}
	
	@RequestMapping("/updatehospital")
	public String updateHospital(@ModelAttribute("Hospital")Hospital hosp,RedirectAttributes attr)
	{
		int res = hospserv.updateHospital(hosp);
		if(res > 0)
		{
			attr.addFlashAttribute("response", "Hospital is updated successfully");
			return "redirect:/viewhospitals";
		}
		else {
			attr.addFlashAttribute("response", "Hospital is not updated ");
			return "redirect:/viewhospitals";
		}
	}
	
	@GetMapping("/hospital")
	public String hospitalDashBoard()
	{
		return "HospitalDashBoard";
	}
	
	@GetMapping("/addhospdept")
	public String addHospitalDepartment()
	{
		return "";
	}
	
}
