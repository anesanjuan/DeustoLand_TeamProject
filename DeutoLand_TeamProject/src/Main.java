import java.util.ArrayList;

import DeustoLand.Artista;
import DeustoLand.Cliente;
import DeustoLand.Concierto;
import DeustoLand.Festival;
import DeustoLand.GestorLN;
import Ventanas.BaseDeDatos;
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
		
		/*BaseDeDatos.abrirConexion("BaseDatos.db", false);
		ArrayList<Concierto> conciertofest1 = new ArrayList<>();
		ArrayList<Artista> artistfest1 = new ArrayList<>();
		Festival fest1 = new Festival("TomorrowLand", "21-07-2023", "Dubai", "bla bla", conciertofest1, artistfest1, 150.7);
		VentanaFestival vf = new VentanaFestival(fest1);
		vf.setVisible(true);*/
		
		//VentanaRegistro vr = new VentanaRegistro(gln);
		//vr.setVisible(true);
		
		VentanaPrincipal vp = new VentanaPrincipal( gln );
		vp.frame.setVisible(true);
		
		//Cliente cliente = new Cliente("nujdjdbhfl", "nunsnjdnll", "nunianjll", "nuakmidall", 0, "nspdifull", "nullsjnsoj");
		//VentanaCompra vc = new VentanaCompra(cliente);
		//vc.setVisible(true);
		
	}

}
