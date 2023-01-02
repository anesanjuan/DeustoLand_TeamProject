package DeustoLand;

public class Entrada implements Comparable<Entrada> {

	// tbala entrada con lo comun + columna tipo (boolean, string.. para
	// diferenciar), + columnas especificas de cada clase

	private Cliente cliente;
	private int numeroEntrada;
	private Festival festival;

	private double precio;

	public Entrada(Cliente cliente, int numeroEntrada, Festival festival, double precio) {
		super();
		this.cliente = cliente;
		this.numeroEntrada = numeroEntrada;
		this.festival = festival;
		this.precio = precio;
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

	@Override
	public String toString() {
		return "Entrada [cliente=" + cliente + ", numeroEntrada=" + numeroEntrada + ", festival=" + festival + "]";
	}

	@Override
	public int compareTo(Entrada o) {

		return (int) (precio * 100 - o.precio * 100);
	}

}
