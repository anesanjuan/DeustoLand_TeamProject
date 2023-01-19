
package DeustoLand;

public class EntradaVIP extends Entrada {

	private double suplementoVIP;
	private int numZonaVIP;

	/**
	 * Creacion de una nueva entrada
	 * 
	 * @param cliente       cliente que compra la entrada
	 * @param numeroEntrada numero de la entrada
	 * @param festival      festival al que pertenece la entrada
	 * @param suplementoVIP sumplemento de la entrada
	 * @param numZonaVIP    numero de la zona VIP
	 */
	public EntradaVIP(int numeroEntrada, Cliente cliente, Festival festival, TipoEntrada tipoE, double suplementoVIP,
			int numZonaVIP) {
		super(numeroEntrada, cliente, festival, tipoE);
		this.suplementoVIP = suplementoVIP;
		this.numZonaVIP = numZonaVIP;
	}

	/**
	 * Creacion de una nueva entrada
	 * 
	 * @param cliente       cliente que compra la entrada
	 * @param festival      festival al que pertenece la entrada
	 * @param tipoE         tipo de entrada
	 * @param suplementoVIP sumplemento de la entrada
	 * @param numZonaVIP    numero de la zona VIP
	 */
	public EntradaVIP(Cliente cliente, Festival festival, TipoEntrada tipoE, double suplementoVIP, int numZonaVIP) {
		super(cliente, festival, tipoE);
		this.suplementoVIP = suplementoVIP;
		this.numZonaVIP = numZonaVIP;
	}

	/**
	 * Crea una entrada vacia
	 */
	public EntradaVIP() {
		super();
	}

	/**
	 * Obtiene el sumplemento VIP
	 * 
	 * @return el sumplemento VIP
	 */
	public double getSuplementoVIP() {
		return suplementoVIP;
	}

	/**
	 * El método toma un parámetro de tipo double llamado "suplementoVIP" y asigna
	 * ese valor al campo "suplementoVIP" de la clase.
	 * 
	 * @param suplementoVIP
	 */
	public void setSuplementoVIP(double suplementoVIP) {
		this.suplementoVIP = suplementoVIP;
	}

	/**
	 * Obtiene el numero de la zona VIP
	 * 
	 * @return el numero de la zona VIP
	 */
	public int getNumZonaVIP() {
		return numZonaVIP;
	}

	/**
	 * El método toma un parámetro de tipo entero llamado "numZonaVIP" y asigna ese
	 * valor al campo "numZonaVIP" de la clase.
	 * 
	 * @param numZonaVIP
	 */
	public void setNumZonaVIP(int numZonaVIP) {
		this.numZonaVIP = numZonaVIP;
	}

	/**
	 * El método devuelve una cadena de texto que contiene información sobre los
	 * atributos del objeto, en este caso "suplementoVIP" y "numZonaVIP".
	 */
	@Override
	public String toString() {
		return "EntradaVIP [suplementoVIP=" + suplementoVIP + ", numZonaVIP=" + numZonaVIP + "]";
	}

}
