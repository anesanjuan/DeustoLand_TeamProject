package DeustoLand;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private String dni;
	private String correo;
	private TipoCliente tipocliente;
	private String contrasena;
	
	
	public Cliente(String nombre, String apellido, String dni, String correo, TipoCliente tipocliente, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		this.tipocliente = tipocliente;
		this.contrasena = contrasena;

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


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
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


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", correo=" + correo
				+ ", tipocliente=" + tipocliente + ", contrasena=" + contrasena + "]";
	}


	

	

}
