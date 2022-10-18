package Ventanas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaFestival extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel parteArriba;
	private JPanel partePrincipal;
	
	//componentes del panel de arriba
	private JButton bInicioSesion;
	private JButton bRegistro;
	private JButton bAtras;
	private JLabel titulo;
	
	//componentes del panel principal
	private JLabel tituloFecha;
	private JLabel fecha;
	private JLabel tituloLugar;
	private JLabel lugar;
	private JLabel tituloArtistasInv;
	private JLabel artistasInv;
	private JLabel tituloDescripcion;
	private JLabel descripcion;
	private JLabel tituloPrecio;
	private JLabel precio;
	private JButton bComprarEntradas;
	private ImageIcon fotoFestival;
	

}
