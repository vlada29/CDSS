package drools.spring.example.services;

import java.util.ArrayList;
import java.util.Date;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import drools.spring.example.facts.Doctor;
import drools.spring.example.facts.Illness;
import drools.spring.example.facts.Izvestaj;
import drools.spring.example.facts.Patient;

@Service
public class IzvestajiService implements IIzvestajiService {
	
	private final KieContainer kieContainer;
	
	@Autowired
	IPatientService patientService;
	
	@Autowired
	IIllnessService illnessService;
	
	@Autowired
	public IzvestajiService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	public ArrayList<Izvestaj> getHronicne() {
		KieSession kSession = kieContainer.newKieSession("ExampleSession");
		
		for(Patient p : patientService.getAllPatients()) {
			kSession.insert(p);
		}
		
		for(Illness i : illnessService.getAllIllnesses()) {
			kSession.insert(i);
		}
		
		kSession.setGlobal("trenutniDatum", new Date());
		kSession.setGlobal("dveGodine",new Long("63113904000"));
		kSession.getAgenda().getAgendaGroup("hronicni").setFocus();
		
		kSession.fireAllRules();
		
		ArrayList<Izvestaj> izvestaji = new ArrayList<Izvestaj>();
		
		for(Object o : kSession.getObjects()) {
			if(o.getClass() == Izvestaj.class) {
				izvestaji.add((Izvestaj)o);
			}
		}
		
		kSession.dispose();
		
		return izvestaji;
	}

	public ArrayList<Izvestaj> getZavisnike() {
		KieSession kSession = kieContainer.newKieSession("ExampleSession");
		
		for(Patient p : patientService.getAllPatients()) {
			kSession.insert(p);
		}
			
		kSession.setGlobal("trenutniDatum", new Date());
		kSession.setGlobal("sestMeseci", new Long("15778476000"));
		kSession.setGlobal("lekari", new ArrayList<Doctor>());
		kSession.getAgenda().getAgendaGroup("zavisnici").setFocus();
		
		kSession.fireAllRules();
		
		ArrayList<Izvestaj> izvestaji = new ArrayList<Izvestaj>();
		
		for(Object o : kSession.getObjects()) {
			if(o.getClass() == Izvestaj.class) {
				izvestaji.add((Izvestaj)o);
			}
		}
		
		kSession.dispose();
		
		return izvestaji;
	}

	public ArrayList<Izvestaj> getOslabljene() {
		KieSession kSession = kieContainer.newKieSession("ExampleSession");
		
		for(Patient p : patientService.getAllPatients()) {
			kSession.insert(p);
		}
		
		kSession.setGlobal("trenutniDatum", new Date());
		kSession.setGlobal("godina", new Long("31556952000"));
		kSession.setGlobal("imunitetBolesti", new ArrayList<Illness>());
		kSession.getAgenda().getAgendaGroup("oslabljeniImunitet").setFocus();
		
		kSession.fireAllRules();
		
		ArrayList<Izvestaj> izvestaji = new ArrayList<Izvestaj>();
		
		for(Object o : kSession.getObjects()) {
			if(o.getClass() == Izvestaj.class) {
				izvestaji.add((Izvestaj)o);
			}
		}
		
		kSession.dispose();
		
		return izvestaji;
	}

}
