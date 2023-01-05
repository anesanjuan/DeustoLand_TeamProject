package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DeustoLand.Artista;
import DeustoLand.TipoGenero;


public class ArtistaTest {	
	
	private Artista art;
	
	@Before
	public void setUp() throws Exception {
		 art = new Artista(02, "Mora", TipoGenero.URBANOLATINO);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testArtista() {
		assertNotNull(art);
	}
	@Test
	public void getCodigoA() {
		assertEquals(art.getCodigoA(), 02);
	}
	@Test
	public void setCodigoA() {
		fail("Not yet implemented");
	}
	@Test
	public void getNombre() {
		assertEquals(art.getNombre(), "Mora");
	}
	@Test
	public void setNombre() {
		fail("Not yet implemented");
	}
	@Test
	public void getTipogenero() {
		assertEquals(art.getTipogenero(), TipoGenero.URBANOLATINO);
	}
	@Test
	public void setTipogenero() {
		fail("Not yet implemented");
	}

}
