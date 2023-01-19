package Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DeustoLand.BaseDeDatos;
import DeustoLand.Cliente;
import DeustoLand.Gestor;
import DeustoLand.User;
import Excepciones.ClienteRepetidoException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VentanaRegistro extends JFrame {

	private final JPanel panel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtEmail;
	private JTextField txtContrasena;
	private JTextField txtDireccion;
	private JTextField txtEdad;
	private JTextField txtCodigoPostal;

	private Gestor gestor;

	public VentanaRegistro(Gestor gestor) {

		this.gestor = gestor;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registrarse:");

		// inicializar los campos editables
		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);

		txtDNI = new JTextField();
		txtDNI.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);

		txtContrasena = new JTextField();
		txtContrasena.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setColumns(10);

		// inicializar las etiquetas
		JLabel lblNombre = new JLabel("Nombre:");

		JLabel lblApellido = new JLabel("Apellido:");

		JLabel lblDNI = new JLabel("DNI:");

		JLabel lblCorreo = new JLabel("Correo:");

		JLabel lblContrasena = new JLabel("Contrasena:");

		JLabel lblDireccion = new JLabel("Direccion: ");

		JLabel lblEdad = new JLabel("Edad:");

		JLabel lblCodigoPostal = new JLabel("Codigo Postal:");

		// botones

		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String dni = txtDNI.getText();
				String email = txtEmail.getText();
				String contrasena = txtContrasena.getText();
				String direccion = txtDireccion.getText();
				int edad = Integer.parseInt(txtEdad.getText());
				int codigoPostal = Integer.parseInt(txtCodigoPostal.getText());

				try {
					gestor.insertarCliente(nombre, apellido, dni, email, contrasena, direccion, edad, codigoPostal);
					User u = BaseDeDatos.getCliente(email, contrasena);
					VentanaPrincipal vp = new VentanaPrincipal(gestor, u);
					vp.setVisible(true);
					dispose();
					// HACER COMPARACION!!! MAR
				} catch (ClienteRepetidoException ex) {
					JOptionPane.showMessageDialog(null, "Ese usuario ya esta registrado!", "ALERTA!",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}

		});

		// ventana
		setBounds(100, 100, 643, 473);
		getContentPane().setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(63)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE).addGap(62)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(338, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addGap(63)
						.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGap(62).addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(63)
						.addComponent(lblDNI, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(73)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(63)
						.addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(73)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(63)
						.addComponent(lblContrasena, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGap(33).addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(63)
						.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addGap(48).addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(63)
						.addComponent(lblEdad, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(73)
						.addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(444).addComponent(btnRegistro,
						GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(63)
						.addComponent(lblCodigoPostal, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addGap(27).addComponent(txtCodigoPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(28)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(lblNombre)
										.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE))
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(lblApellido))
								.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(lblDNI))
								.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(27)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(lblCorreo))
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(27)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(lblContrasena))
								.addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(24)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(lblDireccion))
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(lblEdad))
								.addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(6).addComponent(btnRegistro).addGap(5)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(lblCodigoPostal))
								.addComponent(txtCodigoPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(44)));
		panel.setLayout(gl_panel);

	}
}
