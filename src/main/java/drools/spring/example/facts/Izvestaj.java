package drools.spring.example.facts;

public class Izvestaj {
	private String ime;
	private String prezime;
	private String detalji;
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getDetalji() {
		return detalji;
	}
	public void setDetalji(String detalji) {
		this.detalji = detalji;
	}
	public Izvestaj(String ime, String prezime, String detalji) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.detalji = detalji;
	}
	@Override
	public String toString() {
		return "Izvestaj [ime=" + ime + ", prezime=" + prezime + ", detalji=" + detalji + "]";
	}
	
	public Izvestaj() {
		
	}
}
