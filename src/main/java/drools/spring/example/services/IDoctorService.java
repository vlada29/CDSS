package drools.spring.example.services;

import java.util.ArrayList;

import drools.spring.example.facts.Doctor;


public interface IDoctorService {
	public ArrayList<Doctor> getAllDoctors();
	public void createDoctor(Doctor d);
	public void updateDoctor(Doctor d);
	public void deleteDoctor(Doctor d);
}
