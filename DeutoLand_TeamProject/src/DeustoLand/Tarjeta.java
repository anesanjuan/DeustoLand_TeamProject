package DeustoLand;

public class Tarjeta {

	private long numTarjeta;
	private String fechaCad;
	private int cvv;

	/**
	 * Constructor de la clase:
	 * 
	 * @param numTarjeta numero de la tarjeta
	 * @param fechaCad   fehca de caducidad de la tarjeta
	 * @param cvv        clave de seguridad de la tarjeta
	 */
	public Tarjeta(long numTarjeta, String fechaCad, int cvv) {
		super();
		this.numTarjeta = numTarjeta;
		this.fechaCad = fechaCad;
		this.cvv = cvv;
	}

	/**
	 * Este es un método que devuelve el valor de la variable de instancia
	 * "numTarjeta" que es de tipo long.
	 * 
	 * @return
	 */
	public long getNumTarjeta() {
		return numTarjeta;
	}

	/**
	 * El método toma un parámetro de tipo long llamado "numTarjeta" y asigna ese
	 * valor al campo "numTarjeta" de la clase.
	 * 
	 * @param numTarjeta numero de la trajeta
	 */
	public void setNumTarjeta(long numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	/**
	 * Este es un método que devuelve el valor de la variable de instancia
	 * "fechaCad" que es de tipo String
	 * 
	 * @return
	 */
	public String getFechaCad() {
		return fechaCad;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "fechaCad" y asigna ese
	 * valor al campo "fechaCad" de la clase.
	 * 
	 * @param fechaCad fecha de caducidad de la trajeta
	 */
	public void setFechaCad(String fechaCad) {
		this.fechaCad = fechaCad;
	}

	/**
	 * Este es un método que devuelve el valor de la variable de instancia "cvv" que
	 * es de tipo entero
	 * 
	 * @return
	 */
	public int getCvv() {
		return cvv;
	}

	/**
	 * El método toma un parámetro de tipo entero llamado "cvv" y asigna ese valor
	 * al campo "cvv" de la clase.
	 * 
	 * @param cvv
	 */
	public void setCvc(int cvv) {
		this.cvv = cvv;
	}

	/**
	 * El método devuelve una cadena que incluye los valores de las variables de
	 * instancia "numTarjeta", "fechaCad" y "cvv".
	 */
	@Override
	public String toString() {
		return "Tarjeta [numTarjeta=" + numTarjeta + ", fechaCad=" + fechaCad + ", cvv=" + cvv + "]";
	}

}
