package JUnit;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DeustoLand.BaseDeDatos;

public class BDTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAbrirConexion() {
		assertTrue(BaseDeDatos.abrirConexion("BaseDatos.db", false));
	}
	//@Test
	public void testCerrarConexion() {
		
	}
	
	//@Test
	public void testinsertarFestival() {
		
	}
	
	//@Test
	public void testinsertarArtistas() {
		
	}

	//@Test
	public void testinsertarConcierto() {
		
	}
	
	//@Test
	public void testinsertarCliente() {
		
	}
}
