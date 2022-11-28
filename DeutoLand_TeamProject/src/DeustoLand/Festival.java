package DeustoLand;

import java.util.ArrayList;

public class Festival {

	private int codigoF;
	private String nombre;
	private String fecha;
	private String lugar;
	private String descripcion;
	private ArrayList<Concierto> listaConciertos;
	private ArrayList<Artista> listaArtistas; // esto no estoy segura porque en el concierto ya saldra no????
	private double precio;
	
	public Festival(int codigoF,String nombre, String fecha, String lugar, String descripcion, ArrayList<Concierto> listaConciertos, ArrayList<Artista> listaArtistas,
			double precio) {
		super();
		this.codigoF = codigoF;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.descripcion = descripcion;
		this.listaConciertos = listaConciertos;
		this.listaArtistas = listaArtistas;
		this.precio = precio;
	}

	public Festival() {
		super();
	}

	
	
	public int getCodigoF() {
		return codigoF;
	}

	public void setCodigoF(int codigoF) {
		this.codigoF = codigoF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		return "Festival [codigo=" + codigoF + ", nombre=" + nombre +", fecha=" + fecha + ", lugar=" + lugar + ", descripción=" + descripcion + ", listaConciertos=" + listaConciertos
				+ ", listaArtistas=" + listaArtistas + ", precio=" + precio + "]";
	}
	
	
	
	
}
