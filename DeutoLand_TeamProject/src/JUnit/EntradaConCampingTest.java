package JUnit;

import static org.junit.Assert.*;


import org.junit.Test;

import DeustoLand.Cliente;
import DeustoLand.EntradaConCamping;
import DeustoLand.Festival;
import DeustoLand.TipoEntrada;
import DeustoLand.User;

public class EntradaConCampingTest {

	
	@Test
	public void test() {
		
		EntradaConCamping ec = new EntradaConCamping(new Cliente("Ramon", "Foronda", "3234570B", "ramonperales@gmail.com", "4567","Avenida Murrieta 15A", 18, 48980 ), 200, new Festival(02, "Coachella", "25-04-2023", "Colorado, California, EEUU",
				"Coachella es un gran festival de música que se lleva a cabo durante tres días en la última semana del mes de abril en California. Es uno de los festivales de música más grandes, famosos y rentables de Estados Unidos y del mundo. Para más información consulte la página oficial del sitio: https://www.coachella.com/",
				300.00, "coachella.png"), TipoEntrada.NORMAL, 30, 150);
		
		
		assertEquals(ec.getCliente().getDni(), "3234570B" );
		assertEquals(ec.getNumeroEntrada(), 200);
		assertEquals(ec.getFestival().getCodigoF(), 02 );
		assertEquals(ec.getTipoE(), "NORMAL");
		assertTrue(ec.getSuplementoCamping() == 30);
		assertEquals(ec.getParcela(), 150);
	}
	

}
