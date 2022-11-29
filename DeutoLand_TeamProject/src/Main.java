import java.util.ArrayList;

import DeustoLand.Artista;
import DeustoLand.BaseDeDatos;
import DeustoLand.Cliente;
import DeustoLand.Concierto;
import DeustoLand.Festival;
import DeustoLand.Gestor;
import Ventanas.VentanaCompra;
import Ventanas.VentanaFestival;
import Ventanas.VentanaInicioSesion;
import Ventanas.VentanaPrincipal;
import Ventanas.VentanaRegistro;

public class Main {

	public static void main(String[] args) {
		
		Gestor gln = new Gestor(); 	
		//VentanaInicioSesion vi = new VentanaInicioSesion( gln );
		//vi.setVisible(true);
		
		BaseDeDatos.abrirConexion("BaseDatos.db", false);
		ArrayList<Concierto> conciertofest = new ArrayList<>(); //esto no se muy bien como seria ñe
		ArrayList<Artista> artistfest = new ArrayList<>();
		Festival fest1 = new Festival(01, "TomorrowLand", "21-07-2023", "Dubai", "bla bla", conciertofest, artistfest, 150.7, "Fest1Tomorrowland.png");
		//Festival fest2 = new Festival(02, "Coachella", "21-07-2023", "Dubai", "bla bla", conciertofest, artistfest, 150.7);
		//Festival fest3 = new Festival(03, "Arenal Sound", "21-07-2023", "Dubai", "bla bla", conciertofest, artistfest, 150.7);
		//Festival fest4 = new Festival(04, "Mad Cool", "21-07-2023", "Dubai", "bla bla", conciertofest, artistfest, 150.7);
		//Festival fest5 = new Festival(05, "hollika", "21-07-2023", "Dubai", "bla bla", conciertofest, artistfest, 150.7);
		//Festival fest6 = new Festival(06, "boombastic", "21-07-2023", "Dubai", "bla bla", conciertofest, artistfest, 150.7);
		
		BaseDeDatos.insertarFestival(fest1);
		//BaseDeDatos.insertarFestival(fest2);
		//BaseDeDatos.insertarFestival(fest3);
		//BaseDeDatos.insertarFestival(fest4);
		//BaseDeDatos.insertarFestival(fest5);
		//BaseDeDatos.insertarFestival(fest6);
		
		//VentanaFestival vf = new VentanaFestival(fest1);
		//vf.setVisible(true);
		
		//VentanaRegistro vr = new VentanaRegistro(gln);
		//vr.setVisible(true);
		
		VentanaPrincipal vp = new VentanaPrincipal( gln );
		vp.frame.setVisible(true);
		
		//Cliente cliente = new Cliente("nujdjdbhfl", "nunsnjdnll", "nunianjll", "nuakmidall", 0, "nspdifull", "nullsjnsoj");
		//VentanaCompra vc = new VentanaCompra(cliente);
		//vc.setVisible(true);
		
	}

}
