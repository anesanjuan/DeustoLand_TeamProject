package DeustoLand;

public class Cliente extends User{
	
	private String direccion;
	private int edad;
	private String correo;
	private String contrasena;
	
	public Cliente(String nombre, String apellido, String dni, String direccion, int edad, String correo,
			String contrasena) {
		super(nombre, apellido, dni);
		this.direccion = direccion;
		this.edad = edad;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public Cliente(String nombre, String apellido, String dni) {
		super(nombre, apellido, dni);
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Cliente [direccion=" + direccion + ", edad=" + edad + ", correo=" + correo + ", contrasena="
				+ contrasena + "]";
	}
	
	
	
	

	

}
