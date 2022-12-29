package Ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class VentanaEstadisticas extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfMaxP;
	private JTextField tfMinP;
	private JTextField tfNomU;
	private JTextField tfEdadU;

	public VentanaEstadisticas() {
		
		setBounds(100, 100, 901, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JPanel parteArriba = new JPanel();
		Border bordeFestival = BorderFactory.createTitledBorder("Festival");
		parteArriba.setBorder(bordeFestival);
		parteArriba.setBounds(0, 0, 890, 104);
		getContentPane().add(parteArriba);
		parteArriba.setLayout(null);
		
		
		JLabel nomFest = new JLabel("Festival X");
		nomFest.setFont(new Font("Georgia", Font.PLAIN, 30));
		nomFest.setBounds(352, 11, 144, 53);
		parteArriba.add(nomFest);
		
		JButton bAnterior = new JButton("anterior");
		bAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bAnterior.setFont(new Font("Georgia", Font.PLAIN, 16));
		bAnterior.setBounds(103, 24, 133, 36);
		parteArriba.add(bAnterior);
		
		JButton bSiguiente = new JButton("siguiente");
		bSiguiente.setFont(new Font("Georgia", Font.PLAIN, 16));
		bSiguiente.setBounds(617, 24, 144, 36);
		parteArriba.add(bSiguiente);
		
		JButton bEstad = new JButton("Estadisticas numéricas");
		bEstad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		bEstad.setFont(new Font("Georgia", Font.PLAIN, 16));
		bEstad.setBounds(304, 68, 226, 36);
		parteArriba.add(bEstad);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 110, 890, 468);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		
		JPanel panelAbajo = new JPanel();
		Border bordeAbajo = BorderFactory.createTitledBorder("Filtro Entradas");
		panelAbajo.setBorder(bordeAbajo);
		panelAbajo.setBounds(0, 364, 880, 104);
		panelPrincipal.add(panelAbajo);
		panelAbajo.setLayout(null);
		
		JButton btnTodos = new JButton("Todos");
		btnTodos.setBounds(75, 30, 133, 36);
		panelAbajo.add(btnTodos);
		btnTodos.setFont(new Font("Georgia", Font.PLAIN, 16));
		
		JButton btnVip = new JButton("VIP");
		btnVip.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnVip.setBounds(253, 30, 133, 36);
		panelAbajo.add(btnVip);
		
		JButton btnVipCamping = new JButton("VIP + Camping");
		btnVipCamping.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnVipCamping.setBounds(614, 30, 180, 36);
		panelAbajo.add(btnVipCamping);
		
		JButton btnCamping = new JButton("Camping");
		btnCamping.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnCamping.setBounds(438, 30, 133, 36);
		panelAbajo.add(btnCamping);
		
		JPanel panel1 = new JPanel();
		Border bordepanel1 = BorderFactory.createTitledBorder("Datos y Filtros");
		panel1.setBorder(bordepanel1);
		panel1.setBounds(10, 11, 857, 344);
		panelPrincipal.add(panel1);
		panel1.setLayout(null);
		
		JLabel MediaEdad = new JLabel("Media edad:");
		MediaEdad.setBounds(93, 60, 83, 19);
		MediaEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel1.add(MediaEdad);
		
		JLabel CTE = new JLabel("Calculo total entradas:");
		CTE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CTE.setBounds(93, 101, 159, 32);
		panel1.add(CTE);
		
		JLabel CTEvip = new JLabel("Calculo total entradas VIP:");
		CTEvip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CTEvip.setBounds(93, 152, 180, 32);
		panel1.add(CTEvip);
		
		JLabel CTEvipc = new JLabel("Calculo total entradas VIP+C:");
		CTEvipc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CTEvipc.setBounds(93, 259, 201, 32);
		panel1.add(CTEvipc);
		
		JLabel CTEc = new JLabel("Calculo total entradas Camping:");
		CTEc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CTEc.setBounds(93, 203, 215, 32);
		panel1.add(CTEc);
		
		JLabel lblMediaEdad = new JLabel("x");
		lblMediaEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMediaEdad.setBounds(194, 53, 84, 32);
		panel1.add(lblMediaEdad);
		
		JLabel lblCTE = new JLabel("x");
		lblCTE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCTE.setBounds(253, 99, 84, 32);
		panel1.add(lblCTE);
		
		JLabel lblCTEvip = new JLabel("x");
		lblCTEvip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCTEvip.setBounds(281, 150, 84, 32);
		panel1.add(lblCTEvip);
		
		JLabel lblCTEc = new JLabel("x");
		lblCTEc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCTEc.setBounds(317, 203, 84, 32);
		panel1.add(lblCTEc);
		
		JLabel lblCTEvipc = new JLabel("x");
		lblCTEvipc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCTEvipc.setBounds(308, 259, 84, 32);
		panel1.add(lblCTEvipc);
		
		JLabel filtros = new JLabel("FILTROS:");
		filtros.setFont(new Font("Tahoma", Font.PLAIN, 17));
		filtros.setBounds(531, 11, 97, 42);
		panel1.add(filtros);
		
		JLabel lblMaxP = new JLabel("Max Precio:");
		lblMaxP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaxP.setBounds(447, 81, 97, 32);
		panel1.add(lblMaxP);
		
		JLabel lblMinP = new JLabel("Min Precio:");
		lblMinP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMinP.setBounds(447, 135, 97, 32);
		panel1.add(lblMinP);
		
		JLabel lblNomU = new JLabel("Nombre usuario:");
		lblNomU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomU.setBounds(447, 189, 119, 32);
		panel1.add(lblNomU);
		
		JLabel lblEdadU = new JLabel("Edad usuario:");
		lblEdadU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdadU.setBounds(447, 240, 119, 32);
		panel1.add(lblEdadU);
		
		tfMaxP = new JTextField();
		tfMaxP.setColumns(10);
		tfMaxP.setBounds(602, 89, 96, 20);
		panel1.add(tfMaxP);
		
		tfMinP = new JTextField();
		tfMinP.setColumns(10);
		tfMinP.setBounds(602, 143, 96, 20);
		panel1.add(tfMinP);
		
		tfNomU = new JTextField();
		tfNomU.setColumns(10);
		tfNomU.setBounds(602, 197, 96, 20);
		panel1.add(tfNomU);
		
		tfEdadU = new JTextField();
		tfEdadU.setColumns(10);
		tfEdadU.setBounds(602, 248, 96, 20);
		panel1.add(tfEdadU);
		
		JButton btnFiltrar = new JButton("FILTRAR");
		btnFiltrar.setBounds(530, 296, 89, 23);
		panel1.add(btnFiltrar);
		

		/*JTable tDatos = new JTable();
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
		
		mDatos.addRow(new Object[] {001, 10000, 10});*/
	}

	
	
}
