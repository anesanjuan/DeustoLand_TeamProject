package DeustoLand;

import java.util.ArrayList;

import DeustoLand.Artista;
import DeustoLand.User;
import DeustoLand.Concierto;
import Excepciones.ClienteRepetidoException;

public class Gestor {

	private ArrayList<User> aUsers = new ArrayList<>();

	public void CargarClientes() {

	}

	public void GuardarClientes() {
	}

	public Gestor() {

		//recuperarClientes();

	}

	public void comprobarFestival(String nombre, double fecha, ArrayList<Concierto> conciertos,
			ArrayList<Artista> Artistas, double precio) {

	}

	public void insertarCliente(String nombre, String apellido, String dni, String correo, String contrasena)
			throws ClienteRepetidoException {
		User c = new Cliente(nombre, apellido, dni, correo, contrasena);
		if (aUsers.contains(c) == false) {
			aUsers.add(c);
		} else {
			throw new ClienteRepetidoException("Este cliente ya existe");
		}
	}

	private void insertarClientes() {
		User c1 = new Cliente("Maria", "Perales ", "343534546W", "maria@gmail.com", "1234");
		aUsers.add(c1);
	}

	// al iniciar sesion
	public int comprobarUsuario(String correo, String contrasena) {
		for (User c : aUsers) {
			
			if ( c instanceof Cliente)
			{
				Cliente cli = (Cliente)c;
				if (cli.getCorreo().equals(correo) && c.getContrasena().equals(contrasena)) {
					return 0;
				}
				else
				{
					return -1;
				}
			}
			else
			{
				Admin cli = (Admin)c;
				if (cli.getNombre().equals(correo) && c.getContrasena().equals(contrasena)) {
					return 1;
				}
				else
				{
					return -1;
				}			
			}
		}
		
		return -1;
	}
}
