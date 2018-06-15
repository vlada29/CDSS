package drools.spring.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import drools.spring.example.facts.Izvestaj;
import drools.spring.example.services.IIzvestajiService;

@RestController
public class IzvestajiController {
	
	@Autowired
	IIzvestajiService izvestajiService;
	
	@RequestMapping(
			value = "/getHronicne",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public ArrayList<Izvestaj> getHronicne() {
		return izvestajiService.getHronicne();
	}
	
	@RequestMapping(
			value = "/getZavisnike",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public ArrayList<Izvestaj> getZavisnike() {
		return izvestajiService.getZavisnike();
	}
	
	@RequestMapping(
			value = "/getOslabljene",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public ArrayList<Izvestaj> getOslabljene() {
		return izvestajiService.getOslabljene();
	}
}
