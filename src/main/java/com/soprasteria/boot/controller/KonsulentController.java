package com.soprasteria.boot.controller;

import java.net.MalformedURLException;
import java.util.List;

import com.soprasteria.boot.domain.Konsulent;

import com.soprasteria.boot.domain.Stilling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.soprasteria.boot.service.KonsulentService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;


@Controller
@RequestMapping(value="/konsulent")
public class KonsulentController {
	private static final Logger logger =  Logger.getLogger(KonsulentController.class);
	
	@Autowired
	KonsulentService konsulentService;

	@Autowired
	ServletContext context;


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Konsulent> findAll() {
		return konsulentService.hentAlle();
	}


	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public Konsulent findById(@PathVariable int id) {
		return konsulentService.hentMedId(id);
	}


	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String createKonsulent(HttpServletRequest request,
								  @RequestParam(value = "navn", required = true) String name,
								  @RequestParam(value = "epost", required = true)String epost,
								  @RequestParam(value = "pris", required = true) String pris,
								  @RequestParam(value = "stilling", required = false) String stilling) {
		logger.info("Values of navn, epost, pris " + name + "," + epost + "," + pris );



		try {

			Konsulent k = new Konsulent(konsulentService.getNextId());
			k.setNavn(name);
			k.setEpost(epost);
			k.setPris(Integer.parseInt(pris));
			if (null != stilling) {
				k.setStilling(Stilling.valueOf(stilling));
			}
			konsulentService.lagre(k);

		} catch(Exception e) {
			System.out.println(e);
			return "kunne ikke lagre konsulent";
		}

		return "lagret konsulent";

	}



}
