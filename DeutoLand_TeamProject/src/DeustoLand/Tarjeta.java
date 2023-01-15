package DeustoLand;

public class Tarjeta {
	
	private int numTarjeta;
	private String fechaCad;
	private int cvc;
	
	
	public Tarjeta(int numTarjeta, String fechaCad, int cvc) {
		super();
		this.numTarjeta = numTarjeta;
		this.fechaCad = fechaCad;
		this.cvc = cvc;
	}


	public int getNumTarjeta() {
		return numTarjeta;
	}


	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}


	public String getFechaCad() {
		return fechaCad;
	}


	public void setFechaCad(String fechaCad) {
		this.fechaCad = fechaCad;
	}


	public int getCvc() {
		return cvc;
	}


	public void setCvc(int cvc) {
		this.cvc = cvc;
	}


	@Override
	public String toString() {
		return "Tarjeta [numTarjeta=" + numTarjeta + ", fechaCad=" + fechaCad + ", cvc=" + cvc + "]";
	}
	
	
	
	

}
