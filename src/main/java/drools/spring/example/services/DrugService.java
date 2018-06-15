package drools.spring.example.services;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;


import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

import drools.spring.example.facts.Drug;
import drools.spring.example.repositories.MongoProvider;

@Service
public class DrugService implements IDrugService {
	private static Gson g = new Gson();
	
	public ArrayList<Drug> getAllDrugs() {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> drugs = m.getDB().getCollection("drugs");
		List<Document> drugsList = (List<Document>) drugs.find().into(new ArrayList<Document>());
		ArrayList<Drug> d = new ArrayList<Drug>();
		
		for(Document doc : drugsList) {
			d.add(g.fromJson(doc.toJson(), Drug.class));
		}
		
		m.closeDB();
		return d;
	}

	public void createDrug(Drug d) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> drugs = m.getDB().getCollection("drugs");
		
		Document doc = Document.parse(g.toJson(d));
		drugs.insertOne(doc);
		
		m.closeDB();
		
	}

	public void updateDrug(Drug d) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> drugs = m.getDB().getCollection("drugs");
		
		drugs.findOneAndReplace(eq("name",d.getName()), Document.parse(g.toJson(d)));
		
		m.closeDB();
		
	}

	public void deleteDrug(Drug d) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> drugs = m.getDB().getCollection("drugs");
		
		drugs.deleteOne(eq("name",d.getName()));
		
		m.closeDB();
		
	}

}
