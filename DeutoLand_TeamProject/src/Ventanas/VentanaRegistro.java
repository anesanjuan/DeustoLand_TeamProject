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
import Excepciones.ClienteRepetidoException;



public class VentanaRegistro extends JFrame {
	
	private final JPanel panel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtEmail;
	private JTextField txtTipocliente;
	private JTextField txtContrasena;
	
	private Gestor gestor;
	
	public VentanaRegistro( Gestor gestor ) {
		
		this.gestor = gestor;
		
		setTitle("Registrarse:");
		
		//inicializar los campos editables
		txtNombre = new JTextField();
		txtNombre.setBounds(190, 33, 96, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(190, 79, 96, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(190, 125, 96, 20);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(190, 172, 96, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		
		txtContrasena = new JTextField();
		txtContrasena.setBounds(190, 219, 96, 20);
		panel.add(txtContrasena);
		txtContrasena.setColumns(10);
		
		
		//inicializar las etiquetas
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(68, 35, 49, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(68, 82, 49, 14);
		panel.add(lblApellido);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(68, 128, 49, 14);
		panel.add(lblDNI);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(68, 175, 49, 14);
		panel.add(lblCorreo);
		
		
		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setBounds(68, 222, 49, 14);
		panel.add(lblContrasena);
		
		//botones
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(337, 229, 89, 23);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String dni = txtDNI.getText();
				String email = txtEmail.getText();
				String contrasena = txtContrasena.getText();
				
				
				try { 
					gestor.insertarCliente( nombre,apellido, dni, email,contrasena);
					//gestor.GuardarClientes();
					Cliente c = BaseDeDatos.getCliente(email, contrasena);
					VentanaPrincipal vp = new VentanaPrincipal( gestor , c);
					vp.setVisible(true);
					dispose();					
				} catch( ClienteRepetidoException ex ) {
				  JOptionPane.showMessageDialog(null,"Ese usuario ya esta registrado!",
				  "ALERTA!", JOptionPane.INFORMATION_MESSAGE); System.exit(0); }
				
			}
			
		});
		
		panel.add(btnRegistro);

		//panel
		panel.setLayout(null);

		
		//ventana
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
	}
	
	
	
	
		
	
}
