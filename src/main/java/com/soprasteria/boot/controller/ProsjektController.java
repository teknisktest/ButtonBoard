package com.soprasteria.boot.controller;

import com.soprasteria.boot.domain.Konsulent;
import com.soprasteria.boot.domain.Prosjekt;
import com.soprasteria.boot.service.ProsjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by olovholm on 21.04.2015.
 */

//TODO implementer get/{id} funksjon, samt post input data funksjon
@Controller
@RequestMapping(value = "/prosjekt")
public class ProsjektController {

    @Autowired
    ProsjektService prosjektService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Prosjekt> findAll() {
        return prosjektService.hentAlle();
    }

    //TODO Send HTTP Error code if cannot be found
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Prosjekt findById(@PathVariable int id) {
        return prosjektService.hentMedId(id);
    }



}
