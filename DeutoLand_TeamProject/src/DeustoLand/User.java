package DeustoLand;

import java.util.Objects;

public class User implements Comparable<User> {

	// Atributos de la clase
	private int cod;
	private String nombre;
	private String apellido;
	private String dni;
	private String correo;
	private String contrasena;

	/**
	 * Crea un user con los datos indicados.
	 * 
	 * @param cod        codigo del user
	 * @param nombre     nombre del user
	 * @param apellido   apellido del user
	 * @param dni        dni del user
	 * @param correo     correo del user
	 * @param contrasena contraseña adel user
	 */
	public User(int cod, String nombre, String apellido, String dni, String correo, String contrasena) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	/**
	 * Constructor de la clase que incluye los siguientes parametros:
	 * 
	 * @param nombre     nombre del user
	 * @param apellido   apellido del user
	 * @param dni        dni del user
	 * @param correo     correo del user
	 * @param contrasena contraseña del user
	 */
	public User(String nombre, String apellido, String dni, String correo, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	/**
	 * Crea un user vacio
	 */
	public User() {
		super();
	}

	/**
	 * Obtiene el codigo del user
	 * 
	 * @return el codigo del user
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * El método toma un parámetro de tipo entero llamado "cod" y asigna ese valor
	 * al campo "cod" de la clase.
	 * 
	 * @param cod codigo del user
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}

	/**
	 * Obtiene el nombre del user
	 * 
	 * @return el nombre del user
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "nombre" y asigna ese
	 * valor al campo "nombre" de la clase.
	 * 
	 * @param nombre nombre del user
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el apellido del user
	 * 
	 * @return el apellido del user
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "apellido" y asigna ese
	 * valor al campo "apellido" de la clase.
	 * 
	 * @param apellido apellido del usuario
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Obtiene el dni del user
	 * 
	 * @return el dni del user
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "dni" y asigna ese valor
	 * al campo "dni" de la clase.
	 * 
	 * @param dni dni del usuario
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Obtiene el correo del user
	 * 
	 * @return el correo del user
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "correo" y asigna ese
	 * valor al campo "correo" de la clase.
	 * 
	 * @param correo correo del usuario
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Obtiene la contraseña del user
	 * 
	 * @return la contraseña del user
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * El método toma un parámetro de tipo String llamado "contrasena" y asigna ese
	 * valor al campo "contrasena" de la clase.
	 * 
	 * @param contrasena contraseña del usuario
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * El método devuelve una cadena que incluye los valores de las variables de
	 * instancia "cod", "nombre", "apellido", "dni", "correo" y "contrasena".
	 */
	@Override
	public String toString() {
		return "User [cod=" + cod + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", correo="
				+ correo + ", contrasena=" + contrasena + "]";
	}

	/**
	 * Este método se utiliza para generar un identificador único para un objeto.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(contrasena, correo);
	}

	/**
	 * El método comprueba si el objeto actual y el objeto pasado como parámetro son
	 * iguales.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(contrasena, other.contrasena) && Objects.equals(correo, other.correo);
	}

	/**
	 * Este es un método que compara dos objetos User basándose en su dirección de
	 * correo electrónico. Se utiliza para ordenar una lista de objetos User por su
	 * dirección de correo electrónico.
	 */
	public int compareTo(User x) {

		return this.correo.compareTo(x.correo);
	}

}
