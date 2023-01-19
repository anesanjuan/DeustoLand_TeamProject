package DeustoLand;

public class EntradaConCamping extends Entrada {

	private double suplementoCamping;
	private int parcela;

	/**
	 * Creacion de una nueva entrada
	 * 
	 * @param cliente           cliente que compra la entrada
	 * @param numeroEntrada     numero de la entrada
	 * @param festival          festival al que pertenece la entrada
	 * @param suplementoCamping sumplemento de la entrada
	 * @param parcela           parcela usada para el camping
	 */
	public EntradaConCamping(int numeroEntrada, Cliente cliente, Festival festival, TipoEntrada tipoE,
			double suplementoCamping, int parcela) {
		super(numeroEntrada, cliente, festival, tipoE);
		this.suplementoCamping = suplementoCamping;
		this.parcela = parcela;
	}

	/**
	 * Creacion de una nueva entrada
	 * 
	 * @param cliente           cliente que compra la entrada
	 * @param festival          festival al que pertenece la entrada
	 * @param tipoE             tipo de entrada
	 * @param suplementoCamping sumplemento de la entrada
	 * @param parcela           parcela usada para el camping
	 */
	public EntradaConCamping(Cliente cliente, Festival festival, TipoEntrada tipoE, double suplementoCamping,
			int parcela) {
		super(cliente, festival, tipoE);
		this.suplementoCamping = suplementoCamping;
		this.parcela = parcela;
	}

	/**
	 * Crea una EntradConCamping vacia
	 */
	public EntradaConCamping() {
		super();
	}

	/**
	 * Obtiene el sumplemento a la entrada por ser con camping
	 * 
	 * @return el sumplemento a la entrada por ser con camping
	 */
	public double getSuplementoCamping() {
		return suplementoCamping;
	}

	/**
	 * El método toma un parámetro de tipo double llamado "suplementoCamping" y
	 * asigna ese valor al campo "suplementoCamping" de la clase.
	 * 
	 * @param suplementoCamping
	 */
	public void setSuplementoCamping(double suplementoCamping) {
		this.suplementoCamping = suplementoCamping;
	}

	/**
	 * Obtiene la parcela usada para el camping
	 * 
	 * @return la parcela usada para el camping
	 */
	public int getParcela() {
		return parcela;
	}

	/**
	 * El método toma un parámetro de tipo entero llamado "parcela" y asigna ese
	 * valor al campo "parcela" de la clase.
	 * 
	 * @param parcela
	 */
	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

}
