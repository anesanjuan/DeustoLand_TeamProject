package DeustoLand;

public class Entrada {

	// tbala entrada con lo comun + columna tipo (boolean, string.. para
	// diferenciar), + columnas especificas de cada clase

	
	
	//Atributos de la clase
	private Cliente cliente;
	private int numeroEntrada;
	private Festival festival;
	private TipoEntrada tipoE;
	

	//constructor entero
	/**
	 * Crea una entrada con los datos indicados
	 * @param cliente cliente que compra la entrada
	 * @param numeroEntrada numero de la entrada
	 * @param festival festival al que pertenece la entrada
	 * @param tipoE tipo de la entrada
	 */
	public Entrada(int numeroEntrada,  Cliente cliente,Festival festival, TipoEntrada tipoE) {
		super();
		this.cliente = cliente;
		this.numeroEntrada = numeroEntrada;
		this.festival = festival;
		this.tipoE = tipoE;
		}
	
	public Entrada(Cliente cliente, Festival festival, TipoEntrada tipoE) {
		super();
		this.cliente = cliente;
		this.festival = festival;
		this.tipoE = tipoE;
		}
	
	/**
	 * Crea una entrada vacia.
	 */
	public Entrada() {
		super();
	}
	
	/**
	 * Obtiene el cliente que compra la entrada
	 * @return el cliente que compra la entrada
	 */
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * Obtiene el numero de la entrada
	 * @return el numero de la entrada
	 */
	public int getNumeroEntrada() {
		return numeroEntrada;
	}

	public void setNumeroEntrada(int numeroEntrada) {
		this.numeroEntrada = numeroEntrada;
	}
	/**
	 * Obtiene el festival al que pertenece la entrada
	 * @return el festival al que pertenece la entrada
	 */
	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}
	
	/**
	 * Obtiene el tipo de entrada
	 * @return el tipo de entrada
	 */
	public TipoEntrada getTipoE() {
		return tipoE;
	}

	public void setTipoE(TipoEntrada tipoE) {
		this.tipoE = tipoE;
	}
	

	@Override
	public String toString() {
		return "Entrada [cliente=" + cliente + ", numeroEntrada=" + numeroEntrada + ", festival=" + festival + "]";
	}

	

}
