package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DeustoLand.Concierto;
import DeustoLand.Festival;


//tengo que hacer tmb el compare to???


public class FestivalTest {

	private Festival f;
	
	private ArrayList<Concierto> listaConciertos ;
	
	@Before
	public void setUp() throws Exception {
		f = new Festival(01, "Tomorrowland", "21-07-2023", "Boom, Bélgica",
				"Tomorrowland es un festival de música electrónica de baile en el que lo pasarás en grande y difrutaras de 3 días increíbles con tus amigos y lleno de música. El festival tiene una duración de 3 días y cada día empezará sobre las 18:00 horas. Para más información consulte la página oficial del sitio: https://www.tomorrowland.com/",
				listaConciertos,150.00, "tomorrowland.png");
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testFestival() {
		assertNotNull(f);
	}
	@Test
	public void getCodigoF() {
		assertEquals(f.getCodigoF(), 01);
	}
	@Test
	public void setCodigoF( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getNombre() {
		assertEquals(f.getCodigoF(), "Tomorrowland");
	}
	@Test
	public void setNombre( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getFecha() {
		assertEquals(f.getFecha(), "21-07-2023");
	}
	@Test
	public void setFecha( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getLugar() {
		assertEquals(f.getLugar(), "Boom, Bélgica");
	}
	@Test
	public void setLugar( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getDescripcion() {
		assertEquals(f.getDescripcion(),"Tomorrowland es un festival de música electrónica de baile en el que lo pasarás en grande y difrutaras de 3 días increíbles con tus amigos y lleno de música. El festival tiene una duración de 3 días y cada día empezará sobre las 18:00 horas. Para más información consulte la página oficial del sitio: https://www.tomorrowland.com/"
 );
	}
	@Test
	public void setDescripcion( ) {
		fail("Not yet implemented");
	}
	
	@Test
	public void getListaConciertos() {
		assertEquals(f.getListaConciertos(), listaConciertos);
	}
	@Test
	public void setListaConciertos( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getPrecio() {
		assertTrue(f.getPrecio() == 150);
	}
	@Test
	public void setPrecio( ) {
		fail("Not yet implemented");
	}
	@Test
	public void getFoto() {
		assertEquals(f.getFoto(), "Tomorrowland.png");
	}
	@Test
	public void setFoto( ) {
		fail("Not yet implemented");
	}


}
