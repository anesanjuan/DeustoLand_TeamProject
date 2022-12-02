
package DeustoLand;

public class EntradaVIP extends Entrada{

	private int suplementoVIP;
	private int  numZonaVIP;
	
	/**
	 * Creacion de una nueva entrada
	 * @param cliente
	 * @param numeroEntrada
	 * @param festival
	 * @param suplementoVIP
	 * @param numZonaVIP
	 */
	public EntradaVIP(Cliente cliente, int numeroEntrada, Festival festival, int suplementoVIP, int numZonaVIP) {
		super(cliente, numeroEntrada, festival);
		this.suplementoVIP = suplementoVIP;
		this.numZonaVIP = numZonaVIP;
	}


	public int getSuplementoVIP() {
		return suplementoVIP;
	}


	public void setSuplementoVIP(int suplementoVIP) {
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
