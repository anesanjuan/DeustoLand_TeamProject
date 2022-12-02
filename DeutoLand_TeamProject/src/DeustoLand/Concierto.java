package DeustoLand;

import java.util.ArrayList;

public class Concierto {
	
	private int codigoC;
	private Artista artista;
	private long hora; //cambiar tipo de variable
	private double duracion;
	private Festival festival;
	
	public Concierto( int codigoC, Artista artista, long hora, double duracion, Festival festival) {
		super();
		this.codigoC = codigoC;
		this.artista = artista;
		this.hora = hora;
		this.duracion = duracion;
		this.festival = festival;
	}

	public Concierto() {
		super();
	}


	public int getCodigoC() {
		return codigoC;
	}


	public void setCodigoC(int codigoC) {
		this.codigoC = codigoC;
	}


	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}


	public long getHora() {
		return hora;
	}

	public void setHora(long hora) {
		this.hora = hora;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	

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
