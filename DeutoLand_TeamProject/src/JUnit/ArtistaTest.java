package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import DeustoLand.Artista;
import DeustoLand.TipoGenero;


public class ArtistaTest {	
	
	@Test
	public void test() {
		Artista art = new Artista(02, "Mora", TipoGenero.URBANOLATINO);

		
		assertEquals(art.getCodigoA(), 02);
		assertEquals(art.getNombre(), "Mora");
		assertEquals(art.getTipogenero(), TipoGenero.URBANOLATINO );

	}

}
