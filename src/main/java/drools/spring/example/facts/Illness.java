package drools.spring.example.facts;

import java.util.ArrayList;

public class Illness {
	private Object _id;
	private int group;
	private String name;
	private ArrayList<Symptom> symptoms;
	public Object getId() {
		return _id;
	}
	public void setId(Object id) {
		this._id = id;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Symptom> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(ArrayList<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	
	public Illness(Object id, int group, String name, ArrayList<Symptom> symptoms) {
		super();
		this._id = id;
		this.group = group;
		this.name = name;
		this.symptoms = symptoms;
	}
	public Illness() {}
	
	@Override
	public String toString() {
		return "Illness [id=" + _id + ", group=" + group + ", name=" + name + ", symptoms=" + symptoms + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    
	    if (!Illness.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    
	    final Illness other = (Illness)obj;
	    
	    if(!this.name.equals(other.getName())) {
	    	return false;
	    }
	    
	    return true;
	}
}
