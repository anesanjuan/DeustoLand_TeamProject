package DeustoLand;

public class Entrada {

	// tbala entrada con lo comun + columna tipo (boolean, string.. para
	// diferenciar), + columnas especificas de cada clase

	private Cliente cliente;
	private int numeroEntrada;
	private Festival festival;
	private TipoEntrada tipoE;

	private double precio;

	public Entrada(Cliente cliente, int numeroEntrada, Festival festival, TipoEntrada tipoE) {
		super();
		this.cliente = cliente;
		this.numeroEntrada = numeroEntrada;
		this.festival = festival;
		this.tipoE = tipoE;
		}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
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
