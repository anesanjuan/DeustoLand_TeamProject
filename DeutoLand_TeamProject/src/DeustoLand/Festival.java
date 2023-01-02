package DeustoLand;

import java.util.ArrayList;

public class Festival {

	private int codigoF;
	private String nombre;
	private String fecha; // date
	private String lugar;
	private String descripcion;
	private ArrayList<Concierto> listaConciertos;
	private double precio;
	private String foto;

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

	public Festival() {
		super();
	}

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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Festival [codigoF=" + codigoF + ", nombre=" + nombre + ", fecha=" + fecha + ", lugar=" + lugar
				+ ", descripcion=" + descripcion + ", listaConciertos=" + listaConciertos + ", precio=" + precio
				+ ", foto=" + foto + "]";
	}

}
