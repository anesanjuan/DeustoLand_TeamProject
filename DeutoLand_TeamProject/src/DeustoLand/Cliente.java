package DeustoLand;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private int dni;
	private String correo;
	private TipoCliente tipocliente;
	
	
	public Cliente(String nombre, String apellido, int dni, String correo, TipoCliente tipocliente) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		this.tipocliente = tipocliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public TipoCliente getTipocliente() {
		return tipocliente;
	}


	public void setTipocliente(TipoCliente tipocliente) {
		this.tipocliente = tipocliente;
	}


	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", correo=" + correo
				+ ", tipocliente=" + tipocliente + "]";
	}


}
