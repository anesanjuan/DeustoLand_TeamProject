
package DeustoLand;

public class EntradaVIP extends Entrada {

	private double suplementoVIP;
	private int numZonaVIP;

	/**
	 * Creacion de una nueva entrada
	 * 
	 * @param cliente cliente que compra la entrada
	 * @param numeroEntrada numero de la entrada
	 * @param festival festival al que pertenece la entrada
	 * @param suplementoVIP sumplemento de la entrada
	 * @param numZonaVIP numero de la zona VIP
	 */
	public EntradaVIP( int numeroEntrada, Cliente cliente, Festival festival, TipoEntrada tipoE, double suplementoVIP, int numZonaVIP) {
		super( numeroEntrada, cliente,  festival, tipoE);
		this.suplementoVIP = suplementoVIP;
		this.numZonaVIP = numZonaVIP;
	}

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
	 * @return el sumplemento VIP
	 */
	public double getSuplementoVIP() {
		return suplementoVIP;
	}

	public void setSuplementoVIP(double suplementoVIP) {
		this.suplementoVIP = suplementoVIP;
	}

	/**
	 * Obtiene el numero de la zona VIP
	 * @return el numero de la zona VIP
	 */
	public int getNumZonaVIP() {
		return numZonaVIP;
	}

	public void setNumZonaVIP(int numZonaVIP) {
		this.numZonaVIP = numZonaVIP;
	}

	@Override
	public String toString() {
		return "EntradaVIP [suplementoVIP=" + suplementoVIP + ", numZonaVIP=" + numZonaVIP + "]";
	}

}
