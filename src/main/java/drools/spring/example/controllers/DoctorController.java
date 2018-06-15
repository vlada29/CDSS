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

import drools.spring.example.facts.Doctor;
import drools.spring.example.services.IDoctorService;



@RestController
public class DoctorController {

	@Autowired
	IDoctorService doctorService;
	
	@RequestMapping(
			value = "/getAllDoctors",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public ArrayList<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}
	
	@RequestMapping(
			value = "/createDoctor",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void createDoctor(@RequestBody Doctor d, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			doctorService.createDoctor(d);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
	
	@RequestMapping(
			value = "/updateDoctor",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateDoctor(@RequestBody Doctor d, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			doctorService.updateDoctor(d);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
	
	@RequestMapping(
			value = "/deleteDoctor",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public void deleteDoctor(@RequestBody Doctor d, HttpServletResponse response,HttpSession session) throws IOException {
		try {
			doctorService.deleteDoctor(d);
		}catch(Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
		}
	}
}
