package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DeustoLand.Cliente;
import DeustoLand.Concierto;
import DeustoLand.Entrada;
import DeustoLand.Festival;
import DeustoLand.TipoEntrada;

public class EntradaTest {

	private Entrada e;
	private Cliente c;
	private Festival f;
	private ArrayList<Concierto> listaConciertos ;

	@Before
	public void setUp() throws Exception {
		c = new Cliente("Cristina", "Lopez", "4567881A", "crislopez@gmail.com", "5678", "Koldo Mitxelena, 9", 24, 37879);
		
		f = new Festival(01, "Tomorrowland", "21-07-2023", "Boom, Bélgica",
				"Tomorrowland es un festival de música electrónica de baile en el que lo pasarás en grande y difrutaras de 3 días increíbles con tus amigos y lleno de música. El festival tiene una duración de 3 días y cada día empezará sobre las 18:00 horas. Para más información consulte la página oficial del sitio: https://www.tomorrowland.com/",
				listaConciertos,150.00, "tomorrowland.png");
		
		e = new Entrada( c,12, f, TipoEntrada.NORMAL);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void getCliente() {
		assertEquals(e.getCliente(), c);
	}
	@Test
	public void setCliente( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getNumeroEntrada() {
		assertEquals(e.getNumeroEntrada(), 12);
	}
	@Test
	public void setNumeroEntrada( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getFestival() {
		assertEquals(e.getFestival(), f);
	}
	@Test
	public void setFestival( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getTipoE() {
		assertEquals(e.getTipoE(), TipoEntrada.NORMAL);
	}

	public void setTipoE( ) {
		fail("Not yet implemented");
	}
	
}
