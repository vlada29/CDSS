package drools.spring.example.services;

import drools.spring.example.facts.Admin;
import drools.spring.example.facts.Doctor;

public interface ILoginService {
	public Admin loginAdmin(Admin a);
	public Doctor loginDoctor(Doctor d);
}
