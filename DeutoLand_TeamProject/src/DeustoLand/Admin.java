package DeustoLand;

public class Admin extends User {

	// Atributos de la clase
	private String fechaUltimaMod;

	/**
	 * Creacion de un Admin con los datos indicados.
	 * 
	 * @param cod            codigo del aministrador
	 * @param nombre         nombre del administrador
	 * @param apellido       apellido del administrador
	 * @param dni            dni del administrador
	 * @param correo         correo del administrador
	 * @param contrasena     contraseña del administrador
	 * @param fechaUltimaMod fecha de la ultima vez que el administrador inicio
	 *                       sesion
	 */
	public Admin(int cod, String nombre, String apellido, String dni, String correo, String contrasena,
			String fechaUltimaMod) {
		super(cod, nombre, apellido, dni, correo, contrasena);
		this.fechaUltimaMod = fechaUltimaMod;
	}

	/**
	 * Crea un Admin con los datos indicados.
	 * 
	 * @param nombre         nombre del administrador
	 * @param apellido       apellido del administrador
	 * @param dni            dni del administrador
	 * @param correo         correo del administrador
	 * @param contrasena     ontraseña del administrador
	 * @param fechaUltimaMod fecha de la ultima vez que el administrador inicio
	 *                       sesion
	 */
	public Admin(String nombre, String apellido, String dni, String correo, String contrasena, String fechaUltimaMod) {
		super(nombre, apellido, dni, correo, contrasena);
		this.fechaUltimaMod = fechaUltimaMod;
	}

	/**
	 * Crea un Admin vacio
	 */
	public Admin() {
		super();
	}

	/**
	 * Obtiene la fecha de la ultima vez que el admin inicio sesion
	 * 
	 * @return fecha de la ultima vez que el administrador inicio sesion
	 */
	public String getFechaUltimaMod() {
		return fechaUltimaMod;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "fechaUltimaMod" y asigna
	 * ese valor al campo "fechaUltimaMod" de la clase.
	 * 
	 * @param fechaUltimaMod
	 */
	public void setFechaUltimaMod(String fechaUltimaMod) {
		this.fechaUltimaMod = fechaUltimaMod;
	}

	/**
	 * Devuelve una cadena que contiene el valor del campo "fechaUltimaMod"
	 */
	@Override
	public String toString() {
		return "Admin [fechaUltimaMod=" + fechaUltimaMod + "]";
	}

}