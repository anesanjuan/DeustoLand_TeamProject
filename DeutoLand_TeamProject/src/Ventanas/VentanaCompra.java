package Ventanas;

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

		setBounds(100, 100, 901, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String titulo = "COMPRA ENTRADA FESTIVAL";
		
		panelP = new JPanel();
		
		parteArriba = new JPanel();
		Border bordeFestival = BorderFactory.createTitledBorder("Festival");
		parteArriba.setBorder(bordeFestival);
		parteArriba.setBounds(0, 0, 1050, 125);
		
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 130, 890, 468);
		
		partePrincipal1 = new JPanel();
		//Border bordeMedio1 = BorderFactory.createTitledBorder("Datos personales:");
		//parteAbajo.setBorder(bordeMedio1);
		parteAbajo.setBounds(0, 0, 1300, 150);
		
		
		partePrincipal2 = new JPanel();
		Border bordeMedio2 = BorderFactory.createTitledBorder(" ");
		parteAbajo.setBorder(bordeMedio2);
		parteAbajo.setBounds(0, 0, 1300, 150);
	
		
		parteAbajo = new JPanel();
		Border bordeAbajo = BorderFactory.createTitledBorder("Acción:");
		parteAbajo.setBorder(bordeAbajo);
		parteAbajo.setBounds(0, 0, 1200, 125);
		
		

		nombreFest = new JLabel("Festival " + festival.getNombre());
		nombreFest.setFont(new Font("Georgia", Font.PLAIN, 20));
		//nombreFest.setBounds(10, 11, 299, 36);
		parteArriba.add(nombreFest);
		
		infoFest = new JTextArea(5, 20);
		String texto = String.valueOf(festival.getDescripcion().charAt(0));
		for(int i=1;i<festival.getDescripcion().length();i++) {
			texto = texto + festival.getDescripcion().charAt(i);
			if(i%64==0) {
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
		mail = new JLabel("Mail :");
		textmail = new JLabel(u.getCorreo());
		partePrincipal1.add(textnombre);
		partePrincipal1.add(mail);
		partePrincipal1.add(textmail);
		
		
		entradaVip = new JLabel("Tipo entrada :");
		tipoEntrada = new JComboBox<TipoEntrada>();
		tipoEntrada.addItem(TipoEntrada.CONCAMPING);
		tipoEntrada.addItem(TipoEntrada.VIP);
		tipoEntrada.addItem(TipoEntrada.NORMAL);
		
		precioTotal = new JLabel("Precio total :");
		numeroTarjeta = new JLabel("Número de tarjeta :");
		textnumeroTarjeta = new JTextField(16);
		fechaCaducidad = new JLabel("Fecha de caducidad (mes/año):");
		textFechaCaducidad1 = new JTextField(2);
		textFechaCaducidad2 = new JTextField(2);
		cv = new JLabel("C.V. :");
		textcv = new JTextField(3);
		
		partePrincipal2.add(entradaVip);
		partePrincipal2.add(tipoEntrada);
		partePrincipal2.add(precioTotal);
		partePrincipal2.add(numeroTarjeta);
		partePrincipal2.add(textnumeroTarjeta);
		partePrincipal2.add(fechaCaducidad);
		partePrincipal2.add(textFechaCaducidad1);
		partePrincipal2.add(textFechaCaducidad2);
		partePrincipal2.add(cv);
		partePrincipal2.add(textcv);
		

		panelPrincipal.setLayout(new GridLayout(2, 1));
		panelPrincipal.add(partePrincipal1);
		panelPrincipal.add(partePrincipal2);
		
		comprar = new JButton("Comprar");
		parteAbajo.add(comprar);

		JButton bAtras = new JButton("Volver atrás");
		bAtras.setFont(new Font("Georgia", Font.PLAIN, 20));
		bAtras.setBounds(0, 0, 100, 400);
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
		
		setSize(1050, 800);
		//getContentPane().setLayout(new GridLayout(3, 1));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(titulo);

		panelP.add(parteArriba);
		panelP.add(panelPrincipal);
		panelP.add(parteAbajo);
	
		getContentPane().add(panelP);
	
		setVisible(true);

	}

}
