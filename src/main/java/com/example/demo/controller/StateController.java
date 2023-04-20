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

import com.example.demo.models.State;
import com.example.demo.service.StateService;

@Controller
public class StateController {

	@Autowired
	StateService stateserv;
	
	@GetMapping("/addstate")
	public String addState()
	{
		return "AddState";
	}
	
	@RequestMapping("/savestate")
	public String saveState(@ModelAttribute("State")State state,RedirectAttributes attr)
	{
		boolean res = stateserv.isSaveState(state);
		if(res)
		{
			attr.addFlashAttribute("response", "State is saved successfully");
			return "redirect:/viewstates";
		}
		else {
			attr.addFlashAttribute("reserr", "State is not saved ");
			return "redirect:/viewstates";
		}
	}
	
	@GetMapping("/viewstates")
	public String viewStates(Model model)
	{
		List<State> statelist = stateserv.getAllStates();
		
		//statelist.stream().forEach(e-> System.out.println(e.getState_name()));
		model.addAttribute("slist", statelist);
		return "ViewStates";
	}
	
	@RequestMapping("/editstatebyid/{id}")
	public String editStateById(@PathVariable("id") String id,Model model,RedirectAttributes attr)
	{
		State state =stateserv.getStateById(id);
		if(state!=null)
		{
			model.addAttribute("state", state);
			return "EditState";
		}
		else
		{
			attr.addFlashAttribute("reserr", "No State Found for given Id");
			return "redirect:/viewstates";
		}
	}
	
	@RequestMapping("/updatestate")
	public String updateState(@ModelAttribute("State")State state,RedirectAttributes attr)
	{
		int res = stateserv.updateState(state);
		if(res>0)
		{
			attr.addFlashAttribute("response", "State is updated successfully");
			return "redirect:/viewstates";
		}
		else {
			attr.addFlashAttribute("reserr", "State is not updated ");
			return "redirect:/viewstates";
		}
	}
}
