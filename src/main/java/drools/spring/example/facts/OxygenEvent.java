package drools.spring.example.facts;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("10m")
public class OxygenEvent implements Serializable{

	private static final long serialVersionUID = 1L;
    private Date executionTime;
    private String ime;
    private int vrednost;
	
    public int getVrednost() {
		return vrednost;
	}
	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
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
	
	public OxygenEvent(String ime,int vrednost) {
		super();
		this.vrednost = vrednost;
		this.ime = ime;
		this.executionTime = new Date();
	}
	
	public OxygenEvent() {
		super();
	}
	
}
