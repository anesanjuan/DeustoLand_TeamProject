package DeustoLand;

public class Cliente extends User{
	
	private String direccion;
	private int edad;
	private String correo;

	
	public Cliente(int cod, String nombre, String apellido, String dni, String correo, String contrasena,
			String direccion, int edad, String correo2) {
		super(cod, nombre, apellido, dni, correo, contrasena);
		this.direccion = direccion;
		this.edad = edad;
		correo = correo2;
	}
	

	public Cliente(int cod, String nombre, String apellido, String dni, String contrasena ) {
		super(cod, nombre, apellido, dni, contrasena, contrasena);
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
