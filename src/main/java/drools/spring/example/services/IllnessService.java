package drools.spring.example.services;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

import drools.spring.example.facts.Illness;
import drools.spring.example.repositories.MongoProvider;

@Service
public class IllnessService implements IIllnessService{
	private static Gson g = new Gson();

	public ArrayList<Illness> getAllIllnesses() {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> ill = m.getDB().getCollection("illnesses");
		List<Document> illList = (List<Document>) ill.find().into(new ArrayList<Document>());
		ArrayList<Illness> i = new ArrayList<Illness>();
		
		for(Document doc : illList) {
			i.add(g.fromJson(doc.toJson(), Illness.class));
		}
		
		m.closeDB();
		return i;
	}

	public void createIllness(Illness i) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> ill = m.getDB().getCollection("illnesses");
		
		Document doc = Document.parse(g.toJson(i));
		ill.insertOne(doc);
		
		m.closeDB();
		
	}

	public void updateIllness(Illness i) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> ill = m.getDB().getCollection("illnesses");
		
		ill.findOneAndReplace(eq("name",i.getName()), Document.parse(g.toJson(i)));
		
		m.closeDB();
		
	}

	public void deleteIllness(Illness i) {
		MongoProvider m = new MongoProvider();
		MongoCollection<Document> ill = m.getDB().getCollection("illnesses");
		
		ill.deleteOne(eq("name",i.getName()));
		
		m.closeDB();
		
	}
	
	
}
