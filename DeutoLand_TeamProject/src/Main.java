import DeustoLand.GestorLN;
import Ventanas.VentanaInicioSesion;

public class Main {

	public static void main(String[] args) {
		GestorLN gln = new GestorLN(); 	
		VentanaInicioSesion vi = new VentanaInicioSesion( gln );
		vi.setVisible(true);
	}

}
