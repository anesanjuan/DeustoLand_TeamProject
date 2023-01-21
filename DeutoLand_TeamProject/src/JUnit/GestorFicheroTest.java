package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import DeustoLand.GestorCsv;
import DeustoLand.Tarjeta;

public class GestorFicheroTest {

	private ArrayList<Tarjeta> ts;

	@Test
	public void cargarTarjetasCreditoTest() {
		ts = GestorCsv.cargarTarjetasCredito();
		assertNotNull(ts);
	}

	@Test
	public void comprobarTarjetaTest() {
		assertEquals(true, GestorCsv.comprobarTarjeta("5540500001000004", "180"));
	}

}
