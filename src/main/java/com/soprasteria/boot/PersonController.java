package com.soprasteria.boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PersonController {
	
	@RequestMapping(value = "/person", method=RequestMethod.GET)
	public String getPersonInfoFromDefault(Model model){
		model.addAttribute("name", "Ditt navn");
		model.addAttribute("age", "Din alder");
		model.addAttribute("food", "Din favorittmat");
		
		return "page";
	}
	
	@RequestMapping(value = "/person", method=RequestMethod.POST)
	public String getPersonInfoFromPostMethod(@RequestParam("myName") String myName, 
			@RequestParam("myFood") String myFood, 
			Model model){
		model.addAttribute("name", myName);
		model.addAttribute("age", "Din alder");
		model.addAttribute("food", myFood);
		
		return "page";
	}

}
