package drools.spring.example.facts;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
@Role(Role.Type.EVENT)
@Expires("1m")
public class MEvent implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private	String ime;
    private int kolicina;
    private boolean boluje;
    
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public boolean isBoluje() {
		return boluje;
	}
	public void setBoluje(boolean boluje) {
		this.boluje = boluje;
	}
	public MEvent(String ime, int kolicina, boolean boluje) {
		super();
		this.ime = ime;
		this.kolicina = kolicina;
		this.boluje = boluje;
	}
    
    public MEvent() {
    	super();
    }
	
}
