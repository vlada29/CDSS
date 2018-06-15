package drools.spring.example.services;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import drools.spring.example.facts.Admin;
import drools.spring.example.facts.Doctor;
import drools.spring.example.repositories.MongoProvider;

@Service
public class LoginService implements ILoginService {
	private static Gson g = new Gson();
	
	public Admin loginAdmin(Admin a) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> admins = m.getDB().getCollection("admins");
		
		FindIterable<Document> dc = admins.find(eq("username",a.getUsername()));
		
		if(dc.first() != null) {
			return g.fromJson(dc.first().toJson(), Admin.class);
		}
		m.closeDB();
		
		return null;
	}

	public Doctor loginDoctor(Doctor d) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> doctors = m.getDB().getCollection("doctors");
		
		FindIterable<Document> dc = doctors.find(eq("username",d.getUsername()));
		
		if(dc.first() != null) {
			return g.fromJson(dc.first().toJson(), Doctor.class);
		}
		
		m.closeDB();
		
		return null;
	}

}
