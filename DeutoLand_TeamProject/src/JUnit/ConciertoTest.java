package JUnit;

import static org.junit.Assert.*;


import org.junit.Test;

import DeustoLand.Artista;
import DeustoLand.BaseDeDatos;
import DeustoLand.Concierto;
import DeustoLand.Festival;
import DeustoLand.TipoGenero;

public class ConciertoTest {

	
	@Test
	public void test() {
		
		
		//Concierto c = new Concierto(12, BaseDeDatos.getArtistas().get(0), 2022-03-12, 1.00, BaseDeDatos.getFestivales().get(0));
		Concierto c = new Concierto(13, new Artista(01, "Aitana", TipoGenero.POP),2022-03-12, 1.00, new Festival(04, "Mad Cool", "04-07-2023", "Madrid, España",
				"Mad Cool es un festival de música que se realiza en Madrid desde el año 2016. El arte, la moda, la gastronomía y el turismo se unen eclécticamente en este festival. Para más información consulte la página oficial del sitio: https://madcoolfestival.es/",
				120.00, "madcool.jpg") );

		assertEquals(c.getCodigoC(),13 );
		assertEquals(c.getArtista().getCodigoA(), 01 );
		assertEquals(c.getHora(), 2022-03-12);
		assertTrue(c.getDuracion() == 1.00 );
		assertEquals(c.getFestival().getCodigoF(),04 );
		
		
		
	}

}
