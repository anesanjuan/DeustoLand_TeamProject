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

import DeustoLand.GestorLN;
import Excepciones.ClienteRepetidoException;



public class VentanaRegistro extends JFrame {
	
	private final JPanel panel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtEmail;
	private JTextField txtTipocliente;
	private JTextField txtContrasena;

	private GestorLN gestor;
	
	public VentanaRegistro(GestorLN gestor ) {
		setTitle("Registrarse:");
		
		//inicializar los campos editables
		txtNombre = new JTextField();
		txtNombre.setBounds(184, 73, 96, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(184, 73, 96, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(184, 73, 96, 20);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(184, 104, 96, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		
		//esto no tiene sentido
		txtTipocliente = new JTextField();
		txtTipocliente.setBounds(184, 104, 96, 20);
		panel.add(txtTipocliente);
		txtTipocliente.setColumns(10);
		//
		
		txtContrasena = new JTextField();
		txtContrasena.setBounds(184, 135, 96, 20);
		panel.add(txtContrasena);
		txtContrasena.setColumns(10);
		
		
		//inicializar las etiquetas
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(61, 73, 89, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Nombre:");
		lblApellido.setBounds(61, 73, 89, 14);
		panel.add(lblApellido);
		
		JLabel lblDNI = new JLabel("Nombre:");
		lblDNI.setBounds(61, 73, 89, 14);
		panel.add(lblDNI);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(61, 104, 96, 14);
		panel.add(lblCorreo);
		
		
		JLabel lblTipoCliente = new JLabel("TipoCliente:"); 
		lblTipoCliente.setBounds(61, 104, 96, 14); 
		panel.add(lblTipoCliente);
		 
		
		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setBounds(61, 135, 96, 14);
		panel.add(lblContrasena);
		
		//botones
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(158, 202, 89, 23);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String dni = txtDNI.getText();
				String email = txtEmail.getText();
				//String nombre = txtNombre.getText();
				String contrasena = txtContrasena.getText();
				
				//no me deja por lo del tipo de Cliente

				/*
				 * try { gestor.insertarCliente( nombre,apellido, dni, email, tipocliente,
				 * contrasena);
				 * 
				 * gestor.GuardarClientes();
				 * 
				 * dispose(); } catch( ClienteRepetidoException ex ) {
				 * JOptionPane.showMessageDialog(null,"Ese usuario ya esta registrado!",
				 * "ALERTA!", JOptionPane.INFORMATION_MESSAGE); System.exit(0); }
				 */
				
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
