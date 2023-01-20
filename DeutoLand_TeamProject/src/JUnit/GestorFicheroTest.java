package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import DeustoLand.GestorFichero;
import DeustoLand.Tarjeta;

public class GestorFicheroTest {

	private ArrayList<Tarjeta> ts;

	@Test
	public void cargarTarjetasCreditoTest() {
		ts = GestorFichero.cargarTarjetasCredito();
		assertNotNull(ts);
	}

	@Test
	public void comprobarTarjetaTest() {
		assertEquals(true, GestorFichero.comprobarTarjeta("5540500001000004", "180"));
	}

}
