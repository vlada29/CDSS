package drools.spring.example.services;

import java.util.ArrayList;

import drools.spring.example.facts.Drug;

public interface IDrugService {
	public ArrayList<Drug> getAllDrugs();
	public void createDrug(Drug d);
	public void updateDrug(Drug d);
	public void deleteDrug(Drug d);
}
