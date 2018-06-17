package drools.spring.example;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import drools.spring.example.facts.MPatient;
import drools.spring.example.repositories.MongoProvider;

public class Mloader {

	public static void main(String[] args) {
		Gson g = new Gson();
		
		MongoProvider mp = new MongoProvider();
		MongoDatabase db = mp.getDB();
		MongoCollection<Document> patients = db.getCollection("Mpatients");
		patients.drop();
		
		MPatient p1 = new MPatient("Ime1","Prezime1",100,0,0,false);
		MPatient p2 = new MPatient("Ime2","Prezime2",100,0,0,false);
		MPatient p3 = new MPatient("Ime3","Prezime4",100,0,0,true);
		
		Document d1 = Document.parse(g.toJson(p1));
		Document d2 = Document.parse(g.toJson(p2));
		Document d3 = Document.parse(g.toJson(p3));
		
		patients.insertOne(d1);
		patients.insertOne(d2);
		patients.insertOne(d3);
		
		mp.closeDB();
	}

}
