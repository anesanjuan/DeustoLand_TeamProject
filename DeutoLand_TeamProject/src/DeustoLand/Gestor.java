package DeustoLand;

import java.util.ArrayList;

import DeustoLand.Artista;
import DeustoLand.User;
import DeustoLand.Concierto;
import Excepciones.ClienteRepetidoException;

public class Gestor {

	private ArrayList<User> aUsers = null;

	public void CargarClientes() {

	}

	public void GuardarClientes() {
	}

	public Gestor() {

		aUsers = BaseDeDatos.getUsers();
	}

	public void comprobarFestival(String nombre, double fecha, ArrayList<Concierto> conciertos,
			ArrayList<Artista> Artistas, double precio) {

	}

	// VENTANA INICIO SESION
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

	public void insertarCliente(String nombre, String apellido, String dni, String email, String contrasena,
			String direccion, int edad, int codigoPostal) throws ClienteRepetidoException {
		BaseDeDatos.insertarUsuario(nombre, apellido, dni, email, contrasena, direccion, edad, codigoPostal);
	}

}
