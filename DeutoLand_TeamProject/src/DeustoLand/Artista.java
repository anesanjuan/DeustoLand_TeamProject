package DeustoLand;

public class Artista {

	private int codigoA;
	private String nombre;
	private TipoGenero tipogenero;

	/**
	 * Creacion de un nuevo artista
	 * 
	 * @param codigoA    Codigo del artista
	 * @param nombre     Nombre del artista
	 * @param tipogenero Genero de las canciones del artista
	 */
	public Artista(int codigoA, String nombre, TipoGenero tipogenero) {
		super();
		this.codigoA = codigoA;
		this.nombre = nombre;
		this.tipogenero = tipogenero;
	}

	public Artista() {
		super();
	}

	public int getCodigoA() {
		return codigoA;
	}

	public void setCodigoA(int codigoA) {
		this.codigoA = codigoA;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoGenero getTipogenero() {
		return tipogenero;
	}

	public void setTipogenero(TipoGenero tipogenero) {
		this.tipogenero = tipogenero;
	}

	@Override
	public String toString() {
		return "Artista [codigoA=" + codigoA + ", nombre=" + nombre + ", tipogenero=" + tipogenero + "]";
	}
}
