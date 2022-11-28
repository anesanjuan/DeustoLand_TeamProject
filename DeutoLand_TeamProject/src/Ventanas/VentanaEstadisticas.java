package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaEstadisticas extends JFrame{

	private JFrame frame;

	public VentanaEstadisticas() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 901, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblTitEstadisticas = new JLabel("Estadisticas");
		lblTitEstadisticas.setBounds(233, 6, 99, 16);
		frame.getContentPane().add(lblTitEstadisticas);
	
	}
}
