package DeustoLand;

import java.util.ArrayList;

public class Festival {

	private String nombre;
	private double fecha;
	private ArrayList<Concierto> listaConciertos;
	private ArrayList<Artista> listaArtistas; // esto no estoy segura porque en el concierto ya saldra no????
	private double precio;
	
	public Festival(String nombre, double fecha, ArrayList<Concierto> listaConciertos, ArrayList<Artista> listaArtistas,
			double precio) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.listaConciertos = listaConciertos;
		this.listaArtistas = listaArtistas;
		this.precio = precio;
	}

	public Festival() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getFecha() {
		return fecha;
	}

	public void setFecha(double fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Concierto> getListaConciertos() {
		return listaConciertos;
	}

	public void setListaConciertos(ArrayList<Concierto> listaConciertos) {
		this.listaConciertos = listaConciertos;
	}

	public ArrayList<Artista> getListaArtistas() {
		return listaArtistas;
	}

	public void setListaArtistas(ArrayList<Artista> listaArtistas) {
		this.listaArtistas = listaArtistas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Festival [nombre=" + nombre + ", fecha=" + fecha + ", listaConciertos=" + listaConciertos
				+ ", listaArtistas=" + listaArtistas + ", precio=" + precio + "]";
	}
	
	
	
	
}
