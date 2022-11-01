package DeustoLand;

import java.util.ArrayList;

import DeustoLand.Artista;
import DeustoLand.Cliente;
import DeustoLand.Concierto;
import Excepciones.ClienteRepetidoException;


public class GestorLN {
	
	private GestorFichero gficheros = new GestorFichero();

	private ArrayList<Cliente> aClientes = new ArrayList<>();
	
	public void CargarClientes() {
		
		aClientes = gficheros.cargarClientes();		
	}

	public void GuardarClientes() {
		gficheros.guardarClientes(aClientes);
	}

	public GestorLN() {

		//datos iniciales
		//insertarClientes();
		//GuardarClientes();
		
		//#################################
		//CargarClientes();
	}

	public void comprobarFestival(String nombre, double fecha, ArrayList<Concierto> conciertos, ArrayList<Artista> Artistas,  double precio) {
		
		
	}
 	
	public void insertarCliente(String nombre, String apellido, String dni, String correo, String contrasena) throws ClienteRepetidoException {
		Cliente c = new Cliente(nombre, apellido, dni, correo, 0, contrasena, contrasena);
		if (aClientes.contains(c) == false) {
			aClientes.add(c);
		} else {
			throw new ClienteRepetidoException("Este cliente ya existe");
		}
	}

	private void insertarClientes() {
		Cliente c1 = new Cliente("Maria", "Perales ", "343534546W", "maria@gmail.com", 0, "1111", null);
		aClientes.add(c1);
		
		
	}

	//al iniciar sesion
	public boolean comprobarUsuario(String correo, String contrasena) {
		for (Cliente c : aClientes) {
			if (c.getCorreo().equals(correo) && c.getContrasena().equals(contrasena)) {
				return true;
			}
		}
		return false;
	}
}
