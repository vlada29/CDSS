package drools.spring.example.services;

import java.util.ArrayList;

import drools.spring.example.facts.Izvestaj;

public interface IIzvestajiService {
	public ArrayList<Izvestaj> getHronicne();
	public ArrayList<Izvestaj> getZavisnike();
	public ArrayList<Izvestaj> getOslabljene();
}
