package JUnit;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import DeustoLand.Admin;

public class AdminTest {

	

	@Test
	public void test() {
		//he cogido uno de los admin que estan en la bd(pero todavia no estan cargados)
		Admin a = new Admin("Juan", "Perez", "23423762A", "juanperez@gmail.com", "juanperez23", "27/10/2022");
		
		assertEquals(a.getNombre(), "Juan");
		assertEquals(a.getApellido(), "Perez");
		assertEquals(a.getDni(), "23423762A");
		assertEquals(a.getCorreo(),"juanperez@gmail.com" );
		assertEquals(a.getContrasena(), "juanperez23");
		assertEquals(a.getFechaUltimaMod(),"27/10/2022" );
		}
	}


