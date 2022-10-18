package DeustoLand;

public class Artista {
	private String nombre;
	private Festival festival;
	private TipoGenero tipogenero;
	
	
	public Artista(String nombre, Festival festival, TipoGenero tipogenero) {
		super();
		this.nombre = nombre;
		this.festival = festival;
		this.tipogenero = tipogenero;
	}


	public Artista() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Festival getFestival() {
		return festival;
	}


	public void setFestival(Festival festival) {
		this.festival = festival;
	}


	public TipoGenero getTipogenero() {
		return tipogenero;
	}


	public void setTipogenero(TipoGenero tipogenero) {
		this.tipogenero = tipogenero;
	}


	@Override
	public String toString() {
		return "Artista [nombre=" + nombre + ", festival=" + festival + ", tipogenero=" + tipogenero + "]";
	}
	
	
	
	
	
}
