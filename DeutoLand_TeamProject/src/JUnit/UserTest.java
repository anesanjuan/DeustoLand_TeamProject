package JUnit;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import DeustoLand.User;

public class UserTest {

	//el hashcode, equals???
	
	private User u;
	
	
	@Before
	public void setUp() throws Exception {
		u = new User(01,"Alex", "Navarro", "29096527M", "alexnavarro@gmail.com", "alex231");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUser() {
		assertNotNull(u);
	}
	@Test
	public void getCod() {
		assertEquals(u.getCod(), 01);
	}
	@Test
	public void setCod(int cod) {
		fail("Not yet implemented");
	}
	@Test
	public void getNombre() {
		assertEquals(u.getNombre(), "Alex");
	}
	@Test
	public void setNombre(String nombre) {
		fail("Not yet implemented");
	}
	@Test
	public void getApellido() {
		assertEquals(u.getApellido(), "Navarro");
	}
	@Test
	public void setApellido(String apellido) {
		fail("Not yet implemented");
	}
	@Test
	public void getDni() {
		assertEquals(u.getDni(), "29096527M" );
	}
	@Test
	public void setDni(String dni) {
		fail("Not yet implemented");
	}
	@Test
	public void getCorreo() {
		assertEquals(u.getCorreo(), "alexnavarro@gmail.com");
	}
	@Test
	public void setCorreo(String correo) {
		fail("Not yet implemented");
	}
	@Test
	public void getContrasena() {
		assertEquals(u.getContrasena(), "alex231");
	}
	@Test
	public void setContrasena(String contrasena) {
		fail("Not yet implemented");
	}
}
