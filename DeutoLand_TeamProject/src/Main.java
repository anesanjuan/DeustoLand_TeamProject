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
import Ventanas.VentanaEstadisticas;
import Ventanas.VentanaFestival;
import Ventanas.VentanaInicioSesion;
import Ventanas.VentanaPrincipal;
import Ventanas.VentanaRegistro;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		 	
		//VentanaInicioSesion vi = new VentanaInicioSesion( gln );
		//vi.setVisible(true);
		
		BaseDeDatos.abrirConexion("BaseDatos.db", false);
		//BaseDeDatos.insertarFestivales();
		//BaseDeDatos.insertarConciertos();
		//BaseDeDatos.insertarArtistas();
		//BaseDeDatos.insertarUsuarios();
		
		Gestor gln = new Gestor();
		VentanaPrincipal vp = new VentanaPrincipal( gln, null );
		vp.setVisible(true);
		
		//VentanaEstadisticas ve = new VentanaEstadisticas();
		//ve.setVisible(true);
		
		//BaseDeDatos.cerrarConexion();

		//VentanaFestival vf = new VentanaFestival(fest1);
		//vf.setVisible(true);
		
		//VentanaRegistro vr = new VentanaRegistro(gln);
		//vr.setVisible(true);
		
		//VentanaPrincipal vp = new VentanaPrincipal( gln );
		//vp.frame.setVisible(true);
		
		//Cliente cliente = new Cliente("Manuel", "Garcia", "28881910", "8474929", 0, "84894", "86352");
		
		//VentanaCompra vc = new VentanaCompra(cliente);
		//vc.setVisible(true);
		
	}

}
