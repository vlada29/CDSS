package drools.spring.example.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import drools.spring.example.facts.Admin;
import drools.spring.example.facts.Diagnose;
import drools.spring.example.facts.MPatient;
import drools.spring.example.facts.Patient;
import drools.spring.example.services.IPatientService;

@RestController
public class PacijentController {
	
	@Autowired
	IPatientService patientService;
	
	@RequestMapping(
			value = "/postaviDijagnozu/{ime}/{prezime}",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public Diagnose postaviDijagnozu(@RequestBody Diagnose d,@PathVariable String ime,@PathVariable String prezime, HttpServletResponse response,HttpSession session) throws IOException {
		if(patientService.postaviDijagnozu(d, ime, prezime)) {
			return d;
		}else {
			response.sendError(Response.SC_FORBIDDEN);
			return null;
		}
	}
	
	@RequestMapping(
			value = "/validirajDijagnozu/{ime}/{prezime}",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public Admin validirajDijagnozu(@RequestBody Diagnose d,@PathVariable String ime,@PathVariable String prezime, HttpServletResponse response,HttpSession session) throws IOException {
		return patientService.validirajDijagnozu(d, ime, prezime);
	}
	
	@RequestMapping(
			value="/getAllPatients",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public ArrayList<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	@RequestMapping(
			value="/getPatientByName",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public Patient getPatientByName(@RequestBody Patient p) {
		return patientService.getPatientByName(p.getFirstName());
	}
	
	@RequestMapping(
			value="/getMPatients",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public ArrayList<MPatient> getMPatients(){
		return patientService.getMPatients();
	}
	
	@RequestMapping(
			value="/setOtkucaje/{otkucaji}",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public MPatient setOtkucaje(@RequestBody MPatient p,@PathVariable int otkucaji, HttpServletResponse response) throws IOException{
		try {
			return patientService.setOtkucaje(p,otkucaji);
		}catch (Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
			return null;
		}
		
	}
	
	@RequestMapping(
			value="/setKiseonik/{kiseonik}",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public MPatient setKiseonik(@RequestBody MPatient p,@PathVariable int kiseonik, HttpServletResponse response) throws IOException{
		try {
			return patientService.setKiseonik(p,kiseonik);
		}catch (Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
			return null;
		}
	}
	
	@RequestMapping(
			value="/setMokracu/{mokraca}",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public MPatient setMokracu(@RequestBody MPatient p,@PathVariable int mokraca, HttpServletResponse response) throws IOException{
		try {
			return patientService.setMokracu(p,mokraca);
		}catch (Exception e) {
			response.sendError(Response.SC_FORBIDDEN);
			return null;
		}
	}
}








