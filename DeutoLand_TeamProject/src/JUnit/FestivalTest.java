package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import DeustoLand.Artista;
import DeustoLand.Concierto;
import DeustoLand.Festival;
import DeustoLand.TipoGenero;

public class FestivalTest {

	private Festival f;
	private Festival f2;

	private ArrayList<Concierto> listaConciertos = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		f = new Festival(01, "Tomorrowland", "21-07-2023", "Boom, Bélgica",
				"Tomorrowland es un festival de música electrónica de baile en el que lo pasarás en grande y difrutaras de 3 días increíbles con tus amigos y lleno de música. El festival tiene una duración de 3 días y cada día empezará sobre las 18:00 horas. Para más información consulte la página oficial del sitio: https://www.tomorrowland.com/",
				listaConciertos, 150.00, "tomorrowland.png");
		f2 = new Festival(0, null, null, null, null, listaConciertos, 0, null);
	}

	@Test
	public void testFestival() {
		assertNotNull(f);
	}

	@Test
	public void getCodigoF() {
		assertEquals(01, f.getCodigoF());
	}

	@Test
	public void setCodigoF() {
		f.setCodigoF(344);
		assertEquals(344, f.getCodigoF());
	}

	@Test
	public void getNombre() {
		assertEquals("Tomorrowland", f.getCodigoF());
	}

	@Test
	public void setNombre() {
		f.setNombre("Holika");
		assertEquals("Holika", f.getNombre());
	}

	@Test
	public void getFecha() {
		assertEquals("21-07-2023", f.getFecha());
	}

	@Test
	public void setFecha() {
		f.setFecha("19-01-2013");
		assertEquals("19-01-2013", f.getFecha());
	}

	@Test
	public void getLugar() {
		assertEquals("Boom, Bélgica", f.getLugar());
	}

	@Test
	public void setLugar() {
		f.setLugar("España");
		assertEquals("España", f.getLugar());
	}

	@Test
	public void getDescripcion() {
		assertEquals(
				"Tomorrowland es un festival de música electrónica de baile en el que lo pasarás en grande y difrutaras de 3 días increíbles con tus amigos y lleno de música. El festival tiene una duración de 3 días y cada día empezará sobre las 18:00 horas. Para más información consulte la página oficial del sitio: https://www.tomorrowland.com/",
				f.getDescripcion());
	}

	@Test
	public void setDescripcion() {
		f.setDescripcion("Festival de pop-rock");
		assertEquals("Festival de pop-rock", f.getDescripcion());
	}

	@Test
	public void getListaConciertos() {
		assertEquals(listaConciertos, f.getListaConciertos());
	}

	@Test
	public void setListaConciertos() {
		ArrayList<Concierto> listaConciertos2 = new ArrayList<>();
		Concierto c = new Concierto(13, new Artista(01, "Aitana", TipoGenero.POP), 2022 - 03 - 12, 1.00, new Festival(04, "Mad Cool", "04-07-2023", "Madrid, España",
				"Mad Cool es un festival de música que se realiza en Madrid desde el año 2016. El arte, la moda, la gastronomía y el turismo se unen eclécticamente en este festival. Para más información consulte la página oficial del sitio: https://madcoolfestival.es/",
				120.00, "madcool.jpg"));
		listaConciertos2.add(c);
		f.setListaConciertos(listaConciertos2);
		assertEquals(listaConciertos2, f.getListaConciertos());
	}

	@Test
	public void getPrecio() {
		assertTrue(f.getPrecio() == 150);
	}

	@Test
	public void setPrecio() {
		f.setPrecio(200);
		assertTrue(200.0 == f.getPrecio());
	}

	@Test
	public void getFoto() {
		assertEquals(f.getFoto(), "Tomorrowland.png");
	}

	@Test
	public void setFoto() {
		f.setFoto("Holika.jpg");
		assertEquals("Holika.jpg", f.getFoto());
	}
	
	@Test
	public void compareTo() {
		//assertTrue((f*100 - f2*100)<0);
	}

}
