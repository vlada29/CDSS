package drools.spring.example.facts;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("1m")
public class HBEvent implements Serializable{

	private static final long serialVersionUID = 1L;
    private Date executionTime;
    private String ime;
	
    public Date getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public HBEvent() {
		super();
	}
	public HBEvent(String ime) {
		super();
		this.ime = ime;
		this.executionTime = new Date();
	}
	
	
}
