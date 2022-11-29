package DeustoLand;

public class Artista {
	
	private int codigoA;
	private String nombre;
	private Festival festival;
	private TipoGenero tipogenero;
	
	
	public Artista(int codigoA, String nombre, Festival festival, TipoGenero tipogenero) {
		super();
		this.codigoA = codigoA;
		this.nombre = nombre;
		this.festival = festival;
		this.tipogenero = tipogenero;
	}


	public Artista() {
		super();
	}

	public int getCodigoA() {
		return codigoA;
	}


	public void setCodigoA(int codigoA) {
		this.codigoA = codigoA;
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
		return "Artista [codigoA=" + codigoA + ", nombre=" + nombre + ", festival=" + festival + ", tipogenero="
				+ tipogenero + "]";
	}	
}
