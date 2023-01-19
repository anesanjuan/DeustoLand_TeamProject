package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DeustoLand.Cliente;

public class ClienteTest {

	//tengo q poner algo de user???
	
	private Cliente c;
	
	@Before
	public void setUp() throws Exception {
		c = new Cliente("Cristina", "Lopez", "4567881A", "crislopez@gmail.com", "5678", "Koldo Mitxelena, 9", 24, 37879);

	}
	
	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testCliente() {
		assertNotNull(c);
	}
	@Test
	public void getDireccion() {
		assertEquals(c.getDireccion(),"Koldo Mitxelena, 9" );
	}
	@Test
	public void setDireccion( ) {
		
		
		fail("Not yet implementes");
		
		
	}
	@Test
	public void getEdad() {
		assertEquals(c.getEdad(), 24);
	}
	@Test
	public void setEdad() {
		fail("Not yet implementes");
	}
	@Test
	public void getCodigoP() {
		assertEquals(c.getCodigoP(), 37879);
	}
	@Test
	public void setCodigoP() {
		fail("Not yet implementes");
	}

}
