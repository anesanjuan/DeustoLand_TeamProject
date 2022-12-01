package DeustoLand;

public abstract class User {
	
	private String nombre;
	private String apellido;
	private String dni;
	private String contrasena;
	//id
	
	public User(String nombre, String apellido, String dni, String contrasena) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.apellido = apellido;
		this.contrasena = contrasena;
	}

	public String getContrasena()
	{
		return contrasena;
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


	@Override
	public String toString() {
		return "Users [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni  + "]";
	}

	


	
}
