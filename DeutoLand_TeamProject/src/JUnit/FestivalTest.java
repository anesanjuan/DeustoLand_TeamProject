package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DeustoLand.Festival;


//ESTE ME DA MAL


public class FestivalTest {

	@Test
	public void test() {
		Festival f = new Festival(01, "Tomorrowland", "21-07-2023", "Boom, Bélgica",
				"Tomorrowland es un festival de música electrónica de baile en el que lo pasarás en grande y difrutaras de 3 días increíbles con tus amigos y lleno de música. El festival tiene una duración de 3 días y cada día empezará sobre las 18:00 horas. Para más información consulte la página oficial del sitio: https://www.tomorrowland.com/",
				150.00, "tomorrowland.png");
		
		assertEquals(f.getCodigoF(), 01);
		assertEquals(f.getNombre(), "Tomorrowland");
		assertEquals(f.getFecha(),  "21-07-2023");
		assertEquals(f.getLugar(), "Boom, Bélgica");
		assertEquals(f.getDescripcion(),"Tomorrowland es un festival de música electrónica de baile en el que lo pasarás en grande y difrutaras de 3 días increíbles con tus amigos y lleno de música. El festival tiene una duración de 3 días y cada día empezará sobre las 18:00 horas. Para más información consulte la página oficial del sitio: https://www.tomorrowland.com/");
		//este lo he tenido que poner con assertTrue porque con assertEquals me daba error al ser doubles
		assertTrue(f.getPrecio() == 150.00);
		assertEquals(f.getFoto(), "tomorrowland.png");

	
	}

}
