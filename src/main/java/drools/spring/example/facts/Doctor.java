package drools.spring.example.facts;


public class Doctor {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Doctor(String username, String password, String firstname, String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public Doctor() {}
	
	@Override
	public String toString() {
		return "Doctor [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    
	    if (!Doctor.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    
	    final Doctor other = (Doctor)obj;
	    
	    if(!this.username.equals(other.getUsername())) {
	    	return false;
	    }
	    
	    if(!this.password.equals(other.getPassword())) {
	    	return false;
	    }
	    
	    if(!this.firstname.equals(other.getFirstname())) {
	    	return false;
	    }
	    
	    if(!this.lastname.equals(other.getLastname())) {
	    	return false;
	    }
	    
	    return true;
	}
}
