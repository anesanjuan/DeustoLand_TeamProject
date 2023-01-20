package DeustoLand;

import java.util.ArrayList;

import Excepciones.ClienteRepetidoException;

public class Gestor {

	// private Map<Integer,Integer> ventas = new HashMap<>();
	private ArrayList<User> aUsers = null;

	/**
	 * Crea una nueva instancia de la clase. El constructor inicializa la variable
	 * de instancia "aUsers" llamando al método "getUsers()" de la clase
	 * "BaseDeDatos". La variable "aUsers" es una ArrayList que almacena información
	 * de usuario, y este constructor recupera esa información de la base de datos.
	 */
	public Gestor() {

		aUsers = BaseDeDatos.getUsers();
	}

	// VENTANA INICIO SESION
	/**
	 * Este método toma dos parámetros como entrada, una cadena "correo" y una
	 * cadena "contrasena". El método recorre todos los elementos en la colección
	 * "aUsers" y verifica si alguno de ellos tiene el mismo "correo" y "contrasena"
	 * que los parámetros pasados en la llamada del método. Si se encuentra un
	 * elemento que coincida con el correo electrónico y la contraseña, el método
	 * verifica si el elemento es una instancia de la clase "Cliente" o "Admin", si
	 * es una clase "Cliente" devuelve 0, y si es una clase "Admin" devuelve 1. Si
	 * no se encuentra ninguna coincidencia, el método devuelve -1.
	 * 
	 * @param correo     correo del usuario
	 * @param contrasena contraseña del usuario
	 * @return
	 */
	public int comprobarUsuario(String correo, String contrasena) {

		for (User c : aUsers) {

			if (c instanceof Cliente) {
				Cliente cli = (Cliente) c;
				if (cli.getCorreo().equals(correo) && c.getContrasena().equals(contrasena)) {
					return 0;
				}
			} else {
				Admin cli = (Admin) c;
				if (cli.getCorreo().equals(correo) && c.getContrasena().equals(contrasena)) {
					return 1;
				}
			}
		}

		return -1;

	}

	// VENTANA REGISTRO
	/**
	 * Este método primero llama al método "getCliente" de la clase "BaseDeDatos",
	 * pasando "email" y "contrasena" como parámetros. Luego, el método verifica si
	 * el valor devuelto es nulo o no. Si es nulo, el método llama al método
	 * "insertarUsuario" de la clase "BaseDeDatos", pasando todos los parámetros
	 * pasados a este método. Si el valor devuelto no es nulo, el método lanza una
	 * "ClienteRepetidoException" con el mensaje "Cliente repetido". Este método es
	 * probablemente utilizado para insertar un nuevo cliente en la base de datos,
	 * verificando primero si el cliente ya existe en la base de datos por el correo
	 * electrónico y la contraseña.
	 * 
	 * @param nombre       nombre del usuario
	 * @param apellido     apellido del usuario
	 * @param dni          dni del usuario
	 * @param email        email del usuario
	 * @param contrasena   contraseña del usuario
	 * @param direccion    direccion del usuario
	 * @param edad         edad del usuario
	 * @param codigoPostal codigo postal del usuario
	 * @throws ClienteRepetidoException excepcion si el usuario introducio ya existe
	 *                                  en la base de datos
	 */
	public void insertarCliente(String nombre, String apellido, String dni, String email, String contrasena,
			String direccion, int edad, int codigoPostal) throws ClienteRepetidoException {

		User u = BaseDeDatos.getCliente(email, contrasena);

		if (u == null) {
			BaseDeDatos.insertarUsuario(nombre, apellido, dni, email, contrasena, direccion, edad, codigoPostal);
		} else {
			throw new ClienteRepetidoException("Cliente repetido");
		}
	}

}
