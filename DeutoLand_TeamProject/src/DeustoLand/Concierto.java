package DeustoLand;

import java.sql.Date;
import java.util.ArrayList;

public class Concierto {

	//Atributos de la clase
	private int codigoC;
	private Artista artista;
	private long hora;
	private double duracion;
	private Festival festival;

	/**
	 * Crea un concierto con los datos indicados.
	 * @param codigoC codigo del concierto
	 * @param artista artista que canta en el concierto
	 * @param hora hora del concierto
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

	/**
	 * Crea un concierto vacio
	 */
	public Concierto() {
		super();
	}

	/**
	 * Obtiene el codigo del concierto
	 * @return el codigo del concierto
	 */
	public int getCodigoC() {
		return codigoC;
	}

	public void setCodigoC(int codigoC) {
		this.codigoC = codigoC;
	}

	/**
	 * Obtiene el artista que canta en el concierto
	 * @return el artista que canta en el concierto
	 */
	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	/**
	 * Obtiene la hora a la que empieza el concierto
	 * @return la hora a la que empieza el concierto
	 */
	public long getHora() {
		return hora;
	}

	public void setHora(long hora) {
		this.hora = hora;
	}

	/**
	 * Obtiene la duracion del concierto
	 * @return la duracion del concierto
	 */
	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	/**
	 * Obtiene el festival al que pertenece el concierto
	 * @return el festival al que pertenece el concierto
	 */
	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	@Override
	public String toString() {
		return "Concierto [codigoC=" + codigoC + ", artista=" + artista + ", hora=" + hora + ", duracion=" + duracion
				+ ", festival=" + festival + "]";
	}

}
