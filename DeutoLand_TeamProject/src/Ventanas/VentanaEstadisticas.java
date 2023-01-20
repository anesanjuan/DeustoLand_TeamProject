package Ventanas;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import DeustoLand.BaseDeDatos;
import DeustoLand.Festival;
import DeustoLand.TipoEntrada;

public class VentanaEstadisticas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfMaxP;
	private JTextField tfMinP;
	private JTextField tfEdadMin;
	private JTextField tfEdadMax;
	private JTable tDatos;
	private DefaultTableModel mDatos;

	private Renderer cellRenderer;

	public VentanaEstadisticas() {

		Festival fest1 = BaseDeDatos.getFestivales().get(0);

		setBounds(100, 100, 901, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		this.setResizable(false);
		JPanel parteArriba = new JPanel();
		Border bordeFestival = BorderFactory.createTitledBorder("Festival");
		parteArriba.setBorder(bordeFestival);
		parteArriba.setBounds(0, 0, 890, 104);
		getContentPane().add(parteArriba);
		parteArriba.setLayout(null);

		JLabel nomFest = new JLabel(fest1.getNombre());
		nomFest.setFont(new Font("Georgia", Font.PLAIN, 21));
		nomFest.setBounds(352, 11, 144, 53);
		parteArriba.add(nomFest);

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

		JPanel panel1 = new JPanel();
		Border bordepanel1 = BorderFactory.createTitledBorder("Datos y Filtros");
		panel1.setBorder(bordepanel1);
		panel1.setBounds(10, 11, 857, 344);
		panelPrincipal.add(panel1);
		panel1.setLayout(null);
		panel1.setVisible(false);

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

		JLabel CTEc = new JLabel("Calculo total entradas Camping:");
		CTEc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CTEc.setBounds(93, 203, 215, 32);
		panel1.add(CTEc);

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

		JLabel lblEdadMin = new JLabel("Edad mínima:");
		lblEdadMin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdadMin.setBounds(447, 189, 119, 32);
		panel1.add(lblEdadMin);

		JLabel lblEdadMax = new JLabel("Edad máxima:");
		lblEdadMax.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdadMax.setBounds(447, 240, 119, 32);
		panel1.add(lblEdadMax);

		tfMaxP = new JTextField();
		tfMaxP.setColumns(10);
		tfMaxP.setBounds(602, 89, 96, 20);
		panel1.add(tfMaxP);

		tfMinP = new JTextField();
		tfMinP.setColumns(10);
		tfMinP.setBounds(602, 143, 96, 20);
		panel1.add(tfMinP);

		tfEdadMin = new JTextField();
		tfEdadMin.setColumns(10);
		tfEdadMin.setBounds(602, 197, 96, 20);
		panel1.add(tfEdadMin);

		tfEdadMax = new JTextField();
		tfEdadMax.setColumns(10);
		tfEdadMax.setBounds(602, 248, 96, 20);
		panel1.add(tfEdadMax);

//___________________________JTable_____________________

		JPanel panelTable = new JPanel();
		panelTable.setBounds(0, 11, 880, 332);
		panelPrincipal.add(panelTable);
		panelTable.setLayout(null);

		Vector<String> cabeceras = new Vector<String>(
				Arrays.asList("Nombre", "DNI", "Edad", "Tipo Entrada", "Precio Entrada", "Precio Total"));
		mDatos = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceras);
		tDatos = new JTable(mDatos);
		cellRenderer = new Renderer();

		tDatos.setDefaultRenderer(Object.class, cellRenderer);

		tDatos.getTableHeader().setReorderingAllowed(false);

		BaseDeDatos.borrarDatos(tDatos);
		BaseDeDatos.insertarDatos(tDatos, nomFest.getText());

		JLabel lblMediaEdad = new JLabel(BaseDeDatos.getMediaEdad(tDatos));
		lblMediaEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMediaEdad.setBounds(194, 53, 84, 32);
		panel1.add(lblMediaEdad);

		JLabel lblCTE = new JLabel(BaseDeDatos.calculoTotalE(tDatos, TipoEntrada.NORMAL));
		lblCTE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCTE.setBounds(253, 99, 84, 32);
		panel1.add(lblCTE);

		JLabel lblCTEvip = new JLabel(BaseDeDatos.calculoTotalE(tDatos, TipoEntrada.VIP));
		lblCTEvip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCTEvip.setBounds(281, 150, 84, 32);
		panel1.add(lblCTEvip);

		JLabel lblCTEc = new JLabel(BaseDeDatos.calculoTotalE(tDatos, TipoEntrada.CONCAMPING));
		lblCTEc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCTEc.setBounds(317, 203, 84, 32);
		panel1.add(lblCTEc);

		JButton bAnterior = new JButton("anterior");
		bAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomFest.setText(BaseDeDatos.FestEstadistica(BaseDeDatos.getFestNom(nomFest.getText()), 0).getNombre());
				BaseDeDatos.borrarDatos(tDatos);
				BaseDeDatos.insertarDatos(tDatos, nomFest.getText());

				lblMediaEdad.setText(BaseDeDatos.getMediaEdad(tDatos));
				lblCTE.setText(BaseDeDatos.calculoTotalE(tDatos, TipoEntrada.NORMAL));
				lblCTEvip.setText(BaseDeDatos.calculoTotalE(tDatos, TipoEntrada.VIP));
				lblCTEc.setText(BaseDeDatos.calculoTotalE(tDatos, TipoEntrada.CONCAMPING));
			}
		});
		bAnterior.setFont(new Font("Georgia", Font.PLAIN, 16));
		bAnterior.setBounds(103, 24, 133, 36);
		parteArriba.add(bAnterior);

		JButton bSiguiente = new JButton("siguiente");
		bSiguiente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nomFest.setText(BaseDeDatos.FestEstadistica(BaseDeDatos.getFestNom(nomFest.getText()), 1).getNombre());
				BaseDeDatos.borrarDatos(tDatos);
				BaseDeDatos.insertarDatos(tDatos, nomFest.getText());

				lblMediaEdad.setText(BaseDeDatos.getMediaEdad(tDatos));
				lblCTE.setText(BaseDeDatos.calculoTotalE(tDatos, TipoEntrada.NORMAL));
				lblCTEvip.setText(BaseDeDatos.calculoTotalE(tDatos, TipoEntrada.VIP));
				lblCTEc.setText(BaseDeDatos.calculoTotalE(tDatos, TipoEntrada.CONCAMPING));
			}
		});

		bSiguiente.setFont(new Font("Georgia", Font.PLAIN, 16));
		bSiguiente.setBounds(617, 24, 144, 36);
		parteArriba.add(bSiguiente);

		tDatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tDatos.getColumnModel().getColumn(0).setPreferredWidth(40);
		tDatos.getColumnModel().getColumn(1).setPreferredWidth(40);
		tDatos.getColumnModel().getColumn(2).setPreferredWidth(20);
		tDatos.getColumnModel().getColumn(3).setPreferredWidth(50);
		tDatos.getColumnModel().getColumn(4).setPreferredWidth(20);

		JScrollPane scroll = new JScrollPane(tDatos);
		scroll.setBounds(112, 31, 637, 266);
		panelTable.add(scroll);
		Border bordepanel12 = BorderFactory.createTitledBorder("Tabla con datos");
		panelTable.setBorder(bordepanel12);

		JButton bEstad = new JButton("Estadisticas numéricas");
		bEstad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelTable.isVisible()) {
					panelTable.setVisible(false);
					panel1.setVisible(true);
				} else {
					panel1.setVisible(false);
					panelTable.setVisible(true);

				}

			}
		});

		bEstad.setFont(new Font("Georgia", Font.PLAIN, 16));
		bEstad.setBounds(304, 68, 226, 36);
		parteArriba.add(bEstad);

		JButton btnNormal = new JButton("Normal");
		btnNormal.setBounds(75, 30, 133, 36);
		panelAbajo.add(btnNormal);
		btnNormal.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnNormal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cellRenderer.setEntrada(TipoEntrada.NORMAL);
				tDatos.repaint();
			}
		});

		JButton btnVip = new JButton("VIP");
		btnVip.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnVip.setBounds(253, 30, 133, 36);
		panelAbajo.add(btnVip);
		btnVip.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cellRenderer.setEntrada(TipoEntrada.VIP);
				tDatos.repaint();
			}
		});

		JButton btnCamping = new JButton("Camping");
		btnCamping.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnCamping.setBounds(438, 30, 133, 36);
		panelAbajo.add(btnCamping);
		btnCamping.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cellRenderer.setEntrada(TipoEntrada.CONCAMPING);
				tDatos.repaint();
			}
		});

		JButton btnFiltrar = new JButton("FILTRAR");
		btnFiltrar.setBounds(530, 296, 89, 23);
		panel1.add(btnFiltrar);
		btnFiltrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cellRenderer.setArray(BaseDeDatos.recalcularTabla(tDatos, tfEdadMin.getText(), tfEdadMax.getText(),
						tfMinP.getText(), tfMaxP.getText()));
				tDatos.repaint();
			}
		});

		setLocationRelativeTo(null);
		setResizable(false);
	}

}
