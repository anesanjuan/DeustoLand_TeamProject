package DeustoLand;

import java.util.ArrayList;

import Excepciones.ClienteRepetidoException;


public class GestorLN {
	
	
	private ArrayList<Cliente> aClientes = new ArrayList<>();

	public GestorLN() {

		//datos iniciales
		//insertarClientes();
		//GuardarClientes();
		
		//#################################
		//CargarClientes();
	}

	public void insertarCliente(String nombre, String apellido, String dni, String correo, TipoCliente tipocliente, String contraseña) throws ClienteRepetidoException {
		Cliente c = new Cliente(nombre, apellido, dni, correo, tipocliente, contraseña);
		if (aClientes.contains(c) == false) {
			aClientes.add(c);
		} else {
			throw new ClienteRepetidoException("Este cliente ya existe");
		}
	}

	private void insertarClientes() {
		Cliente c1 = new Cliente("Maria", "Perales ", "343534546W", "maria@gmail.com", TipoCliente.VIP, "1111");
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
