package JUnit;

import static org.junit.Assert.*;

import java.sql.Time;

import org.junit.Before;
import org.junit.Test;

import DeustoLand.Artista;
import DeustoLand.Concierto;
import DeustoLand.Festival;
import DeustoLand.TipoGenero;

public class ConciertoTest {

	private Artista a;

	private Concierto c;

	@Before
	public void setUp() throws Exception {

		a = new Artista(01, "Aitana", TipoGenero.POP);

		Time thora = new Time(19, 0, 0);

		long hora = thora.getTime();

		c = new Concierto(13, a, hora, 1.00, new Festival(04, "Mad Cool", "04-07-2023", "Madrid, España",
				"Mad Cool es un festival de música que se realiza en Madrid desde el año 2016. El arte, la moda, la gastronomía y el turismo se unen eclécticamente en este festival. Para más información consulte la página oficial del sitio: https://madcoolfestival.es/",
				120.00, "madcool.jpg"));
	}

	@Test
	public void testConcierto() {

		assertNotNull(c);
	}

	@Test
	public void testGetCodigoC() {
		assertEquals(13, c.getCodigoC());
	}

	@Test
	public void testSetCodigoC() {
		c.setCodigoC(21);
		assertEquals(21, c.getCodigoC());
	}

	@Test
	public void testGetArtista() {
		assertEquals(a, c.getArtista());
	}

	@Test
	public void testSetArtista() {
		c.setArtista(null);
		assertNull(c.getArtista());
	}

	@Test
	public void testGetHora() {

		Time thora = new Time(19, 0, 0);
		assertEquals(thora.getTime(), c.getHora());
	}

	@Test
	public void testSetHora() {
		c.setHora(0);
		assertEquals(0, c.getHora());

	}

	@Test
	public void testGetDuracion() {
		assertTrue(c.getDuracion() == 1.00);
	}

	@Test
	public void testSetDuracion() {
		c.setDuracion(2.00);
		assertTrue(2.00 == c.getDuracion());
	}

	@Test
	public void testGetFestival() {
		assertEquals(04, c.getFestival().getCodigoF());
	}

	@Test
	public void testSetFestival() {
		Festival f2 = new Festival(0, null, null, null, null, 0, null);
		c.setFestival(f2);
		assertEquals(f2, c.getFestival());
	}

}
