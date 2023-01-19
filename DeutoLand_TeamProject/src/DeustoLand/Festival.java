package DeustoLand;

import java.util.ArrayList;

public class Festival implements Comparable<Festival> {

	// Atributos de la clase
	private int codigoF;
	private String nombre;
	private String fecha; // date
	private String lugar;
	private String descripcion;
	private ArrayList<Concierto> listaConciertos;
	private double precio;
	private String foto;

	/**
	 * Crea un festival con los datos indicados
	 * 
	 * @param codigoF         codigo del festival
	 * @param nombre          nombre del festival
	 * @param fecha           fecha del festival
	 * @param lugar           lugar del festival
	 * @param descripcion     descripcion del festival
	 * @param listaConciertos lista de concierto que participan en el festival
	 * @param precio          precio del festival
	 * @param foto            foto del festival
	 */
	public Festival(int codigoF, String nombre, String fecha, String lugar, String descripcion,
			ArrayList<Concierto> listaConciertos, double precio, String foto) {
		super();
		this.codigoF = codigoF;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.descripcion = descripcion;
		this.listaConciertos = listaConciertos;
		this.precio = precio;
		this.foto = foto;
	}

	/**
	 * Crea una festival vacio
	 */
	public Festival() {
		super();
	}

	/**
	 * Crea un festival con los datos indicados
	 * 
	 * @param codigoF     codigo del festival
	 * @param nombre      nombre del festival
	 * @param fecha       fecha del festival
	 * @param lugar       lugar del festival
	 * @param descripcion descripcion del festival
	 * @param precio      precio del festival
	 * @param foto        foto del festival
	 */
	public Festival(int codigoF, String nombre, String fecha, String lugar, String descripcion, double precio,
			String foto) {
		super();
		this.codigoF = codigoF;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.descripcion = descripcion;
		this.precio = precio;
		this.foto = foto;
	}

	/**
	 * Obtiene el codigo del festival
	 * 
	 * @return el codigo del festival
	 */
	public int getCodigoF() {
		return codigoF;
	}

	/**
	 * El método toma un parámetro de tipo entero llamado "codigoF" y asigna ese
	 * valor al campo "codigoF" de la clase.
	 * 
	 * @param codigoF
	 */
	public void setCodigoF(int codigoF) {
		this.codigoF = codigoF;
	}

	/**
	 * Obtiene el nombre del festival
	 * 
	 * @return el nombre del festival
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
	 * Obtiene la fecha en la que se celebra el festival
	 * 
	 * @return la fecha en la que se celebra el festival
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "fecha" y asigna ese valor
	 * al campo "fecha" de la clase.
	 * 
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el lugar en el que se celebra el festival
	 * 
	 * @return el lugar en el que se celebra el festival
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "lugar" y asigna ese valor
	 * al campo "lugar" de la clase.
	 * 
	 * @param lugar
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	/**
	 * Obtiene la descripcion del festival
	 * 
	 * @return la descripcion del festival
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "descripcion" y asigna ese
	 * valor al campo "descripcion" de la clase.
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la lista de conciertos que participan en el festival
	 * 
	 * @return Ola lista de conciertos que participan en el festival
	 */
	public ArrayList<Concierto> getListaConciertos() {
		return listaConciertos;
	}

	/**
	 * Asigna un valor a la variable de instancia "listaConciertos" de la clase en
	 * la que está definido. El método tiene un parámetro "listaConciertos" de tipo
	 * "ArrayList<Concierto>", que es asignado a la variable de instancia
	 * "listaConciertos"
	 * 
	 * @param listaConciertos
	 */
	public void setListaConciertos(ArrayList<Concierto> listaConciertos) {
		this.listaConciertos = listaConciertos;
	}

	/**
	 * Obtiene el precio de
	 * 
	 * @return
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * El método toma un parámetro de tipo double llamado "precio" y asigna ese
	 * valor al campo "precio" de la clase.
	 * 
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la foto del festival
	 * 
	 * @return la foto del festival
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "foto" y asigna ese valor
	 * al campo "foto" de la clase.
	 * 
	 * @param foto
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * El método devuelve una cadena de texto que contiene información sobre los
	 * atributos del objeto, en este caso "codigoF", "nombre", "fecha", "lugar",
	 * "descripcion", "listaConciertos", "precio" y "foto".
	 */
	@Override
	public String toString() {
		return "Festival [codigoF=" + codigoF + ", nombre=" + nombre + ", fecha=" + fecha + ", lugar=" + lugar
				+ ", descripcion=" + descripcion + ", listaConciertos=" + listaConciertos + ", precio=" + precio
				+ ", foto=" + foto + "]";
	}

	/**
	 * El método compara el atributo "precio" del objeto actual con el atributo
	 * "precio" del objeto pasado como parámetro (o). Puede ser utilizado para
	 * ordenar las instancias de la clase en orden creciente basado en el atributo
	 * "precio".
	 */
	@Override
	public int compareTo(Festival o) {

		return (int) (precio * 100 - o.precio * 100);
	}

}
