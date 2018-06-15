package drools.spring.example.facts;

import java.util.ArrayList;


public class Drug {
	private String type;
	private String name;
	private ArrayList<String> ingredients;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public Drug(String type, String name, ArrayList<String> ingredients) {
		super();
		this.type = type;
		this.name = name;
		this.ingredients = ingredients;
	}
	public Drug() {}
	
	@Override
	public String toString() {
		return "Drug [type=" + type + ", name=" + name + ", ingredients=" + ingredients + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    
	    if (!Drug.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    
	    final Drug other = (Drug)obj;
	    
	    if(!this.name.equals(other.getName())) {
	    	return false;
	    }
	    
	    return true;
	}
}
