package drools.spring.example.facts;

public class MPatient {
//\
//
//
//ime: string;
//prezime: string;
//kiseonik: number;
//otkucaji: number;
//mokraca: number;
	private String ime;
	private String prezime;
	private int kiseonik;
	private int otkucaji;
	private int mokraca;
	private boolean boluje;
	
	
	public boolean isBoluje() {
		return boluje;
	}
	public void setBoluje(boolean boluje) {
		this.boluje = boluje;
	}
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
	public int getKiseonik() {
		return kiseonik;
	}
	public void setKiseonik(int kiseonik) {
		this.kiseonik = kiseonik;
	}
	public int getOtkucaji() {
		return otkucaji;
	}
	public void setOtkucaji(int otkucaji) {
		this.otkucaji = otkucaji;
	}
	public int getMokraca() {
		return mokraca;
	}
	public void setMokraca(int mokraca) {
		this.mokraca = mokraca;
	}
	public MPatient(String ime, String prezime, int kiseonik, int otkucaji, int mokraca,boolean boluje) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.kiseonik = kiseonik;
		this.otkucaji = otkucaji;
		this.mokraca = mokraca;
		this.boluje = boluje;
	}
	
	public MPatient() {
		
	}
	@Override
	public String toString() {
		return "MPatient [ime=" + ime + ", prezime=" + prezime + ", kiseonik=" + kiseonik + ", otkucaji=" + otkucaji
				+ ", mokraca=" + mokraca + "]";
	}
	
	
	
}
