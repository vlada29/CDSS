package drools.spring.example.controllers;

import java.io.IOException;

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

import drools.spring.example.facts.Admin;
import drools.spring.example.facts.Doctor;
import drools.spring.example.services.ILoginService;

@RestController
public class LoginController {

	@Autowired
	ILoginService loginService;
	
	@RequestMapping(
			value = "/loginAdmin",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public Admin loginAdmin(@RequestBody Admin a, HttpServletResponse response,HttpSession session) throws IOException {
		if(loginService.loginAdmin(a) == null) {
			response.sendError(Response.SC_FORBIDDEN);
			return null;
		}else {
			return loginService.loginAdmin(a);
		}
		
	}
	
	@RequestMapping(
			value = "/loginDoctor",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public Doctor loginDoctor(@RequestBody Doctor d, HttpServletResponse response,HttpSession session) throws IOException {
		if(loginService.loginDoctor(d) == null) {
			response.sendError(Response.SC_FORBIDDEN);
			return null;
		}else {
			return loginService.loginDoctor(d);
		}
	}

}
