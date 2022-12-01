package DeustoLand;

public class Relacion {
	
	private int codF;
	private int codC;
	
	public Relacion(int codF, int codC) {
		super();
		this.codF = codF;
		this.codC = codC;
	}

	public int getCodF() {
		return codF;
	}

	public void setCodF(int codF) {
		this.codF = codF;
	}

	public int getCodC() {
		return codC;
	}

	public void setCodC(int codC) {
		this.codC = codC;
	}

	@Override
	public String toString() {
		return "Relacion [codF=" + codF + ", codC=" + codC + "]";
	}
	
	
	

}
