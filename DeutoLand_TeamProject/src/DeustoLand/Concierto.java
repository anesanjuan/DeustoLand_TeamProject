package DeustoLand;

import java.util.ArrayList;

public class Concierto {
	
	private Artista artista;
	private Festival festival;
	private double hora;
	private double duracion;
	
	public Concierto( Artista artista, Festival festival, double hora, double duracion) {
		super();
		this.artista = artista;
		this.festival = festival;
		this.hora = hora;
		this.duracion = duracion;
	}

	
	public Concierto() {
		super();
	}


	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public double getHora() {
		return hora;
	}

	public void setHora(double hora) {
		this.hora = hora;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}


	@Override
	public String toString() {
		return "Concierto [artista=" + artista + ", festival=" + festival + ", hora=" + hora + ", duracion=" + duracion
				+ "]";
	}

	
	
	

}
