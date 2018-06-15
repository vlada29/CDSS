package drools.spring.example.services;

import java.util.ArrayList;

import drools.spring.example.facts.Illness;
import drools.spring.example.facts.Symptom;

public interface IDiagnoseService {
	public Illness getNajB(ArrayList<Symptom> symptoms);
	public ArrayList<Illness> getPovezaneB(ArrayList<Symptom> symptoms);
}
