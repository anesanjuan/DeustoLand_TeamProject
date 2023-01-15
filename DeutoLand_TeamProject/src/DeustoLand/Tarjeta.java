package DeustoLand;

public class Tarjeta {
	
	private long numTarjeta;
	private String fechaCad;
	private int cvv;
	
	
	public Tarjeta(long numTarjeta, String fechaCad, int cvv) {
		super();
		this.numTarjeta = numTarjeta;
		this.fechaCad = fechaCad;
		this.cvv = cvv;
	}


	public long getNumTarjeta() {
		return numTarjeta;
	}


	public void setNumTarjeta(long numTarjeta) {
		this.numTarjeta = numTarjeta;
	}


	public String getFechaCad() {
		return fechaCad;
	}


	public void setFechaCad(String fechaCad) {
		this.fechaCad = fechaCad;
	}


	public int getCvv() {
		return cvv;
	}


	public void setCvc(int cvv) {
		this.cvv = cvv;
	}


	@Override
	public String toString() {
		return "Tarjeta [numTarjeta=" + numTarjeta + ", fechaCad=" + fechaCad + ", cvv=" + cvv + "]";
	}
	
	
	
	

}
