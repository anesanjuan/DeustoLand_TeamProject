package JUnit;

import static org.junit.Assert.*;

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
	
	@Test
	public void testArtista() {
		assertNotNull(art);
	}
	@Test
	public void getCodigoA() {
		assertEquals(02, art.getCodigoA());
	}
	@Test
	public void setCodigoA() {
		art.setCodigoA(03);
		assertEquals(03, art.getCodigoA());
	}
	@Test
	public void getNombre() {
		assertEquals("Mora", art.getNombre());
	}
	@Test
	public void setNombre() {
		art.setNombre("Bad Bunny");
		assertEquals("Bad Bunny", art.getNombre());
	}
	@Test
	public void getTipogenero() {
		assertEquals( TipoGenero.URBANOLATINO, art.getTipogenero());
	}
	@Test
	public void setTipogenero() {
		TipoGenero tipoG = TipoGenero.REGGAETON;
		art.setTipogenero(tipoG);
		assertEquals(tipoG, art.getTipogenero());
	}

}
