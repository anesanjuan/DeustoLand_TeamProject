package DeustoLand;

import java.util.ArrayList;

public class Concierto extends Festival{
	
	private Artista artista;
	private Festival festival;
	private double hora;
	private double duracion;
	
	public Concierto(String nombre, double fecha, ArrayList<Concierto> listaConciertos,
			ArrayList<Artista> listaArtistas, double precio, Artista artista, Festival festival, double hora,
			double duracion) {
		super(nombre, fecha, listaConciertos, listaArtistas, precio);
		this.artista = artista;
		this.festival = festival;
		this.hora = hora;
		this.duracion = duracion;
	}

	
	public Concierto(String nombre, double fecha, ArrayList<Concierto> listaConciertos,
			ArrayList<Artista> listaArtistas, double precio) {
		super(nombre, fecha, listaConciertos, listaArtistas, precio);
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
