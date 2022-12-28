package DeustoLand;

public class Cliente extends User{
	
	private String direccion;
	private int edad;
	private int codigoPostal;
	
	
	
	public Cliente(int cod, String nombre, String apellido, String dni, String correo, String contrasena,
			String direccion, int edad, int codigoPostal) {
		super(cod, nombre, apellido, dni, correo, contrasena);
		this.direccion = direccion;
		this.edad = edad;
		this.codigoPostal = codigoPostal;
	}

	
	public Cliente(String nombre, String apellido, String dni, String correo, String contrasena,
			String direccion, int edad, int codigoPostal) {
		super(nombre, apellido, dni, correo, contrasena);
		this.direccion = direccion;
		this.edad = edad;
		this.codigoPostal = codigoPostal;
	}

	public Cliente(String nombre, String apellido, String dni, String correo, String contrasena) {
		super(nombre, apellido, dni, correo, contrasena);
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


	public int getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	@Override
	public String toString() {
		return "Cliente [direccion=" + direccion + ", edad=" + edad + ", codigoPostal=" + codigoPostal + "]";
	}
	
	
	
	

	
	
}
