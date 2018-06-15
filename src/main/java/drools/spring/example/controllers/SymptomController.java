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

import drools.spring.example.facts.Symptom;
import drools.spring.example.services.ISymptomService;



@RestController
public class SymptomController {
	
	@Autowired
	ISymptomService symtomService;
	
	@RequestMapping(
			value = "/getAllSymptoms",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public ArrayList<Symptom> getAllSymptoms() {
		return symtomService.getAllSymptoms();
	}
	
	@RequestMapping(
			value = "/createSymptom",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void createSymptom(@RequestBody Symptom s, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			symtomService.createSymptom(s);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
	
	@RequestMapping(
			value = "/updateSymptom",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateSymptom(@RequestBody Symptom s, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			symtomService.updateSymptom(s);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
	
	@RequestMapping(
			value = "/deleteSymptom",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void deleteSymptom(@RequestBody Symptom s, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			symtomService.deleteSymptom(s);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
}
