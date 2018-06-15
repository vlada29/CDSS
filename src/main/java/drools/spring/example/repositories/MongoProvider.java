package drools.spring.example.repositories;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoProvider {
	private MongoDatabase db;
	private MongoClient mc;
	
	public MongoProvider() {
		mc = new MongoClient("localhost" , 27017);
		db=mc.getDatabase("CDSS");
	}
	
	public MongoDatabase getDB() {
		return db;
	}
	
	public void closeDB() {
		mc.close();
	}
}
