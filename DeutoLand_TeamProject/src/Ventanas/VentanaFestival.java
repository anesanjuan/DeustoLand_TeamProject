package Ventanas;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaFestival extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel parteArriba;
	private JPanel partePrincipal;
	private JPanel partePrincipal1;
	private JPanel partePrincipal2;
	private JPanel partePrincipal21;
	private JPanel partePrincipal22;
	private JPanel partePrincipal23;
	private JPanel partePrincipal3;
	private JPanel partePrincipal4;
	
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
	private JLabel fotoFestival; //NO ES LABEL ES FOTO
	
	
	public VentanaFestival() {
		
		parteArriba = new JPanel();
		partePrincipal = new JPanel();
		partePrincipal1 = new JPanel();
		partePrincipal2 = new JPanel();
		partePrincipal21 = new JPanel();
		partePrincipal22 = new JPanel();
		partePrincipal23 = new JPanel();
		partePrincipal3 = new JPanel();
		partePrincipal4 = new JPanel();
		
		bInicioSesion = new JButton("Iniciar Sesión");
		bRegistro = new JButton("Regstrarse");
		bAtras = new JButton("Atrás");
		titulo = new JLabel("Festival x"); //CAMBIAR ESTO DESPUES!!!!!
		
		tituloFecha = new JLabel("Fecha:");
		tituloLugar = new JLabel("Lugar:");
		tituloArtistasInv = new JLabel("Artistas invitados:");
		tituloDescripcion = new JLabel("Descripción:");
		tituloPrecio = new JLabel("Precio:");
		bComprarEntradas = new JButton("Comprar Entradas");
		
		//COMP0NENTES QUE VARIAN
		fecha = new JLabel("x");
		lugar = new JLabel("x");
		artistasInv = new JLabel("x");
		descripcion = new JLabel("x");
		precio = new JLabel("x");
		fotoFestival = new JLabel(); 
		
		
		
		setSize(1050,800);
		getContentPane().setLayout(new GridLayout(2,1));
		setVisible(true);
		parteArriba.setSize(1050, 200);
		partePrincipal.setSize(1050,600);
		//parteArriba.setLayout(new FlowLayout());
		//partePrincipal.setLayout(new FlowLayout());
		
		parteArriba.add(titulo);
		parteArriba.add(bAtras);
		parteArriba.add(bRegistro);
		parteArriba.add(bInicioSesion);
		
		partePrincipal.setLayout(new GridLayout(2,2));
		partePrincipal.add(partePrincipal1);
		partePrincipal.add(partePrincipal2);
		partePrincipal.add(partePrincipal3);
		partePrincipal.add(partePrincipal4);
		
		partePrincipal1.add(fotoFestival);
		
		partePrincipal2.setLayout(new GridLayout(3,1));
		partePrincipal2.add(partePrincipal21);
		partePrincipal2.add(partePrincipal22);
		partePrincipal2.add(partePrincipal23);
		
		partePrincipal21.add(tituloFecha);
		partePrincipal21.add(fecha);
		partePrincipal21.add(tituloLugar);
		partePrincipal21.add(lugar);
		
		partePrincipal22.add(tituloArtistasInv);
		partePrincipal22.add(artistasInv);
		
		partePrincipal23.add(tituloDescripcion);
		partePrincipal23.add(descripcion);
		
		partePrincipal3.add(tituloPrecio);
		partePrincipal3.add(precio);
		partePrincipal4.add(bComprarEntradas);
		
		//parteArriba.setBounds(1050, 200, 1050, 600);
		getContentPane().add(parteArriba );
		getContentPane().add(partePrincipal);
		
		setVisible(true);
		
	}
	

	
}
