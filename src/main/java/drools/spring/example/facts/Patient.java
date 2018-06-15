package drools.spring.example.facts;

import java.util.ArrayList;

public class Patient {
	private String firstName;
	private String lastName;
	private ArrayList<Diagnose> dijagnostikovaneBolesti;
	private ArrayList<String> alergije;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<Diagnose> getDijagnostikovaneBolesti() {
		return dijagnostikovaneBolesti;
	}
	public void setDijagnostikovaneBolesti(ArrayList<Diagnose> dijagnostikovaneBolesti) {
		this.dijagnostikovaneBolesti = dijagnostikovaneBolesti;
	}
	public ArrayList<String> getAlergije() {
		return alergije;
	}
	public void setAlergije(ArrayList<String> alergije) {
		this.alergije = alergije;
	}
	public Patient(String firstName, String lastName, ArrayList<Diagnose> dijagnostikovaneBolesti,
			ArrayList<String> alergije) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dijagnostikovaneBolesti = dijagnostikovaneBolesti;
		this.alergije = alergije;
	}
	@Override
	public String toString() {
		return "Patient [firstName=" + firstName + ", lastName=" + lastName + ", dijagnostikovaneBolesti="
				+ dijagnostikovaneBolesti + ", alergije=" + alergije + "]";
	}
	
	public Patient() {
		
	}
}
