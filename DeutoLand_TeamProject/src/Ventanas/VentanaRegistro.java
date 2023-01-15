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
		txtNombre.setBounds(190, 33, 96, 20);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(190, 79, 96, 20);
		txtApellido.setColumns(10);

		txtDNI = new JTextField();
		txtDNI.setBounds(190, 125, 96, 20);
		txtDNI.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(190, 172, 96, 20);
		txtEmail.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(190, 263, 96, 20);
		txtDireccion.setColumns(10);

		txtContrasena = new JTextField();
		txtContrasena.setBounds(190, 219, 96, 20);
		txtContrasena.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setBounds(190, 313, 96, 20);
		txtEdad.setColumns(10);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBounds(190, 367, 96, 20);
		txtCodigoPostal.setColumns(10);

		// inicializar las etiquetas
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(68, 35, 60, 14);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(68, 82, 60, 14);

		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(68, 128, 49, 14);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(68, 175, 49, 14);

		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setBounds(68, 222, 89, 14);

		JLabel lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setBounds(68, 266, 74, 14);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(68, 316, 49, 14);

		JLabel lblCodigoPostal = new JLabel("Codigo Postal:");
		lblCodigoPostal.setBounds(68, 370, 95, 14);

		// botones

		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(449, 339, 89, 23);
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
		panel.setLayout(null);
		panel.add(lblNombre);
		panel.add(txtNombre);
		panel.add(lblApellido);
		panel.add(txtApellido);
		panel.add(lblDNI);
		panel.add(txtDNI);
		panel.add(lblCorreo);
		panel.add(txtEmail);
		panel.add(lblContrasena);
		panel.add(txtContrasena);
		panel.add(lblDireccion);
		panel.add(txtDireccion);
		panel.add(lblEdad);
		panel.add(txtEdad);
		panel.add(btnRegistro);
		panel.add(lblCodigoPostal);
		panel.add(txtCodigoPostal);

	}
}
