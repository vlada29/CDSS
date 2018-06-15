package drools.spring.example.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import drools.spring.example.facts.Drug;
import drools.spring.example.services.IDrugService;


@RestController
public class DrugController {
	
	@Autowired
	IDrugService drugService;
	
	@RequestMapping(
			value = "/getAllDrugs",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public ArrayList<Drug> getAllDrugs() {
		return drugService.getAllDrugs();
	}
	
	@RequestMapping(
			value = "/createDrug",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void createDrug(@RequestBody Drug d, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			drugService.createDrug(d);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
	
	@RequestMapping(
			value = "/updateDrug",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateDrug(@RequestBody Drug d, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			drugService.updateDrug(d);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
	
	@RequestMapping(
			value = "/deleteDrug",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void deleteDrug(@RequestBody Drug d, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			drugService.deleteDrug(d);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
}
