package JUnit;

import static org.junit.Assert.*;


import org.junit.Test;

import DeustoLand.Cliente;
import DeustoLand.EntradaVIP;
import DeustoLand.Festival;

public class EntradaVIPTest {


	@Test
	public void test() {
		
		
		EntradaVIP ev = new EntradaVIP(new Cliente("Cristina", "Lopez", "4567881A", "crislopez@gmail.com", "5678", "Koldo Mitxelena, 9", 24, 37879), 100, new Festival(01, "Tomorrowland", "21-07-2023", "Boom, Bélgica",
				"Tomorrowland es un festival de música electrónica de baile en el que lo pasarás en grande y difrutaras de 3 días increíbles con tus amigos y lleno de música. El festival tiene una duración de 3 días y cada día empezará sobre las 18:00 horas. Para más información consulte la página oficial del sitio: https://www.tomorrowland.com/",
				150.00, "tomorrowland.png"), 50, 1);
		
		assertEquals(ev.getCliente().getDni(), "4567881A" );
		assertEquals(ev.getNumeroEntrada(), 100);
		assertEquals(ev.getFestival().getCodigoF(), 01 );
		assertEquals(ev.getSuplementoVIP(), 50);
		assertEquals(ev.getNumZonaVIP(), 1);
	}

}
