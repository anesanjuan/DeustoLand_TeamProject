package DeustoLand;

public class Cliente extends User {

	//Atributos de la clase
	private String direccion;
	private int edad;
	private int codigoP;

	/**
	 * Crea un cliente con los datos indicados.
	 * @param cod codigo del cliente
	 * @param nombre nombre del cliente
	 * @param apellido apellido del cliente
	 * @param dni dni del cliente
	 * @param correo correo del cliente
	 * @param contrasena contraseña del cliente
	 * @param direccion direccion del cliente
	 * @param edad edad del cliente
	 * @param codigoP codigoP del cliente
	 */
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
	/**
	 * Crea un cliente vacio.
	 */
	public Cliente() {
		super();

	}

	/**
	 * Obtiene la direccion del cliente
	 * @return la direccion del cliente
	 */
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene la edad del cliente
	 * @return la edad del cliente
	 */
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Obtiene el codigo postal del cliente
	 * @return el codigo postal del cliente
	 */
	public int getCodigoP() {
		return codigoP;
	}

	public void setCodigoP(int codigoP) {
		this.codigoP = codigoP;
	}

}
