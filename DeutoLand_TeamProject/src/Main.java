import DeustoLand.Cliente;
import DeustoLand.GestorLN;
import Ventanas.VentanaCompra;
import Ventanas.VentanaFestival;
import Ventanas.VentanaInicioSesion;
import Ventanas.VentanaPrincipal;
import Ventanas.VentanaRegistro;

public class Main {

	public static void main(String[] args) {
		
		GestorLN gln = new GestorLN(); 	
		//VentanaInicioSesion vi = new VentanaInicioSesion( gln );
		//vi.setVisible(true);
		
		//VentanaFestival vf = new VentanaFestival();
		//vf.setVisible(true);
		
		//VentanaRegistro vr = new VentanaRegistro(gln);
		//vr.setVisible(true);
		
		VentanaPrincipal vp = new VentanaPrincipal( gln );
		vp.setVisible(true);
		
		//Cliente cliente = new Cliente("nujdjdbhfl", "nunsnjdnll", "nunianjll", "nuakmidall", 0, "nspdifull", "nullsjnsoj");
		//VentanaCompra vc = new VentanaCompra(cliente);
		//vc.setVisible(true);
	}

}
