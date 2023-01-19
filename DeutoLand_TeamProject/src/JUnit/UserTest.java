package JUnit;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import DeustoLand.User;

public class UserTest {

	
	

	
	private User u;
	private User u2;
	
	
	@Before
	public void setUp() throws Exception {
		u = new User(01,"Alex", "Navarro", "29096527M", "alexnavarro@gmail.com", "alex231");
		u2 = new User(02,"Lucia", "Gomez", "29093727E", "lucia@gmail.com", "lu99");

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
	public void setCod( ) {
		u.setCod(544);
		assertEquals(544, u.getCod());
	}
	@Test
	public void getNombre() {
		assertEquals(u.getNombre(), "Alex");
	}
	@Test
	public void setNombre( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getApellido() {
		assertEquals(u.getApellido(), "Navarro");
	}
	@Test
	public void setApellido( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getDni() {
		assertEquals(u.getDni(), "29096527M" );
	}
	@Test
	public void setDni( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getCorreo() {
		assertEquals(u.getCorreo(), "alexnavarro@gmail.com");
	}
	@Test
	public void setCorreo( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getContrasena() {
		assertEquals(u.getContrasena(), "alex231");
	}
	@Test
	public void setContrasena( ) {
		fail("Not yet implemented");
	}
	
	@Test
	public void compareTo() {
		assertTrue(u.compareTo(u2)<0);
	}
}
