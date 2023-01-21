import java.sql.SQLException;

import java.util.ArrayList;

import DeustoLand.Artista;
import DeustoLand.BaseDeDatos;
import DeustoLand.Cliente;
import DeustoLand.Concierto;
import DeustoLand.Festival;
import DeustoLand.Gestor;
import DeustoLand.TipoGenero;
import DeustoLand.User;
import Ventanas.VentanaCompra;
import Ventanas.VentanaEstadisticas;
import Ventanas.VentanaFestival;
import Ventanas.VentanaInicioSesion;
import Ventanas.VentanaPrincipal;
import Ventanas.VentanaRegistro;
import Ventanas.vFesti;

public class Main {

	public static void main(String[] args) throws SQLException {

		BaseDeDatos.abrirConexion("BaseDatos.db", false);
		// BaseDeDatos.insertarArtistas();
		// BaseDeDatos.insertarFestivales();
		// BaseDeDatos.insertarConciertos();
		// BaseDeDatos.insertarUsuarios();
		// BaseDeDatos.insertarEntradas();

		Gestor gln = new Gestor();
		VentanaPrincipal vp = new VentanaPrincipal(gln, null);
		vp.setVisible(true);

	}

}
