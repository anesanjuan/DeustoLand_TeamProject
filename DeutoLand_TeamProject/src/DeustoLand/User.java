package DeustoLand;

public abstract class User {
	
	private int cod;
	private String nombre;
	private String apellido;
	private String dni;
	private String contrasena;
	
	
	public User(int cod, String nombre, String apellido, String dni, String contrasena) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.dni = dni;
		this.apellido = apellido;
		this.contrasena = contrasena;
	}
	
	public User(String nombre, String apellido, String dni, String contrasena) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.apellido = apellido;
		this.contrasena = contrasena;
	}


	public User() {
		super();
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
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


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	@Override
	public String toString() {
		return "User [cod=" + cod + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", contrasena="
				+ contrasena + "]";
	}

	
	
	
	}
