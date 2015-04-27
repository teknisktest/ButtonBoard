package com.soprasteria.boot.controller;

import java.net.MalformedURLException;
import java.util.List;

import com.soprasteria.boot.domain.Konsulent;

import com.soprasteria.boot.domain.Stilling;
import com.soprasteria.boot.service.StillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	StillingService stillingService;

	@Autowired
	ServletContext context;


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Konsulent> findAll() {
		return konsulentService.hentAlle();
	}

	//TODO Send HTTP Error code if cannot be found
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public Konsulent findById(@PathVariable int id) {
		return konsulentService.hentMedId(id);
	}


	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity createKonsulent(HttpServletRequest request,
								  @RequestParam(value = "navn", required = true) String name,
								  @RequestParam(value = "epost", required = true)String epost,
								  @RequestParam(value = "pris", required = true) String pris,
								  @RequestParam(value = "stilling", required = false) String stilling) {

		HttpHeaders responseHeaders = new HttpHeaders();


		logger.info("Values of navn, epost, pris " + name + "," + epost + "," + pris );
		try {
			Konsulent k = new Konsulent(konsulentService.getNextId());
			k.setNavn(name);
			k.setEpost(epost);
			k.setPris(Integer.parseInt(pris));
			if (null != stilling) {
				Stilling s = StillingService.stringTilStilling(stilling);
				if(s != null) {
					k.setStilling(s);
				} else {
					logger.info("Kunne ikke lagre stilling: " + stilling);
					return new ResponseEntity("Stilling ugyldig", responseHeaders, HttpStatus.BAD_REQUEST);
				}
			}
			konsulentService.lagre(k);

		} catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity("Kunne ikke lagre konsulent",responseHeaders, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity("Konsulent lagret",responseHeaders, HttpStatus.CREATED);

	}



}
