package DeustoLand;

public class EntradaConCamping extends Entrada {

	private double suplementoCamping;
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
	public EntradaConCamping(Cliente cliente, int numeroEntrada, Festival festival, TipoEntrada tipoE,  double suplementoCamping,
			int parcela  ) {
		super(cliente, numeroEntrada, festival, tipoE );
		this.suplementoCamping = suplementoCamping;
		this.parcela = parcela;
	}

	public double getSuplementoCamping() {
		return suplementoCamping;
	}

	public void setSuplementoCamping(double suplementoCamping) {
		this.suplementoCamping = suplementoCamping;
	}

	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

}
