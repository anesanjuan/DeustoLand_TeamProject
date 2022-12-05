import java.sql.SQLException;
import java.util.ArrayList;

import DeustoLand.Artista;
import DeustoLand.BaseDeDatos;
import DeustoLand.Cliente;
import DeustoLand.Concierto;
import DeustoLand.Festival;
import DeustoLand.Gestor;
import DeustoLand.TipoGenero;
import Ventanas.VentanaCompra;
import Ventanas.VentanaFestival;
import Ventanas.VentanaInicioSesion;
import Ventanas.VentanaPrincipal;
import Ventanas.VentanaRegistro;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Gestor gln = new Gestor(); 	
		//VentanaInicioSesion vi = new VentanaInicioSesion( gln );
		//vi.setVisible(true);
		
		//BaseDeDatos.abrirConexion("BaseDatos.db", true);
		BaseDeDatos.insertarFestivales();
		BaseDeDatos.insertarConciertos();
		BaseDeDatos.insertarArtistas();
		BaseDeDatos.insertarUsuarios();
		
		VentanaPrincipal vp = new VentanaPrincipal( gln );
		vp.setVisible(true);
		
		//BaseDeDatos.cerrarConexion();

		
		//VentanaFestival vf = new VentanaFestival(fest1);
		//vf.setVisible(true);
		
		//VentanaRegistro vr = new VentanaRegistro(gln);
		//vr.setVisible(true);
		
		//VentanaPrincipal vp = new VentanaPrincipal( gln );
		//vp.frame.setVisible(true);
		
		//Cliente cliente = new Cliente("nujdjdbhfl", "nunsnjdnll", "nunianjll", "nuakmidall", 0, "nspdifull", "nullsjnsoj");
		//VentanaCompra vc = new VentanaCompra(cliente);
		//vc.setVisible(true);
		
	}

}
