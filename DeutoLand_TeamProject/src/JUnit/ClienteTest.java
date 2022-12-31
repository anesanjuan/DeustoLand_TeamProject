package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DeustoLand.Cliente;

public class ClienteTest {

	
	@Test
	public void test() {
		Cliente c = new Cliente("Cristina", "Lopez", "4567881A", "crislopez@gmail.com", "5678", "Vitoria", 24, 37879);

		assertEquals(c.getNombre(), "Cristina");
		assertEquals(c.getApellido(), "Lopez");
		assertEquals(c.getDni(),"4567881A" );
		assertEquals(c.getCorreo(), "crislopez@gmail.com");
		assertEquals(c.getContrasena(),"5678");
		assertEquals(c.getDireccion(),"Vitoria");
		assertEquals(c.getEdad(), 24);
		assertEquals(c.getCodigoP(), 37879 );
	}

}
