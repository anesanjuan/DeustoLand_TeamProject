package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DeustoLand.User;

public class UserTest {

	private User u;
	private User u2;

	@Before
	public void setUp() throws Exception {
		u = new User(01, "Alex", "Navarro", "29096527M", "alexnavarro@gmail.com", "alex231");
		u2 = new User(02, "Lucia", "Gomez", "29093727E", "lucia@gmail.com", "lu99");

	}

	@Test
	public void testUser() {
		assertNotNull(u);
	}

	@Test
	public void getCod() {
		assertEquals(01, u.getCod());
	}

	@Test
	public void setCod() {
		u.setCod(544);
		assertEquals(544, u.getCod());
	}

	@Test
	public void getNombre() {
		assertEquals("Alex", u.getNombre());
	}

	@Test
	public void setNombre() {
		u.setNombre("Maria");
		assertEquals("Maria", u.getNombre());
	}

	@Test
	public void getApellido() {
		assertEquals( "Navarro", u.getApellido());
	}

	@Test
	public void setApellido() {
		u.setApellido("Rodriguez");
		assertEquals("Rodriguez", u.getApellido());
	}

	@Test
	public void getDni() {
		assertEquals("29096527M", u.getDni());
	}

	@Test
	public void setDni() {
		u.setDni("72866731W");
		assertEquals("72866731W", u.getDni());
	}

	@Test
	public void getCorreo() {
		assertEquals( "alexnavarro@gmail.com", u.getCorreo());
	}

	@Test
	public void setCorreo() {
		u.setCorreo("alex@gmail.com");
		assertEquals("alex@gmail.com", u.getCorreo());
	}

	@Test
	public void getContrasena() {
		assertEquals("alex231", u.getContrasena());
	}

	@Test
	public void setContrasena() {
		u.setContrasena("alex345");
		assertEquals("alex345", u.getContrasena());
	}

	@Test
	public void compareTo() {
		assertTrue(u.compareTo(u2) < 0);
	}
}
