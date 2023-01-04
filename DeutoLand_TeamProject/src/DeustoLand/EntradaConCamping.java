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
	public EntradaConCamping( int numeroEntrada, Cliente cliente, Festival festival, TipoEntrada tipoE,  double suplementoCamping,
			int parcela  ) {
		super(numeroEntrada, cliente, festival, tipoE );
		this.suplementoCamping = suplementoCamping;
		this.parcela = parcela;
	}

	public EntradaConCamping(Cliente cliente, Festival festival, TipoEntrada tipoE,  double suplementoCamping,
			int parcela  ) {
		super(cliente, festival, tipoE );
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
