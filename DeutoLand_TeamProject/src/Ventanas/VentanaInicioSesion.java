package Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DeustoLand.GestorLN;



public class VentanaInicioSesion extends JFrame {
	
	private final JPanel panel = new JPanel();
	private JTextField txtCorreo;
	private JPasswordField passwordFieldContraseña;

	private GestorLN gestor;

	public VentanaInicioSesion(GestorLN gestor) {
		setTitle("Inicio de Sesion:");
		this.gestor = gestor;

		
		//etiquetas para los campos de correo y contraseña
		JLabel labelCorreo = new JLabel("Email:");
		labelCorreo.setBounds(29, 37, 89, 14);
		JLabel labelContraseña = new JLabel("Contrasena:");
		labelContraseña.setBounds(29, 108, 89, 14);
		
		//campo editable para introducir el correo
		txtCorreo = new JTextField();
		//ubi
		txtCorreo.setBounds(141, 34, 120, 20);
		txtCorreo.setColumns(10);
		
		//campo editable para introducir la contraseña
		passwordFieldContraseña = new JPasswordField();
		//ubi
		passwordFieldContraseña.setBounds(141, 105, 120, 20);
		
		
		//añadimos los componentes al panel
		panel.setLayout(null);
		panel.add(labelCorreo);
		panel.add(labelContraseña);
		panel.add(txtCorreo);
		panel.add(passwordFieldContraseña);
		
		//botones
		
		//boton login
		JButton btnLogin = new JButton("Iniciar Sesion");
		//ubi y tamaño
		btnLogin.setBounds(155, 150, 156, 20);
		//eventos
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				//se recuperan el correo y contraseña introducidos
				String correo = txtCorreo.getText();
				String contrasena = new String(passwordFieldContraseña.getPassword());
				
				//habria q hacer un gestorNL y comprobar q existen y son correctos para pasar a la siguiente ventana
				boolean r = gestor.comprobarUsuario(correo, contrasena);
				if (r == true) {
					//se abre otra ventana
				} else {
					JOptionPane.showMessageDialog(null, "El usuario o la contrasena son incorrectos.");
				}
			}
			
		});
		//se añade
		panel.add(btnLogin);
		
		//boton registrarse
		JButton btnRegistrarse = new JButton("Registrarse");
		//ubi
		btnRegistrarse.setBounds(180, 215, 135, 23); 
		//eventos
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//al pulsar este boton se abre la ventana de regiustro
				VentanaRegistro vr = new VentanaRegistro(gestor);
				vr.setVisible(true);
				//vr.setModal(true);
			}
		});
		//se añade
		panel.add(btnRegistrarse);
		
		//evento de la venta: cerrar al asalor
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		//ventana
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 286);
		//
		getContentPane().setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//añadir el panel a la ventana
		getContentPane().add(panel, BorderLayout.CENTER);
	}
	

	

	
		
		
	

}
