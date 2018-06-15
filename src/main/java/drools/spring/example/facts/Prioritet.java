package drools.spring.example.facts;

public class Prioritet {
	private int brSym;

	public int getBrSym() {
		return brSym;
	}

	public void setBrSym(int brSym) {
		this.brSym = brSym;
	}

	public Prioritet(int brSym) {
		super();
		this.brSym = brSym;
	}
	
	public Prioritet() {
		this.brSym = 1;
	}
}
