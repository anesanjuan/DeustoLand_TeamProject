package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DeustoLand.BaseDeDatos;
import DeustoLand.Gestor;
import DeustoLand.User;
import Excepciones.ClienteRepetidoException;

public class GestorTest {
	
	private Gestor gestor;
	private ArrayList<User> usuarios;

	@Before
	public void setUp() throws Exception {
		BaseDeDatos.abrirConexion("BaseDatos.db", false);
		gestor = new Gestor();
		usuarios = BaseDeDatos.getUsers();
	}

	@Test
	public void testGestor() {
		assertNotNull(gestor);
		assertNotNull(usuarios);

	}

	@Test
	public void comprobarUsuarioTest() {

		assertEquals(1, gestor.comprobarUsuario("admin", "admin"));

	}

	@Test
	public void insertarClienteTest() {
		try {

			gestor.insertarCliente("Mar", "Mugica", "45485645E", "mar@gmail.com", "mar123", null, 0, 0);

		} catch (ClienteRepetidoException e) {

			fail("Aqui no deberia entrar!");
		}

		try {

			gestor.insertarCliente("Mar", "Mugica", "45485645E", "mar@gmail.com", "mar123", null, 0, 0);

			fail("Aqui no deberia llegar!");
		} catch (ClienteRepetidoException e) {

		}

	}

}
