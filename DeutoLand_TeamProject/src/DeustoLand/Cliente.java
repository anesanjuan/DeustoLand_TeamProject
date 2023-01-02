package DeustoLand;

public class Cliente extends User {

	private String direccion;
	private int edad;
	private int codigoP;

	public Cliente(int cod, String nombre, String apellido, String dni, String correo, String contrasena,
			String direccion, int edad, int codigoP) {
		super(cod, nombre, apellido, dni, correo, contrasena);
		this.direccion = direccion;
		this.edad = edad;
		this.codigoP = codigoP;

	}

	public Cliente(String nombre, String apellido, String dni, String correo, String contrasena, String direccion,
			int edad, int codigoP) {
		super(nombre, apellido, dni, correo, contrasena);
		this.direccion = direccion;
		this.edad = edad;
		this.codigoP = codigoP;

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

	public int getCodigoP() {
		return codigoP;
	}

	public void setCodigoP(int codigoP) {
		this.codigoP = codigoP;
	}

}
