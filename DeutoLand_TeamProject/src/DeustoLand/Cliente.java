package DeustoLand;

public class Cliente extends User{
	
	private String direccion;
	private int edad;
	private String correo;

	
	
	public Cliente(int cod, String nombre, String apellido, String dni, String direccion, int edad, String correo,
			String contrasena) {
		super(cod, nombre, apellido, dni, contrasena );
		this.direccion = direccion;
		this.edad = edad;
		this.correo = correo;
	}
	
	

	public Cliente(String nombre, String apellido, String dni, String direccion, int edad, String correo,
			String contrasena) {
		super(nombre, apellido, dni, contrasena );
		this.direccion = direccion;
		this.edad = edad;
		this.correo = correo;
	}
	
	

	public Cliente(int cod, String nombre, String apellido, String dni, String contrasena ) {
		super(cod, nombre, apellido, dni, contrasena);
	}
	
	public Cliente() {
		super();
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
