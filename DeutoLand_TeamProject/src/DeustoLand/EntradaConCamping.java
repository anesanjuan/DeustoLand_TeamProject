package DeustoLand;

public class EntradaConCamping extends Entrada {

	private int suplementoCamping;
	private int parcela;

	/**
	 * Creacion de una nueva entrada
	 * 
	 * @param cliente
	 * @param numeroEntrada
	 * @param festival
	 * @param suplementoCamping
	 * @param parcela
	 */
	public EntradaConCamping(Cliente cliente, int numeroEntrada, Festival festival, int suplementoCamping,
			int parcela) {
		super(cliente, numeroEntrada, festival);
		this.suplementoCamping = suplementoCamping;
		this.parcela = parcela;
	}

	public int getSuplementoCamping() {
		return suplementoCamping;
	}

	public void setSuplementoCamping(int suplementoCamping) {
		this.suplementoCamping = suplementoCamping;
	}

	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

}
