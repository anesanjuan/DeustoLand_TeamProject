package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DeustoLand.Cliente;
import DeustoLand.EntradaConCamping;
import DeustoLand.Festival;
import DeustoLand.TipoEntrada;
import DeustoLand.User;

public class EntradaConCampingTest {

	//tengo q añadir lo de entrada normal??
	
	private EntradaConCamping ec;
	
	@Before
	public void setUp() throws Exception {
		ec = new EntradaConCamping(01, new Cliente( 200, "Ramon", "Foronda", "3234570B", "ramonperales@gmail.com", "4567","Avenida Murrieta 15A", 18, 48980 ), new Festival(02, "Coachella", "25-04-2023", "Colorado, California, EEUU",
				"Coachella es un gran festival de música que se lleva a cabo durante tres días en la última semana del mes de abril en California. Es uno de los festivales de música más grandes, famosos y rentables de Estados Unidos y del mundo. Para más información consulte la página oficial del sitio: https://www.coachella.com/",
				300.00, "coachella.png"), TipoEntrada.NORMAL, 30, 150);
	
	}
		
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testEntradaConCamping() {
		assertNotNull(ec);
	}
	
	@Test
	public void getSuplementoCamping() {
		assertTrue(ec.getSuplementoCamping() == 30 );
	}
	@Test
	public void setSuplementoCamping() {
		fail("Not yet implemented");
	}
	@Test
	public void getParcela() {
		assertTrue(ec.getParcela() == 150 );
	}
	@Test
	public void setParcela() {
		fail("Not yet implemented");
	}

}
