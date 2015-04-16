package controller;

import java.util.List;

import domain.Konsulent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.KonsulentService;


@Controller
@RequestMapping(value="/role")
public class KonsulentController {
	
	@Autowired
	KonsulentService service;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Konsulent> findAll() {
		return service.hentAlleKonsulenter();
		
	}
	
	
	
	

}
