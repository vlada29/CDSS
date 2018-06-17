package drools.spring.example.services;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import drools.spring.example.facts.Admin;
import drools.spring.example.facts.Diagnose;
import drools.spring.example.facts.DijalizaEvent;
import drools.spring.example.facts.HAEvent;
import drools.spring.example.facts.HBEvent;
import drools.spring.example.facts.MEvent;
import drools.spring.example.facts.MPatient;
import drools.spring.example.facts.NivoKiseonika;
import drools.spring.example.facts.OxygenEvent;
import drools.spring.example.facts.OxygenProblemEvent;
import drools.spring.example.facts.Patient;
import drools.spring.example.repositories.MongoProvider;
import static com.mongodb.client.model.Filters.eq;

@Service
public class PatientService implements IPatientService {
	private static Gson g = new Gson();
	
	private final KieContainer kieContainer;
	
	private KieSession mSession;
	
	@Autowired
	public PatientService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
		
	public ArrayList<Patient> getAllPatients() {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> patients = m.getDB().getCollection("patients");
		List<Document> patientsList = (List<Document>) patients.find().into(new ArrayList<Document>());
		ArrayList<Patient> p = new ArrayList<Patient>();
		
		for(Document doc : patientsList) {
			p.add(g.fromJson(doc.toJson(), Patient.class));
		}

		m.closeDB();
		return p;
	}


	public boolean postaviDijagnozu(Diagnose d, String ime, String prezime) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> patients = m.getDB().getCollection("patients");
		
		FindIterable<Document> pat = patients.find(eq("firstName",ime));
		
		Patient p;
		
		if(pat.first() != null) {
			p = g.fromJson(pat.first().toJson(), Patient.class);
		}else {
			return false;
		}
		
		p.getDijagnostikovaneBolesti().add(d);
		
		patients.findOneAndReplace(eq("firstName",ime), Document.parse(g.toJson(p)));
		
		m.closeDB();
		
		return true;
	}


	public Admin validirajDijagnozu(Diagnose d, String ime, String prezime) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> patients = m.getDB().getCollection("patients");
		
		FindIterable<Document> pat = patients.find(eq("firstName",ime));
		
		Patient p;
		
		if(pat.first() != null) {
			p = g.fromJson(pat.first().toJson(), Patient.class);
		}else {
			return null;
		}
		
		m.closeDB();
		
		String izvestaj = "Pacijent alergican na: ";
		
		KieSession kSession = kieContainer.newKieSession("ExampleSession");

		
		kSession.insert(p);
		kSession.insert(d);
		
		kSession.getAgenda().getAgendaGroup("validacijaDijagnoze").setFocus();
		kSession.fireAllRules();
		
		boolean zarez = false;
		
		for(Object o : kSession.getObjects()) {
			if(o.getClass() == String.class) {
				if(zarez) {
					izvestaj+=", ";
				}
				izvestaj+=o;
				zarez = true;
			}
		}
		
		if(izvestaj.equals("Pacijent alergican na: ")) {
			izvestaj = "Validacija uspesna, pacijent nije alergican na lekove ili sastojke lekova";
		}
		
		Admin a = new Admin();
		a.setUsername(izvestaj);
		
		return a;
	}

	public Patient getPatientByName(String name) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> patients = m.getDB().getCollection("patients");
		FindIterable<Document> pat = patients.find(eq("firstName",name));
		
		Patient p = g.fromJson(pat.first().toJson(), Patient.class);
		
		m.closeDB();

		return p;
	}

	public ArrayList<MPatient> getMPatients() {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> patients = m.getDB().getCollection("Mpatients");
		List<Document> patientsList = (List<Document>) patients.find().into(new ArrayList<Document>());
		ArrayList<MPatient> p = new ArrayList<MPatient>();
		
		for(Document doc : patientsList) {
			p.add(g.fromJson(doc.toJson(), MPatient.class));
		}
		
		mSession = kieContainer.newKieSession("ExampleSession");

		m.closeDB();
		return p;
	}

	public MPatient setKiseonik(MPatient p, int kiseonik) throws Exception {
		p.setKiseonik(p.getKiseonik() + kiseonik);
		
		OxygenEvent oe = new OxygenEvent(p.getIme(),kiseonik);
		NivoKiseonika nk = new NivoKiseonika(p.getIme(),p.getKiseonik());
		
		mSession.insert(oe);
		mSession.insert(nk);
		mSession.getAgenda().getAgendaGroup("monitoring").setFocus();
		mSession.fireAllRules();
		
		for(Object o : mSession.getObjects()) {
			if(o.getClass() == OxygenProblemEvent.class) {
				throw new Exception();
			}
		}
		
		return p;
	}

	public MPatient setOtkucaje(MPatient p, int otkucaji) throws Exception {
		p.setOtkucaji(p.getOtkucaji() + otkucaji);
		HBEvent hbe = new HBEvent(p.getIme());
		
		mSession.insert(hbe);
		mSession.getAgenda().getAgendaGroup("monitoring").setFocus();
		mSession.fireAllRules();
		
		for(Object o : mSession.getObjects()) {
			if(o.getClass() == HAEvent.class) {
				throw new Exception();
			}
		}
		
		return p;
	}

	public MPatient setMokracu(MPatient p, int mokraca) throws Exception{
		p.setMokraca(p.getMokraca()+mokraca);
		
		MEvent me = new MEvent(p.getIme(),mokraca,p.isBoluje());
		mSession.insert(me);
		mSession.getAgenda().getAgendaGroup("monitoring").setFocus();
		mSession.fireAllRules();
		
		for(Object o : mSession.getObjects()) {
			if(o.getClass() == DijalizaEvent.class) {
				throw new Exception();
			}
		}
		
		return p;
	}
}
