package drools.spring.example;

import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import drools.spring.example.facts.Diagnose;
import drools.spring.example.facts.Doctor;
import drools.spring.example.facts.Drug;
import drools.spring.example.facts.Illness;
import drools.spring.example.facts.Patient;
import drools.spring.example.repositories.MongoProvider;
import drools.spring.example.services.DoctorService;
import drools.spring.example.services.IllnessService;

public class DBloader {

	public static void main(String[] args) {
		IllnessService is = new IllnessService();
		ArrayList<Illness> bolesti = is.getAllIllnesses();
		DoctorService ds = new DoctorService();
		ArrayList<Doctor> doctors = ds.getAllDoctors();

		Drug dr1 = new Drug();
		dr1.setType("antibiotic");
		dr1.setName("Fosforal");
		dr1.setIngredients(new ArrayList<String>());
		dr1.getIngredients().add("fosfomicin");
		dr1.getIngredients().add("trometanol");
		
		Drug dr2 = new Drug();
		dr2.setType("antibiotic");
		dr2.setName("Sporidex 500");
		dr2.setIngredients(new ArrayList<String>());
		dr2.getIngredients().add("cephalexin");
		
		
		Drug dr4 = new Drug();
		dr4.setType("other");
		dr4.setName("Midol");
		dr4.setIngredients(new ArrayList<String>());
		dr4.getIngredients().add("salicilna kiselina");
		dr4.getIngredients().add("acetil");
		
		Drug dr5 = new Drug();
		dr5.setType("other");
		dr5.setName("Brufen");
		dr5.setIngredients(new ArrayList<String>());
		dr5.getIngredients().add("magnezijum-stearat");
		dr5.getIngredients().add("natrijum lauril-sulfat");
		
		
		Drug dr6 = new Drug();
		dr6.setType("analgetic");
		dr6.setName("Ibuprofen");
		dr6.setIngredients(new ArrayList<String>());
		dr6.getIngredients().add("ibuprofen");

		
		
		Illness prehlada = bolesti.get(0);
		Illness sinusnaInfekcija = bolesti.get(3);
		Illness dijabetes = bolesti.get(4);
		
		Diagnose diag1 = new Diagnose();
		Diagnose diag2 = new Diagnose();
		Diagnose diag3 = new Diagnose();
		
		Diagnose diag4 = new Diagnose();
		diag4.setDijagnostikovanaBolest(prehlada);
		diag4.setPrepisaniLekovi(new ArrayList<Drug>());
		diag4.getPrepisaniLekovi().add(dr6);
		diag4.setDatumDijagnoze(new Date());
		diag4.setLekar(doctors.get(0));
		
		Diagnose diag5 = new Diagnose();
		diag5.setDijagnostikovanaBolest(prehlada);
		diag5.setPrepisaniLekovi(new ArrayList<Drug>());
		diag5.getPrepisaniLekovi().add(dr6);
		diag5.setDatumDijagnoze(new Date());
		diag5.setLekar(doctors.get(1));
		////////////////////////////////////////////////////////////////////////////
		Diagnose diag6 = new Diagnose();
		diag6.setDijagnostikovanaBolest(prehlada);
		diag6.setPrepisaniLekovi(new ArrayList<Drug>());
		diag6.getPrepisaniLekovi().add(dr6);
		diag6.setDatumDijagnoze(new Date());
		diag6.setLekar(doctors.get(2));
		
		Patient p2 = new Patient();
		p2.setFirstName("Djuradj");
		p2.setLastName("Djokic");
		p2.setDijagnostikovaneBolesti(new ArrayList<Diagnose>());
		p2.getDijagnostikovaneBolesti().add(diag4);
		p2.setAlergije(new ArrayList<String>());
		p2.getDijagnostikovaneBolesti().add(diag4);
		
		
		p2.getDijagnostikovaneBolesti().add(diag5);
		p2.getDijagnostikovaneBolesti().add(diag5);
		
		
		p2.getDijagnostikovaneBolesti().add(diag6);
		p2.getDijagnostikovaneBolesti().add(diag6);
		

		
		p2.getDijagnostikovaneBolesti().add(diag4);
		p2.getDijagnostikovaneBolesti().add(diag4);
		//////////////////////////////////////////////////////////////////////////////
		
		Diagnose diag7 = new Diagnose();
		Diagnose diag8 = new Diagnose();
		Diagnose diag9 = new Diagnose();
		
		diag7.setDatumDijagnoze(new Date());
		diag8.setDatumDijagnoze(new Date());
		diag9.setDatumDijagnoze(new Date());
		
		diag7.setDijagnostikovanaBolest(prehlada);
		diag8.setDijagnostikovanaBolest(sinusnaInfekcija);
		diag9.setDijagnostikovanaBolest(dijabetes);
		
		diag7.setLekar(doctors.get(0));
		diag8.setLekar(doctors.get(0));
		diag9.setLekar(doctors.get(0));
		
		diag7.setPrepisaniLekovi(new ArrayList<Drug>());
		diag8.setPrepisaniLekovi(new ArrayList<Drug>());
		diag9.setPrepisaniLekovi(new ArrayList<Drug>());
		
		diag7.getPrepisaniLekovi().add(dr1);
		diag7.getPrepisaniLekovi().add(dr2);
		diag8.getPrepisaniLekovi().add(dr1);
		diag9.getPrepisaniLekovi().add(dr2);
		
		Patient p3 = new Patient();
		p3.setFirstName("Petar");
		p3.setLastName("Lalic");
		p3.setAlergije(new ArrayList<String>());
		p3.setDijagnostikovaneBolesti(new ArrayList<Diagnose>());
		
		
		p3.getDijagnostikovaneBolesti().add(diag7);
		p3.getDijagnostikovaneBolesti().add(diag8);
		p3.getDijagnostikovaneBolesti().add(diag9);
		
		p3.getDijagnostikovaneBolesti().add(diag7);
		p3.getDijagnostikovaneBolesti().add(diag8);
		p3.getDijagnostikovaneBolesti().add(diag9);
		
		p3.getDijagnostikovaneBolesti().add(diag7);
		p3.getDijagnostikovaneBolesti().add(diag8);
		p3.getDijagnostikovaneBolesti().add(diag9);
		
		p3.getDijagnostikovaneBolesti().add(diag7);
		p3.getDijagnostikovaneBolesti().add(diag8);
		p3.getDijagnostikovaneBolesti().add(diag9);
		
		
		
		///////////////////////////////////////////////////////////////////////////////
		diag1.setDijagnostikovanaBolest(prehlada);
		diag2.setDijagnostikovanaBolest(sinusnaInfekcija);
		diag3.setDijagnostikovanaBolest(dijabetes);
		
		Date d1 = new Date();
	
		diag1.setPrepisaniLekovi(new ArrayList<Drug>());
		diag2.setPrepisaniLekovi(new ArrayList<Drug>());
		diag3.setPrepisaniLekovi(new ArrayList<Drug>());
		
		
		
		d1.setMonth(4);
		
		diag1.setDatumDijagnoze(d1);
		diag2.setDatumDijagnoze(d1);
		
		diag1.getPrepisaniLekovi().add(dr1);
		diag2.getPrepisaniLekovi().add(dr4);
		diag1.setLekar(doctors.get(0));
		diag2.setLekar(doctors.get(0));
		
		
		
		
		
		
		
		
		Patient p1 = new Patient();
		p1.setFirstName("Nemanja");
		p1.setLastName("Krstevski");
		
		p1.setDijagnostikovaneBolesti(new ArrayList<Diagnose>());
		p1.getDijagnostikovaneBolesti().add(diag1);
		p1.getDijagnostikovaneBolesti().add(diag2);
		
		
		p1.setAlergije(new ArrayList<String>());
		p1.getAlergije().add(dr5.getName());
		
		
		
		d1.setMonth(3);
		diag1.setDatumDijagnoze(d1);
		diag2.setDatumDijagnoze(d1);
		
		p1.getDijagnostikovaneBolesti().add(diag1);
		p1.getDijagnostikovaneBolesti().add(diag2);
		
		d1.setMonth(2);
		diag1.setDatumDijagnoze(d1);
		diag2.setDatumDijagnoze(d1);
		
		p1.getDijagnostikovaneBolesti().add(diag1);
		p1.getDijagnostikovaneBolesti().add(diag2);
		
		d1.setMonth(1);
		diag1.setDatumDijagnoze(d1);
		diag2.setDatumDijagnoze(d1);
		
		p1.getDijagnostikovaneBolesti().add(diag1);
		p1.getDijagnostikovaneBolesti().add(diag2);
		
		d1.setMonth(10);
		d1.setYear(2017);
		diag1.setDatumDijagnoze(d1);
		diag2.setDatumDijagnoze(d1);
		
		p1.getDijagnostikovaneBolesti().add(diag1);
		p1.getDijagnostikovaneBolesti().add(diag2);
		
		d1.setMonth(7);
		d1.setYear(2017);
		diag1.setDatumDijagnoze(d1);
		diag2.setDatumDijagnoze(d1);
		
		p1.getDijagnostikovaneBolesti().add(diag1);
		p1.getDijagnostikovaneBolesti().add(diag2);
		
		System.out.println(p1.getDijagnostikovaneBolesti().toString());
		
		
		
		MongoProvider mp = new MongoProvider();
		MongoDatabase db = mp.getDB();
		MongoCollection<Document> patients = db.getCollection("patients");
		patients.drop();
		
		Gson g = new Gson();
		
		Document d = Document.parse(g.toJson(p1));
		Document doc2 = Document.parse(g.toJson(p2));
		Document doc3 = Document.parse(g.toJson(p3));
		
		patients.insertOne(d);
		patients.insertOne(doc2);
		patients.insertOne(doc3);
		
	}

}
