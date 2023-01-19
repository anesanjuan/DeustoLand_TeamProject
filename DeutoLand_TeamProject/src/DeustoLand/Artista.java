package DeustoLand;

public class Artista {

	// Atributos de la clase
	private int codigoA;
	private String nombre;
	private TipoGenero tipogenero;

	/**
	 * Creacion de un nuevo artista.
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

	/**
	 * Crea un Artista vacio.
	 */
	public Artista() {
		super();
	}

	/**
	 * Obtiene el codigo del artista
	 * 
	 * @return el codigo del artista
	 */
	public int getCodigoA() {
		return codigoA;
	}

	/**
	 * El método toma un parámetro de tipo entero llamado "codigoA" y asigna ese
	 * valor al campo "codigoA" de la clase.
	 * 
	 * @param codigoA
	 */
	public void setCodigoA(int codigoA) {
		this.codigoA = codigoA;
	}

	/**
	 * Obtiene el nombre del artista
	 * 
	 * @return el nombre del artista
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "nombre" y asigna ese
	 * valor al campo "nombre" de la clase.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el genero de las canciones del artista
	 * 
	 * @return el genero de las canciones del artista
	 */
	public TipoGenero getTipogenero() {
		return tipogenero;
	}

	/**
	 * El método toma un parámetro de tipo "TipoGenero" llamado "tipogenero" y
	 * asigna ese valor al campo "tipogenero" de la clase.
	 * 
	 * @param tipogenero
	 */
	public void setTipogenero(TipoGenero tipogenero) {
		this.tipogenero = tipogenero;
	}

	/**
	 * Devuelve una cadena que contiene los valores de los campos "codigoA",
	 * "nombre" y "tipogenero" del objeto actual.
	 */
	@Override
	public String toString() {
		return "Artista [codigoA=" + codigoA + ", nombre=" + nombre + ", tipogenero=" + tipogenero + "]";
	}
}
