package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DeustoLand.Artista;
import DeustoLand.Concierto;
import DeustoLand.Festival;
import DeustoLand.TipoGenero;

public class ConciertoTestV2 {

	private Concierto c ; 
	
	@Before
	public void setUp() throws Exception {

		c = new Concierto(13, new Artista(01, "Aitana", TipoGenero.POP),2022-03-12, 1.00, new Festival(04, "Mad Cool", "04-07-2023", "Madrid, España",
				"Mad Cool es un festival de música que se realiza en Madrid desde el año 2016. El arte, la moda, la gastronomía y el turismo se unen eclécticamente en este festival. Para más información consulte la página oficial del sitio: https://madcoolfestival.es/",
				120.00, "madcool.jpg") );
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConcierto() {

		assertNotNull( c );
	}

	@Test
	public void testGetCodigoC() {
		assertEquals(c.getCodigoC(),13 );
	}

	@Test
	public void testSetCodigoC() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArtista() {
		
		assertEquals("Aitana", c.getArtista() );
	}

	@Test
	public void testSetArtista() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHora() {
		assertEquals(c.getHora(), 2022-03-12);
	}

	@Test
	public void testSetHora() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDuracion() {
		assertTrue(c.getDuracion() == 1.00 );
	}

	@Test
	public void testSetDuracion() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFestival() {
		assertEquals(c.getFestival().getCodigoF(),04 );
	}

	@Test
	public void testSetFestival() {
		fail("Not yet implemented");
	}


}
