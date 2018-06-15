package drools.spring.example.services;

import java.util.ArrayList;

import drools.spring.example.facts.Admin;
import drools.spring.example.facts.Diagnose;
import drools.spring.example.facts.Patient;

public interface IPatientService {
	public ArrayList<Patient> getAllPatients();
	public boolean postaviDijagnozu(Diagnose d,String ime,String prezime);
	public Admin validirajDijagnozu(Diagnose d,String ime,String prezime);
}
