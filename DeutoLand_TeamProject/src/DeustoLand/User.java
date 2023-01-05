package DeustoLand;

import java.util.Objects;

public class User {

	//Atributos de la clase
	private int cod;
	private String nombre;
	private String apellido;
	private String dni;
	private String correo;
	private String contrasena;

	/**
	 * Crea un user con los datos indicados.
	 * @param cod codigo del user
	 * @param nombre nombre del user
	 * @param apellido apellido del user
	 * @param dni dni del user
	 * @param correo correo del user
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
	 * @return el codigo del user
	 */
	public int getCod() {
		return cod;
	}
	
	public void setCod(int cod) {
		this.cod = cod;
	}

	/**
	 * Obtiene el nombre del user
	 * @return el nombre del user
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el apellido del user
	 * @return el apellido del user
	 */
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Obtiene el dni del user
	 * @return el dni del user
	 */
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Obtiene el correo del user
	 * @return el correo del user
	 */
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Obtiene la contraseña del user
	 * @return
	 */
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "User [cod=" + cod + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", correo="
				+ correo + ", contrasena=" + contrasena + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contrasena, correo);
	}

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

}
