package Ventanas;

import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class VentanaEstadisticas extends JFrame{


	public VentanaEstadisticas() {
		

		setBounds(100, 100, 901, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		
		JLabel lblTitEstadisticas = new JLabel("Estadisticas");
		lblTitEstadisticas.setBounds(410, 6, 99, 16);
		getContentPane().add(lblTitEstadisticas);
	
		JTable tDatos = new JTable();
		DefaultTableModel mDatos = new DefaultTableModel();
		
		Vector<String> cabeceras = new Vector<String>(Arrays.asList("cod Fest", "asistencia total", "num Conciertos"));
		mDatos = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceras );
		tDatos = new JTable(mDatos);
		tDatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tDatos.getColumnModel().getColumn(0).setPreferredWidth(40);
		tDatos.getColumnModel().getColumn(1).setPreferredWidth(30);
		tDatos.getColumnModel().getColumn(2).setPreferredWidth(30);
		tDatos.getColumnModel().getColumn(3).setPreferredWidth(120);
		tDatos.getColumnModel().getColumn(4).setPreferredWidth(120);
		
		add (new JScrollPane(tDatos), BorderLayout.CENTER);
		
		mDatos.addRow(new Object[] {001, 10000, 10});
	}

	
	
}
