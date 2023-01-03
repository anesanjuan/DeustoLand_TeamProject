
package DeustoLand;

public class EntradaVIP extends Entrada {

	private double suplementoVIP;
	private int numZonaVIP;

	/**
	 * Creacion de una nueva entrada
	 * 
	 * @param cliente
	 * @param numeroEntrada
	 * @param festival
	 * @param suplementoVIP
	 * @param numZonaVIP
	 */
	public EntradaVIP(Cliente cliente, int numeroEntrada, Festival festival, TipoEntrada tipoE, double suplementoVIP, int numZonaVIP) {
		super(cliente, numeroEntrada, festival, tipoE);
		this.suplementoVIP = suplementoVIP;
		this.numZonaVIP = numZonaVIP;
	}

	public double getSuplementoVIP() {
		return suplementoVIP;
	}

	public void setSuplementoVIP(double suplementoVIP) {
		this.suplementoVIP = suplementoVIP;
	}

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
