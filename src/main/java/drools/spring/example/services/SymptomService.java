package drools.spring.example.services;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

import drools.spring.example.facts.Symptom;
import drools.spring.example.repositories.MongoProvider;

@Service
public class SymptomService implements ISymptomService {
	private static Gson g = new Gson();
	
	public ArrayList<Symptom> getAllSymptoms() {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> sym = m.getDB().getCollection("symptoms");
		List<Document> symList = (List<Document>) sym.find().into(new ArrayList<Document>());
		ArrayList<Symptom> s = new ArrayList<Symptom>();
		
		for(Document doc : symList) {
			s.add(g.fromJson(doc.toJson(), Symptom.class));
		}
		
		m.closeDB();
		return s;
	}

	public void createSymptom(Symptom s) {
		System.out.println("Pre create "+s.toString());
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> sym = m.getDB().getCollection("symptoms");
		
		Document doc = Document.parse(g.toJson(s));
		sym.insertOne(doc);
		
		m.closeDB();

	}

	public void updateSymptom(Symptom s) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> sym = m.getDB().getCollection("symptoms");
		
		sym.findOneAndReplace(eq("_id",s.getId()), Document.parse(g.toJson(s)));
		
		m.closeDB();

	}

	public void deleteSymptom(Symptom s) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> sym = m.getDB().getCollection("symptoms");
		
		sym.findOneAndDelete(eq("description",s.getDescription()));
		
		m.closeDB();

	}

}
