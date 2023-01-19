package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		
		e = new Entrada( 12, c, f, TipoEntrada.NORMAL);
		
	}

	@Test
	public void getCliente() {
		assertEquals(e.getCliente(), c);
	}
	@Test
	public void setCliente( ) {
		Cliente c2 = new Cliente(null, null, null, null, null, null, 0, 0);
		e.setCliente(c2);
		assertEquals(c2, e.getCliente());
	}
	@Test
	public void getNumeroEntrada() {
		assertEquals(12, e.getNumeroEntrada());
	}
	@Test
	public void setNumeroEntrada( ) {
		e.setNumeroEntrada(9);
		assertEquals(9, e.getNumeroEntrada());
	}
	@Test
	public void getFestival() {
		assertEquals(f, e.getFestival());
	}
	@Test
	public void setFestival( ) {
		Festival f2 = new Festival(0, null, null, null, null, listaConciertos, 0, null);
		e.setFestival(f2);
		assertEquals(f2, e.getFestival());
	}
	@Test
	public void getTipoE() {
		assertEquals(TipoEntrada.NORMAL, e.getTipoE());
	}

	public void setTipoE( ) {
		TipoEntrada tipoE = TipoEntrada.CONCAMPING;
		e.setTipoE(tipoE);
		assertEquals(tipoE, e.getTipoE());
	}
	
}
