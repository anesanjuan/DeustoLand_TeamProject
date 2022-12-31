package Ventanas;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DeustoLand.Cliente;
import DeustoLand.Festival;
import DeustoLand.User;

public class VentanaCompra extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel parteArriba;
	private JPanel partePrincipal;
	private JPanel pInfoFestival;
	private JPanel partePrincipal1;
	private JPanel partePrincipal2;
	private JPanel parteAbajo;
	
	//Componentes del panel de arriba
	private JLabel titulo;
	
	//Componentes del panel principal1
	private JLabel nombreFest;
	private JLabel infoFest;
	
	//Componentes del panel principal1
	private  JLabel nombre;
	private  JLabel textnombre;
	private  JLabel mail;
	private  JLabel textmail;
	private  JLabel entradaVip;
	private JComboBox<String> esEntradaVip;
	private  JLabel precioTotal;
	
	private  JLabel numeroTarjeta;
	private JTextField textnumeroTarjeta;
	private  JLabel fechaCaducidad;
	private JTextField textFechaCaducidad;
	private  JLabel cv;
	private JTextField textcv;
	
	//Componentes del panel abajo
	private  JButton comprar;
	

	public VentanaCompra(Festival festival, User u) {
		//parteArriba.setBounds(0, 0, 890, 47);
		//partePrincipal.setBounds(0, 0, 890, 47);
		//pInfoFestival.setBounds(0, 0, 890, 47);
		//parteAbajo.setBounds(0, 0, 890, 47);
		
		
		System.out.println(festival);
		System.out.println(u);
		parteArriba = new JPanel();
		partePrincipal = new JPanel();
		pInfoFestival = new JPanel();
		partePrincipal1 = new JPanel();
		partePrincipal2 = new JPanel();
		parteAbajo = new JPanel();
		
		titulo = new JLabel("COMPRA ENTRADA FESTIVAL");
		
		nombreFest = new JLabel("Festival seleccionado: " + festival.getNombre());
		infoFest =  new JLabel("Info: " + festival.getDescripcion());
		
		
		nombre = new JLabel("Nombre: ");
		textnombre = new JLabel (u.getNombre());
		mail = new JLabel("Mail :");
		textmail =  new JLabel (u.getCorreo());
		entradaVip = new JLabel("Entrada VIP :");
		esEntradaVip = new JComboBox<String>();
		precioTotal = new JLabel("Precio total :");
		
		numeroTarjeta = new JLabel("Número de tarjeta :");
		textnumeroTarjeta = new JTextField(16);
		fechaCaducidad = new JLabel("Fecha de caducidad :");
		textFechaCaducidad= new JTextField(5);
		cv = new JLabel("C.V. :");
		textcv= new JTextField(3);
		
		comprar = new JButton ("Comparar");
		
		
		
		setSize(1050,800);
		getContentPane().setLayout(new GridLayout(3,1));
		setVisible(true);
		parteArriba.setSize(1050, 200);
		partePrincipal.setSize(1050,500);
		parteAbajo.setSize(1050,100);
		
		parteArriba.add(titulo);
		
		partePrincipal.setLayout(new GridLayout(4,1));
		partePrincipal.add(pInfoFestival);
		partePrincipal.add(partePrincipal1);
		partePrincipal.add(partePrincipal2);
		
		pInfoFestival.add(nombreFest);
		pInfoFestival.add(infoFest);
		
		partePrincipal1.add(nombre);
		partePrincipal1.add(textnombre);
		partePrincipal1.add(mail);
		partePrincipal1.add(textmail);
		partePrincipal1.add(entradaVip);
		partePrincipal1.add(esEntradaVip);
		partePrincipal1.add(precioTotal);
		
		partePrincipal2.add(numeroTarjeta);
		partePrincipal2.add(textnumeroTarjeta);
		partePrincipal2.add(fechaCaducidad);
		partePrincipal2.add(textFechaCaducidad);
		partePrincipal2.add(cv);
		partePrincipal2.add(textcv);
		
		parteAbajo.add(comprar);
		
		getContentPane().add(parteArriba);
		getContentPane().add(partePrincipal);
		getContentPane().add(parteAbajo);
		
		setVisible(true);
		
	}

}
