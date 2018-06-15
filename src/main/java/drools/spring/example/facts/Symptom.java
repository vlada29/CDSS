package drools.spring.example.facts;

public class Symptom {
	private Object _id;
	private String description;
	private boolean special;
	
	
	public boolean isSpecial() {
		return special;
	}
	public void setSpecial(boolean special) {
		this.special = special;
	}
	public Object getId() {
		return _id;
	}
	public void setId(Object id) {
		this._id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	public Symptom(Object _id, String description, boolean special) {
		super();
		this._id = _id;
		this.description = description;
		this.special = special;
	}
	public Symptom() {}

	@Override
	public String toString() {
		return "Symptom [_id=" + _id + ", description=" + description + ", special=" + special + "]";
	}
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    
	    if (!Symptom.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    
	    final Symptom other = (Symptom)obj;
	    
	    if(!this.description.equals(other.getDescription())) {
	    	return false;
	    }
	    
	    return true;
	}
}
