package drools.spring.example.services;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;


import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

import drools.spring.example.facts.Doctor;
import drools.spring.example.repositories.MongoProvider;

@Service
public class DoctorService implements IDoctorService{
	private static Gson g = new Gson();
	
	public ArrayList<Doctor> getAllDoctors() {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> doctors = m.getDB().getCollection("doctors");
		List<Document> doctorsList = (List<Document>) doctors.find().into(new ArrayList<Document>());
		ArrayList<Doctor> d = new ArrayList<Doctor>();
		
		for(Document doc : doctorsList) {
			d.add(g.fromJson(doc.toJson(), Doctor.class));
		}

		m.closeDB();
		return d;
	}

	public void createDoctor(Doctor d) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> doctors = m.getDB().getCollection("doctors");
		
		Document doc = Document.parse(g.toJson(d));
		doctors.insertOne(doc);
		
		m.closeDB();
		
	}

	public void updateDoctor(Doctor d) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> doctors = m.getDB().getCollection("doctors");
		
		doctors.findOneAndReplace(eq("username",d.getUsername()),Document.parse(g.toJson(d)));
		
		m.closeDB();
		
	}

	public void deleteDoctor(Doctor d) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> doctors = m.getDB().getCollection("doctors");
		
		doctors.deleteOne(eq("username",d.getUsername()));
		
		m.closeDB();
		
	}

}
