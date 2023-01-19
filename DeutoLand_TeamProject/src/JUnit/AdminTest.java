package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DeustoLand.Admin;

public class AdminTest {

	private Admin a;

	@Before
	public void setUp() throws Exception {

		a = new Admin("Juan", "Perez", "23423762A", "juanperez@gmail.com", "juanperez23", "27/10/2022");

	}

	@Test
	public void testAdmin() {
		assertNotNull(a);
	}

	@Test
	public void getFechaUltimaMod() {
		assertEquals("27/10/2022", a.getFechaUltimaMod());
	}

	@Test
	public void setFechaUltimaMod() {
		a.setFechaUltimaMod("19/01/2023");
		assertEquals("19/01/2023", a.getFechaUltimaMod());
	}

}
