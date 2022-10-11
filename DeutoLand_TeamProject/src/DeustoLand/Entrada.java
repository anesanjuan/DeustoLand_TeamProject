package DeustoLand;

public class Entrada extends Cliente{ //No se como hacer que la clase extienda de dos clases, porque en teoria tambien extenderia de festival, para datos tipo hora , dia y asi

	private Cliente cliente;
	private int numeroEntrada;
	
	

	public Entrada(String nombre, String apellido, String dni, String correo, TipoCliente tipocliente,
			String contrasena, Cliente cliente, int numeroEntrada) {
		super(nombre, apellido, dni, correo, tipocliente, contrasena);
		this.cliente = cliente;
		this.numeroEntrada = numeroEntrada;
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

	@Override
	public String toString() {
		return "Entrada [cliente=" + cliente + ", numeroEntrada=" + numeroEntrada + "]";
	}
	
	
	

	
}
