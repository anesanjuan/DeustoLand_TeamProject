package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DeustoLand.Cliente;

public class ClienteTest {

	private Cliente c;

	@Before
	public void setUp() throws Exception {
		c = new Cliente("Cristina", "Lopez", "4567881A", "crislopez@gmail.com", "5678", "Koldo Mitxelena, 9", 24,
				37879);

	}

	@Test
	public void testCliente() {
		assertNotNull(c);
	}

	@Test
	public void getDireccion() {
		assertEquals("Koldo Mitxelena, 9", c.getDireccion());
	}

	@Test
	public void setDireccion() {

		c.setDireccion("Vitoria");
		assertEquals("Vitoria", c.getDireccion());

	}

	@Test
	public void getEdad() {
		assertEquals(24, c.getEdad());
	}

	@Test
	public void setEdad() {
		c.setEdad(25);
		assertEquals(25, c.getEdad());
	}

	@Test
	public void getCodigoP() {
		assertEquals(37879, c.getCodigoP());
	}

	@Test
	public void setCodigoP() {
		c.setCodigoP(387870);
		assertEquals(387870, c.getCodigoP());
	}

}
