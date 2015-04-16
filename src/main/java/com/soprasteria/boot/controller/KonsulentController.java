package com.soprasteria.boot.controller;

import java.util.List;

import com.soprasteria.boot.domain.Konsulent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soprasteria.boot.service.KonsulentService;


@Controller
@RequestMapping(value="/konsulent")
public class KonsulentController {
	
	@Autowired
	KonsulentService service;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Konsulent> findAll() {
		return service.hentAlleKonsulenter();
	}


	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public Konsulent findById(@PathVariable int id) {
		return service.hentMedId(id);
	}



	
	
	
	

}
