package drools.spring.example.facts;

import java.util.ArrayList;
import java.util.Date;


public class Diagnose {
	public Date datumDijagnoze;
	private Illness dijagnostikovanaBolest;
	private ArrayList<Drug> prepisaniLekovi;
	private Doctor lekar;
	
	
	
	public Doctor getLekar() {
		return lekar;
	}
	public void setLekar(Doctor lekar) {
		this.lekar = lekar;
	}
	public Date getDatumDijagnoze() {
		return datumDijagnoze;
	}
	public void setDatumDijagnoze(Date datumDijagnoze) {
		this.datumDijagnoze = datumDijagnoze;
	}
	public Illness getDijagnostikovanaBolest() {
		return dijagnostikovanaBolest;
	}
	public void setDijagnostikovanaBolest(Illness dijagnostikovanaBolest) {
		this.dijagnostikovanaBolest = dijagnostikovanaBolest;
	}
	public ArrayList<Drug> getPrepisaniLekovi() {
		return prepisaniLekovi;
	}
	public void setPrepisaniLekovi(ArrayList<Drug> prepisaniLekovi) {
		this.prepisaniLekovi = prepisaniLekovi;
	}

	
	
	public Diagnose(Date datumDijagnoze, Illness dijagnostikovanaBolest, ArrayList<Drug> prepisaniLekovi,
			Doctor lekar) {
		super();
		this.datumDijagnoze = datumDijagnoze;
		this.dijagnostikovanaBolest = dijagnostikovanaBolest;
		this.prepisaniLekovi = prepisaniLekovi;
		this.lekar = lekar;
	}
	
	
	@Override
	public String toString() {
		return "Diagnose [datumDijagnoze=" + datumDijagnoze + ", dijagnostikovanaBolest=" + dijagnostikovanaBolest
				+ ", prepisaniLekovi=" + prepisaniLekovi + ", lekar=" + lekar + "]";
	}
	
	public Diagnose() {
		
	}
	
	public boolean containsAntibiotics() {
		for(Drug d : prepisaniLekovi) {
			if(d.getType().equals("antibiotic")) {
				return false;
			}
		}
		return true;
	}
	
	public boolean containsAnalgetics() {
		for(Drug d : prepisaniLekovi) {
			if(d.getType().equals("analgetic")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean godina() {
		Date d = new Date();
		if((d.getTime() - datumDijagnoze.getTime()) < new Long("31556952000")) {
			return true;
		}
		return false;
	}
}
