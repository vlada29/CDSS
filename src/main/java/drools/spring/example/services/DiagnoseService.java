package drools.spring.example.services;

import java.util.ArrayList;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import drools.spring.example.facts.Illness;
import drools.spring.example.facts.Prioritet;
import drools.spring.example.facts.Symptom;

@Service
public class DiagnoseService implements IDiagnoseService{

	private final KieContainer kieContainer;
	
	@Autowired
	IIllnessService illnessService;
	
	@Autowired
	public DiagnoseService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	public Illness getNajB(ArrayList<Symptom> symptoms) {
		KieSession kSession = kieContainer.newKieSession("ExampleSession");
		
		Illness rezultat = new Illness();
		
		kSession.setGlobal("pronadjena", false);
		kSession.setGlobal("bolest", new Illness());
		
		for(Symptom s : symptoms) {
			kSession.insert(s);
		}
		
		for(Illness ill : illnessService.getAllIllnesses()) {
			kSession.insert(ill);
		}
		
		
		kSession.getAgenda().getAgendaGroup("pocetnoIzbacivanje").setFocus();
		kSession.fireAllRules();
		
		kSession.getAgenda().getAgendaGroup("filter").setFocus();
		kSession.fireAllRules();
		
		kSession.getAgenda().getAgendaGroup("final").setFocus();
		kSession.fireAllRules();
		
		rezultat = (Illness)kSession.getGlobal("bolest");
		
		System.out.println("Pronadjena bolest "+rezultat.toString());
		
		kSession.dispose();
		
		return rezultat;
	}

	public ArrayList<Illness> getPovezaneB(ArrayList<Symptom> symptoms) {
		KieSession kSession = kieContainer.newKieSession("ExampleSession");
		
		for(Symptom s : symptoms) {
			kSession.insert(s);
		}
		
		for(Illness ill : illnessService.getAllIllnesses()) {
			kSession.insert(ill);
		}
		
		ArrayList<Illness> povezaneBolesti = new ArrayList<Illness>();

		kSession.insert(povezaneBolesti);
		kSession.insert(new Prioritet());
		
		kSession.getAgenda().getAgendaGroup("povezaneBolesti").setFocus();
		kSession.fireAllRules();
		
		return povezaneBolesti;
	}
	
	

}
