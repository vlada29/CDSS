package drools.spring.example.services;

import java.util.ArrayList;

import drools.spring.example.facts.Symptom;


public interface ISymptomService {
	public ArrayList<Symptom> getAllSymptoms();
	public void createSymptom(Symptom s);
	public void updateSymptom(Symptom s);
	public void deleteSymptom(Symptom s);
}
