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

import drools.spring.example.facts.Illness;
import drools.spring.example.services.IDiagnoseService;
import drools.spring.example.services.IIllnessService;



@RestController
public class IllnessControler {
	
	@Autowired
	IIllnessService illnessService;
	
	@Autowired
	IDiagnoseService diagnoseService;
	
	@RequestMapping(
			value = "/getAllIllnesses",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public ArrayList<Illness> getAllIllnesses() {
		return illnessService.getAllIllnesses();
	}
	
	@RequestMapping(
			value = "/getNajB",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public Illness getNajB(@RequestBody Illness i, HttpServletResponse response,HttpSession session) throws IOException {
		return diagnoseService.getNajB(i.getSymptoms());
	}
	
	@RequestMapping(
			value = "/getPovezaneB",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public ArrayList<Illness> getPovezaneB(@RequestBody Illness i, HttpServletResponse response,HttpSession session) throws IOException {
		return diagnoseService.getPovezaneB(i.getSymptoms());
	}
	
	@RequestMapping(
			value = "/createIllness",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void createIllness(@RequestBody Illness i, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			illnessService.createIllness(i);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
	
	@RequestMapping(
			value = "/updateIllness",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateIllness(@RequestBody Illness i, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			illnessService.updateIllness(i);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
	
	@RequestMapping(
			value = "/deleteIllness",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void deleteIllness(@RequestBody Illness i, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			illnessService.deleteIllness(i);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
}
