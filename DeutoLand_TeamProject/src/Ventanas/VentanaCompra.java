package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import DeustoLand.BaseDeDatos;
import DeustoLand.Cliente;
import DeustoLand.Festival;
import DeustoLand.GestorCsv;
import DeustoLand.TipoEntrada;
import DeustoLand.User;

public class VentanaCompra extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panelP;
	private JPanel parteArriba;
	private JPanel panelPrincipal;
	private JPanel partePrincipal1;
	private JPanel partePrincipal2;
	private JPanel partePrincipal3;
	private JPanel partePrincipal4;
	private JPanel parteAbajo;
	
	// Componentes del panel principal1
	private JLabel nombreFest;
	private JTextArea infoFest;

	// Componentes del panel principal1
	private JLabel nombre;
	private JLabel textnombre;
	private JLabel mail;
	private JLabel textmail;
	private JLabel entradaVip;
	private JComboBox<TipoEntrada> tipoEntrada;
	private JLabel precioTotal;
	private JLabel textPrecioT;

	private JLabel numeroTarjeta;
	private JTextField textnumeroTarjeta;
	private JLabel fechaCaducidad;
	private JTextField textFechaCaducidad1;
	private JTextField textFechaCaducidad2;
	private JLabel cv;
	private JTextField textcv;

	// Componentes del panel abajo
	private JButton comprar;

	public VentanaCompra(Festival festival, User u) {

		System.out.println(festival);
		System.out.println(u);

		setBounds(100, 100, 2000, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String titulo = "COMPRA ENTRADA FESTIVAL";
		
		panelP = new JPanel();
		
		parteArriba = new JPanel();
		Border bordeFestival = BorderFactory.createTitledBorder("Festival");
		parteArriba.setBorder(bordeFestival);
		parteArriba.setBounds(100, 150, 800, 100);
		
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(100, 150, 1000, 400);
		
		partePrincipal1 = new JPanel();
		parteAbajo = new JPanel();
		Border bordeMedio1 = BorderFactory.createTitledBorder("Datos personales:");
		partePrincipal1.setBorder(bordeMedio1);
		partePrincipal1.setBounds(100, 150, 900, 600);
		
		
		partePrincipal2 = new JPanel();
		//Border bordeMedio2 = BorderFactory.createTitledBorder("");
		//partePrincipal2.setBorder(bordeMedio2);
		partePrincipal2.setBounds(100, 150, 900, 600);
	
		partePrincipal3 = new JPanel();
		//Border bordeMedio3 = BorderFactory.createTitledBorder("");
		//partePrincipal3.setBorder(bordeMedio3);
		partePrincipal3.setBounds(100, 150, 900, 600);
		
		partePrincipal4 = new JPanel();
		Border bordeMedio4 = BorderFactory.createTitledBorder("");
		partePrincipal4.setBorder(bordeMedio4);
		partePrincipal4.setBounds(100, 150, 900, 600);
	
		Border bordeAbajo = BorderFactory.createTitledBorder("");
		parteAbajo.setBorder(bordeAbajo);
		parteAbajo.setBounds(0, 0, 100, 90);
		
		
		nombreFest = new JLabel("Festival " + festival.getNombre());
		nombreFest.setFont(new Font("Georgia", Font.PLAIN, 20));
		//nombreFest.setBounds(10, 11, 299, 36);
		parteArriba.add(nombreFest);
		
		infoFest = new JTextArea(5, 20);
		String texto = String.valueOf(festival.getDescripcion().charAt(0));
		for(int i=1;i<festival.getDescripcion().length();i++) {
			texto = texto + festival.getDescripcion().charAt(i);
			if(i%64==0) {
				String s = festival.getDescripcion().substring(i+1);
				int pos = s.indexOf(' ');
				if(pos!=-1) {
					String pal = festival.getDescripcion().substring(i+1, i+1+pos);
					texto = texto + pal;
					i += pal.length();
				}
				texto = texto + "\n";
			}
		}
		
		infoFest.append(texto);
		infoFest.setEditable(false);
		parteArriba.add(infoFest);
		
	
		nombre = new JLabel("Nombre: ");
		nombre.setFont(new Font("Georgia", Font.PLAIN, 15));
		nombre.setBounds(22, 270, 75, 42);
		partePrincipal1.add(nombre);
		
		textnombre = new JLabel(u.getNombre());
		textnombre.setFont(new Font("Georgia", Font.PLAIN, 15));
		textnombre.setBounds(22, 270, 75, 42);
		
		mail = new JLabel("Mail :");
		mail.setFont(new Font("Georgia", Font.PLAIN, 15));
		mail.setBounds(22, 270, 75, 42);
		
		textmail = new JLabel(u.getCorreo());
		textmail.setFont(new Font("Georgia", Font.PLAIN, 15));
		textmail.setBounds(22, 270, 75, 42);
		
		partePrincipal1.add(textnombre);
		partePrincipal1.add(mail);
		partePrincipal1.add(textmail);
		
		
		entradaVip = new JLabel("Tipo entrada :");
		entradaVip.setFont(new Font("Georgia", Font.PLAIN, 15));
		entradaVip.setBounds(22, 270, 75, 42);
		
		tipoEntrada = new JComboBox<TipoEntrada>();
		tipoEntrada.setFont(new Font("Georgia", Font.PLAIN, 15));
		tipoEntrada.setBounds(22, 270, 75, 42);
		tipoEntrada.addItem(TipoEntrada.CONCAMPING);
		tipoEntrada.addItem(TipoEntrada.VIP);
		tipoEntrada.addItem(TipoEntrada.NORMAL);
		
		precioTotal = new JLabel("Precio total :");
		precioTotal.setFont(new Font("Georgia", Font.PLAIN, 20));
		precioTotal.setBounds(22, 270, 75, 42);
		
		double preciototalEntrada = BaseDeDatos.getPrecioTotalEntrada(festival.getNombre(), (TipoEntrada)tipoEntrada.getSelectedItem());
		textPrecioT = new JLabel(String.valueOf(preciototalEntrada));
		textPrecioT.setFont(new Font("Georgia", Font.PLAIN, 25));
		textPrecioT.setBounds(22, 270, 75, 42);
		
		
		numeroTarjeta = new JLabel("Número de tarjeta :");
		numeroTarjeta.setFont(new Font("Georgia", Font.PLAIN, 15));
		numeroTarjeta.setBounds(22, 270, 75, 42);
		
		textnumeroTarjeta = new JTextField(16);
		textnumeroTarjeta.setFont(new Font("Georgia", Font.PLAIN, 15));
		textnumeroTarjeta.setBounds(22, 270, 75, 42);
		
		fechaCaducidad = new JLabel("Fecha de caducidad (mes/año):");
		fechaCaducidad.setFont(new Font("Georgia", Font.PLAIN, 15));
		fechaCaducidad.setBounds(22, 270, 75, 42);
		
		textFechaCaducidad1 = new JTextField(2);
		textFechaCaducidad2 = new JTextField(2);
		
		cv = new JLabel("C.V. :");
		cv.setFont(new Font("Georgia", Font.PLAIN, 15));
		cv.setBounds(22, 270, 75, 42);
		
		textcv = new JTextField(3);
		textcv.setFont(new Font("Georgia", Font.PLAIN, 15));
		textcv.setBounds(22, 270, 75, 42);
		
		partePrincipal2.add(entradaVip);
		partePrincipal2.add(tipoEntrada);
	
		partePrincipal3.add(numeroTarjeta);
		partePrincipal3.add(textnumeroTarjeta);
		partePrincipal3.add(fechaCaducidad);
		partePrincipal3.add(textFechaCaducidad1);
		partePrincipal3.add(textFechaCaducidad2);
		partePrincipal3.add(cv);
		partePrincipal3.add(textcv);
		
		partePrincipal4.add(precioTotal);
		partePrincipal4.add(textPrecioT);
		
		panelPrincipal.setLayout(new GridLayout(4, 1));
		panelPrincipal.add(partePrincipal1);
		panelPrincipal.add(partePrincipal2);
		panelPrincipal.add(partePrincipal3);
		panelPrincipal.add(partePrincipal4);
		
		comprar = new JButton("Comprar");
		comprar.setFont(new Font("Georgia", Font.PLAIN, 15));
		comprar.setBounds(0, 0, 90, 400);
		parteAbajo.add(comprar);

		JButton bAtras = new JButton("Volver atrás");
		bAtras.setFont(new Font("Georgia", Font.PLAIN, 15));
		bAtras.setBounds(0, 0, 90, 400);
		parteAbajo.add(bAtras);
		bAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaFestival vf = new VentanaFestival(festival, u);
				vf.setVisible(true);
				setVisible(false);

			}
		});
		
		//////////////////////////////////////////////////////////////////

		comprar.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub

				if (((TipoEntrada) tipoEntrada.getSelectedItem()).equals(TipoEntrada.NORMAL)) {

					if (textnumeroTarjeta.getText().equals("") || textFechaCaducidad1.getText().equals("")
							|| textFechaCaducidad2.getText().equals("") || textcv.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Para poder realizar la compra es necesario rellenar todos los campos");
					} else {
						if (textnumeroTarjeta.getSelectionEnd() == 16 && textFechaCaducidad1.getText().length() == 2
								&& textFechaCaducidad2.getText().length() == 2 && textcv.getText().length() == 3) {
							if (GestorCsv.comprobarTarjeta(textnumeroTarjeta.getText(), textcv.getText())) {
								Cliente c = BaseDeDatos.getCliente(u.getCorreo(), u.getContrasena());
								BaseDeDatos.crearEntrada(festival, c, TipoEntrada.NORMAL);
								JOptionPane.showMessageDialog(null, "La entrada se ha comprado correctamente");
							} else {
								JOptionPane.showMessageDialog(null, "La tarjeta introducida no existe");
							}
						} else {
							JOptionPane.showMessageDialog(null, "El número de tarjeta introducido no es válido");
						}
					}

				} else if (((TipoEntrada) tipoEntrada.getSelectedItem()).equals(TipoEntrada.VIP)) {

					if (textnumeroTarjeta.getText().equals("") || textFechaCaducidad1.getText().equals("")
							|| textFechaCaducidad2.getText().equals("") || textcv.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Para poder realizar la compra es necesario rellenar todos los campos");
					} else {
						if (textnumeroTarjeta.getText().length() == 16 && textFechaCaducidad1.getText().length() == 2
								&& textFechaCaducidad2.getText().length() == 2 && textcv.getText().length() == 3) {
							if (GestorCsv.comprobarTarjeta(textnumeroTarjeta.getText(), textcv.getText())) {
								Cliente c = BaseDeDatos.getCliente(u.getCorreo(), u.getContrasena());
								BaseDeDatos.crearEntrada(festival, c, TipoEntrada.VIP);
								JOptionPane.showMessageDialog(null, "La entrada se ha comprado correctamente");
							} else {
								JOptionPane.showMessageDialog(null, "La tarjeta introducida no existe");
							}

						} else {
							JOptionPane.showMessageDialog(null, "El número de tarjeta introducido no es válido");
						}
					}
				} else if (((TipoEntrada) tipoEntrada.getSelectedItem()).equals(TipoEntrada.CONCAMPING)) {
					if (textnumeroTarjeta.getText().equals("") || textFechaCaducidad1.getText().equals("")
							|| textFechaCaducidad2.getText().equals("") || textcv.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Para poder realizar la compra es necesario rellenar todos los campos");
					} else {
						if (textnumeroTarjeta.getText().length() == 16 && textFechaCaducidad1.getText().length() == 2
								&& textFechaCaducidad2.getText().length() == 2 && textcv.getText().length() == 3) {
							if (GestorCsv.comprobarTarjeta(textnumeroTarjeta.getText(), textcv.getText())) {

								Cliente c = BaseDeDatos.getCliente(u.getCorreo(), u.getContrasena());
								Random numAleatorio = new Random();
								BaseDeDatos.crearEntradaConCamping(festival, c, numAleatorio);
								JOptionPane.showMessageDialog(null, "La entrada se ha comprado correctamente");
							} else {
								JOptionPane.showMessageDialog(null, "La tarjeta introducida no existe");
							}

						} else {
							JOptionPane.showMessageDialog(null, "El número de tarjeta introducido no es válido");
						}
					}
				} else {
					System.out.println(tipoEntrada.getSelectedItem());
					System.out.println(TipoEntrada.NORMAL);
					JOptionPane.showMessageDialog(null,
							"Para poder realizar la compra es necesario escoger un tipo de entrada");

				}
			}
		});
		
		setSize(1050, 400);
	
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(titulo);

		panelP.add(parteArriba);
		panelP.add(panelPrincipal);
		panelP.add(parteAbajo);
	
		getContentPane().add(panelP);
		
		
		parteArriba.setBackground(new Color(237, 245, 244));
		panelPrincipal.setBackground(new Color(237, 245, 244));
		parteAbajo.setBackground(new Color(237, 245, 244));
		partePrincipal1.setBackground(new Color(237, 245, 244));
		partePrincipal2.setBackground(new Color(237, 245, 244));
		partePrincipal3.setBackground(new Color(237, 245, 244));
		partePrincipal4.setBackground(new Color(237, 245, 244));
		panelP.setBackground(new Color(237, 245, 244));
		
		
		entradaVip.setBackground(new Color(237, 245, 244));
		tipoEntrada.setBackground(new Color(237, 245, 244));
		numeroTarjeta.setBackground(new Color(237, 245, 244));
		textnumeroTarjeta.setBackground(new Color(237, 245, 244));
		fechaCaducidad.setBackground(new Color(237, 245, 244));
		textFechaCaducidad1.setBackground(new Color(237, 245, 244));
		textFechaCaducidad2.setBackground(new Color(237, 245, 244));
		cv.setBackground(new Color(237, 245, 244));
		textcv.setBackground(new Color(237, 245, 244));
		precioTotal.setBackground(new Color(237, 245, 244));
		textPrecioT.setBackground(new Color(237, 245, 244));
		textFechaCaducidad1.setBackground(new Color(237, 245, 244));
		textFechaCaducidad2.setBackground(new Color(237, 245, 244));
		cv.setBackground(new Color(237, 245, 244));
		textcv.setBackground(new Color(237, 245, 244));
		precioTotal.setBackground(new Color(237, 245, 244));

	
		setVisible(true);

	}

}
