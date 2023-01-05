package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DeustoLand.Admin;

public class AdminTest {
	
	//tengo que añadir los set y get de la clase user?
	

	private Admin a;
	
	@Before
	public void setUp() throws Exception {

		//he cogido uno de los admin que estan en la bd(pero todavia no estan cargados)
		 a = new Admin("Juan", "Perez", "23423762A", "juanperez@gmail.com", "juanperez23", "27/10/2022");
		
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAdmin() {
		assertNotNull(a);
	}
	@Test
	public void getFechaUltimaMod() {
		assertEquals(a.getFechaUltimaMod(),  "27/10/2022" );
	}
	@Test
	public void setFechaUltimaMod() {
		fail("Not yet implemented");
	}
	
	
}


