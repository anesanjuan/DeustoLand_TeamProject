package DeustoLand;

public class Entrada { 

	
	//tbala entrada con lo comun + columna tipo (boolean, string.. para diferenciar), + columnas especificas de cada clase

	private Cliente cliente;
	private int numeroEntrada;
	private Festival festival;
	
	public Entrada(Cliente cliente, int numeroEntrada, Festival festival) {
		super();
		this.cliente = cliente;
		this.numeroEntrada = numeroEntrada;
		this.festival = festival;
	}


	public Entrada() {
		super();
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public int getNumeroEntrada() {
		return numeroEntrada;
	}


	public void setNumeroEntrada(int numeroEntrada) {
		this.numeroEntrada = numeroEntrada;
	}

	public Festival getFestival() {
		return festival;
	}


	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	@Override
	public String toString() {
		return "Entrada [cliente=" + cliente + ", numeroEntrada=" + numeroEntrada + ", festival=" + festival + "]";
	}
	
	
	
	

	
}
