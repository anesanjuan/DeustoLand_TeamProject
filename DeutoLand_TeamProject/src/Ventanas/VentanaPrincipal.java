package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import DeustoLand.GestorLN;


public class VentanaPrincipal extends JFrame{

	private final JPanel panel = new JPanel();
	private GestorLN gestor;

	//esto es como inicializar: mete todo dentro
	public VentanaPrincipal(GestorLN gestor) {
		setTitle("Inicio de Sesion:");
		this.gestor = gestor;
	}
}
