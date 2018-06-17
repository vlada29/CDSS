package drools.spring.example.facts;

public class NivoKiseonika {
	private String ime;
	private int vrednost;
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public int getVrednost() {
		return vrednost;
	}
	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
	public NivoKiseonika(String ime, int vrednost) {
		super();
		this.ime = ime;
		this.vrednost = vrednost;
	}
	
	public NivoKiseonika() {
		super();
	}
}
