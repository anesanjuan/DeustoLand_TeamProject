package DeustoLand;

public class Concierto {

	// Atributos de la clase
	private int codigoC;
	private Artista artista;
	private long hora;
	private double duracion;
	private Festival festival;

	/**
	 * Crea un concierto con los datos indicados.
	 * 
	 * @param codigoC  codigo del concierto
	 * @param artista  artista que canta en el concierto
	 * @param hora     hora del concierto
	 * @param duracion duracion del concierto
	 * @param festival festival al que pertence el concierto
	 */
	public Concierto(int codigoC, Artista artista, long hora, double duracion, Festival festival) {
		super();
		this.codigoC = codigoC;
		this.artista = artista;
		this.hora = hora;
		this.duracion = duracion;
		this.festival = festival;
	}
	
	public Concierto(Artista artista, long hora, double duracion, Festival festival) {
		super();
		this.artista = artista;
		this.hora = hora;
		this.duracion = duracion;
		this.festival = festival;
	}

	/**
	 * Crea un concierto vacio
	 */
	public Concierto() {
		super();
	}

	/**
	 * Obtiene el codigo del concierto
	 * 
	 * @return el codigo del concierto
	 */
	public int getCodigoC() {
		return codigoC;
	}

	/**
	 * El método toma un parámetro de tipo entero llamado "codigoC" y asigna ese
	 * valor al campo "codigoC" de la clase
	 * 
	 * @param codigoC
	 */
	public void setCodigoC(int codigoC) {
		this.codigoC = codigoC;
	}

	/**
	 * Obtiene el artista que canta en el concierto
	 * 
	 * @return el artista que canta en el concierto
	 */
	public Artista getArtista() {
		return artista;
	}

	/**
	 * El método toma un parámetro de tipo "Artista" llamado "artista" y asigna ese
	 * valor al campo "artista" de la clase
	 * 
	 * @param artista
	 */
	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	/**
	 * Obtiene la hora a la que empieza el concierto
	 * 
	 * @return la hora a la que empieza el concierto
	 */
	public long getHora() {
		return hora;
	}

	/**
	 * El método toma un parámetro de tipo long llamado "hora" y asigna ese valor al
	 * campo "hora" de la clase.
	 * 
	 * @param hora
	 */
	public void setHora(long hora) {
		this.hora = hora;
	}

	/**
	 * Obtiene la duracion del concierto
	 * 
	 * @return la duracion del concierto
	 */
	public double getDuracion() {
		return duracion;
	}

	/**
	 * El método toma un parámetro de tipo double llamado "duracion" y asigna ese
	 * valor al campo "duracion" de la clase
	 * 
	 * @param duracion
	 */
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	/**
	 * Obtiene el festival al que pertenece el concierto
	 * 
	 * @return el festival al que pertenece el concierto
	 */
	public Festival getFestival() {
		return festival;
	}

	/**
	 * El método toma un parámetro de tipo "Festival" llamado "festival" y asigna
	 * ese valor al campo "festival" de la clase
	 * 
	 * @param festival
	 */
	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	/**
	 * Devuelve una cadena que contiene los valores de los campos "codigoC",
	 * "artista", "hora", "duracion" y "festival" del objeto actual
	 */
	@Override
	public String toString() {
		return "Concierto [codigoC=" + codigoC + ", artista=" + artista + ", hora=" + hora + ", duracion=" + duracion
				+ ", festival=" + festival + "]";
	}

}
