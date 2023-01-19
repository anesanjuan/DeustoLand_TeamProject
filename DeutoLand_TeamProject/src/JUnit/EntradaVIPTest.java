package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DeustoLand.Cliente;
import DeustoLand.EntradaVIP;
import DeustoLand.Festival;
import DeustoLand.TipoEntrada;

public class EntradaVIPTest {

	private EntradaVIP ev;

	@Before
	public void setUp() throws Exception {
		ev = new EntradaVIP(100,
				new Cliente("Cristina", "Lopez", "4567881A", "crislopez@gmail.com", "5678", "Miguel de cervantes 10B",
						20, 46573),
				new Festival(01, "Tomorrowland", "21-07-2023", "Boom, Bélgica",
						"Tomorrowland es un festival de música electrónica de baile en el que lo pasarás en grande y difrutaras de 3 días increíbles con tus amigos y lleno de música. El festival tiene una duración de 3 días y cada día empezará sobre las 18:00 horas. Para más información consulte la página oficial del sitio: https://www.tomorrowland.com/",
						150.00, "tomorrowland.png"),
				TipoEntrada.VIP, 50, 1);

	}

	@Test
	public void test() {
		assertNotNull(ev);
	}

	@Test
	public void getSuplementoVIP() {
		assertTrue(ev.getSuplementoVIP() == 50);
	}

	@Test
	public void setSuplementoVIP() {
		ev.setSuplementoVIP(60.00);
		assertTrue(60.00 == ev.getSuplementoVIP());
	}

	@Test
	public void getNumZonaVIP() {
		assertEquals(1, ev.getNumZonaVIP());
	}

	@Test
	public void setNumZonaVIP() {
		ev.setNumZonaVIP(2);
		assertEquals(2, ev.getNumZonaVIP());
	}

}
