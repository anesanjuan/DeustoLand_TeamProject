package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DeustoLand.Tarjeta;

public class TarjetaTest {

	private Tarjeta t;

	@Before
	public void setUp() throws Exception {

		t = new Tarjeta(12345, "19/01/2023", 011);

	}
	
	@Test
	public void getNumTarjetaTest() {
		assertEquals(12345, t.getNumTarjeta());
	}
	
	@Test
	public void setNumTarjetaTest() {
		t.setNumTarjeta(54321);
		assertEquals(54321, t.getNumTarjeta());
	}
	
	@Test
	public void getFechaCadTest() {
		assertEquals("19/01/2023", t.getFechaCad());
	}
	
	@Test
	public void setFechaCadTest() {
		t.setFechaCad("21/09/2030");
		assertEquals("21/09/2030", t.getFechaCad());
	}
	
	
	@Test
	public void getCvvTest() {
		assertEquals(011, t.getCvv());
	}
	
	@Test
	public void setCvvTest() {
		t.setCvc(231);
		assertEquals(231, t.getCvv());
	}
	
	

	

}
