package Ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DeustoLand.Festival;
import DeustoLand.Gestor;


public class VentanaPrincipal extends JFrame{

	private final JPanel panel = new JPanel();

	private static final long serialVersionUID = 1L;

	public JFrame frame;
	
	//en el panel de arriba
	private JPanel panelArriba;
	private JLabel lblTitulo;
	private JButton btnEstadisticas;
	private JButton btnInicioSesion;
	private JButton btnRegistro;
	
	
	//en el panel principal
	private JPanel panelPrincipal;
		//en el panel 1
	private JPanel panelFestv1;
	private JButton btnFestv1;
	private JLabel lblLugarFestv1;
	private JLabel lblFechaFestv1;
	private JLabel lblFotoFestv1;
		//en el panel 2
	private JPanel panelFestv2;
	private JButton btnFestv2;
	private JLabel lblLugarFestv2;
	private JLabel lblFechaFestv2;
	private JLabel lblFotoFestv2;
		//en el panel 3
	private JPanel panelFestv3;	
	private JButton btnFestv3;
	private JLabel lblLugarFestv3;
	private JLabel lblFechaFestv3;
	private JLabel lblFotoFestv3;
		//en el panel 4
	private JPanel panelFestv4;
	private JButton btnFestv4;
	private JLabel lblLugarFestv4;
	private JLabel lblFechaFestv4;
	private JLabel lblFotoFestv4;
		//en el panel 5
	private JPanel panelFestv5;
	private JButton btnFestv5;
	private JLabel lblLugarFestv5;
	private JLabel lblFechaFestv5;
	private JLabel lblFotoFestv5;
		//en el panel 6
	private JPanel panelFestv6;
	private JButton btnFestv6;
	private JLabel lblLugarFestv6;
	private JLabel lblFechaFestv6;
	private JLabel lblFotoFestv6;

	
	
	//esto es como inicializar: mete todo dentro
	public VentanaPrincipal() {
		frame = new JFrame();
		frame.setBounds(100, 100, 901, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//panel de arriba
		panelArriba = new JPanel();
		panelArriba.setBounds(6, 6, 889, 47);
		frame.getContentPane().add(panelArriba);
		panelArriba.setLayout(null);
		
		//en el panel de arriba
		lblTitulo = new JLabel("DEUSTOLAND");
		lblTitulo.setBounds(24, 9, 272, 29);
		lblTitulo.setFont(new Font("Palatino", Font.PLAIN, 29));
		panelArriba.add(lblTitulo);
		
		btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.setBounds(378, 9, 117, 29);
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelArriba.add(btnEstadisticas);
		
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(766, 9, 117, 29);
		panelArriba.add(btnRegistro);
		
		btnInicioSesion = new JButton("Iniciar Sesion");
		btnInicioSesion.setBounds(636, 9, 117, 29);
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelArriba.add(btnInicioSesion);
		
		
//PANEL PRINCIAPAL EN EL QUE HAY 6 PANELES
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(6, 54, 889, 527);
		frame.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
//dentro del panel principal
	//panel del primer festival
		panelFestv1 = new JPanel();
		panelFestv1.setBounds(0, 0, 295, 264);
		panelPrincipal.add(panelFestv1);
		panelFestv1.setLayout(null);
		
		lblFotoFestv1 = new JLabel(new ImageIcon("src/Ventanas/festv2.jpg"));
		lblFotoFestv1.setPreferredSize(new Dimension(100, 100));
		lblFotoFestv1.setBounds(6, 6, 283, 195);
		panelFestv1.add(lblFotoFestv1);
		lblFotoFestv1.setIcon(new ImageIcon("/Users/mariaperaleseguiluz/Desktop/Captura de Pantalla 2022-11-09 a las 15.52.42.png"));

		btnFestv1 = new JButton("Tomorrowland");
		btnFestv1.setBounds(6, 213, 117, 29);
		btnFestv1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelFestv1.add(btnFestv1);
		
		lblLugarFestv1 = new JLabel("Belgica");
		lblLugarFestv1.setBounds(156, 213, 61, 16);
		panelFestv1.add(lblLugarFestv1);
	
		lblFechaFestv1 = new JLabel("23 Julio");
		lblFechaFestv1.setBounds(156, 241, 61, 16);
		panelFestv1.add(lblFechaFestv1);
		
		
	//panel del segundo festival
		panelFestv2 = new JPanel();
		panelFestv2.setBounds(296, 0, 295, 264);
		panelPrincipal.add(panelFestv2);
		panelFestv2.setLayout(null);
		
		lblFotoFestv2 = new JLabel("JLabelFoto2");
		lblFotoFestv2.setBounds(6, 6, 283, 196);
		panelFestv2.add(lblFotoFestv2);
		lblFotoFestv2.setIcon(new ImageIcon("/Users/mariaperaleseguiluz/Desktop/Captura de Pantalla 2022-11-09 a las 15.48.18.png"));

		btnFestv2 = new JButton("Coachella");
		btnFestv2.setBounds(6, 213, 117, 29);
		panelFestv2.add(btnFestv2);
		
		lblLugarFestv2 = new JLabel("EEUU");
		lblLugarFestv2.setBounds(156, 213, 61, 16);
		panelFestv2.add(lblLugarFestv2);
		
		lblFechaFestv2 = new JLabel("14 al 24 Abril");
		lblFechaFestv2.setBounds(156, 241, 94, 16);
		panelFestv2.add(lblFechaFestv2);
		
		
	//panel del tercer festival 
		panelFestv3 = new JPanel();
		panelFestv3.setBounds(594, 0, 295, 264);
		panelPrincipal.add(panelFestv3);
		panelFestv3.setLayout(null);
		
		lblFotoFestv3 = new JLabel("JLabelFoto3");
		lblFotoFestv3.setBounds(6, 6, 283, 197);
		panelFestv3.add(lblFotoFestv3);
		lblFotoFestv3.setIcon(new ImageIcon("/Users/mariaperaleseguiluz/Desktop/Captura de Pantalla 2022-11-09 a las 15.42.18.png"));

		btnFestv3 = new JButton("Arenal Sound");
		btnFestv3.setBounds(6, 213, 117, 29);
		btnFestv3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelFestv3.add(btnFestv3);
		
		lblLugarFestv3 = new JLabel("Burriana");
		lblLugarFestv3.setBounds(156, 213, 61, 16);
		panelFestv3.add(lblLugarFestv3);
		
		lblFechaFestv3 = new JLabel("2 al 6 Agosto");
		lblFechaFestv3.setBounds(156, 241, 94, 16);
		panelFestv3.add(lblFechaFestv3);
		
	//panel del cuarto festival
		panelFestv4 = new JPanel();
		panelFestv4.setBounds(0, 263, 295, 264);
		panelPrincipal.add(panelFestv4);
		panelFestv4.setLayout(null);
		
		lblFotoFestv4 = new JLabel("JLabelFoto4");
		lblFotoFestv4.setBounds(6, 6, 283, 195);
		panelFestv4.add(lblFotoFestv4);
		lblFotoFestv4.setIcon(new ImageIcon("/Users/mariaperaleseguiluz/Desktop/Captura de Pantalla 2022-11-09 a las 15.56.54.png"));

		btnFestv4 = new JButton("Mad Cool");
		btnFestv4.setBounds(6, 213, 117, 29);
		btnFestv4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelFestv4.add(btnFestv4);
		
		lblLugarFestv4 = new JLabel("Belgica");
		lblLugarFestv4.setBounds(156, 213, 61, 16);
		panelFestv4.add(lblLugarFestv4);
		
		lblFechaFestv4 = new JLabel("6 al 8 Septiembre");
		lblFechaFestv4.setBounds(156, 241, 109, 16);
		panelFestv4.add(lblFechaFestv4);
		
	//panel del quinto festival
		panelFestv5 = new JPanel();
		panelFestv5.setBounds(296, 263, 295, 264);
		panelPrincipal.add(panelFestv5);
		panelFestv5.setLayout(null);
		
		lblFotoFestv5 = new JLabel("JLabelFoto5");
		lblFotoFestv5.setBounds(6, 6, 283, 195);
		panelFestv5.add(lblFotoFestv5);
		lblFotoFestv5.setIcon(new ImageIcon("/Users/mariaperaleseguiluz/Desktop/Captura de Pantalla 2022-11-09 a las 16.02.07.png"));

		btnFestv5 = new JButton("Hollika");
		btnFestv5.setBounds(6, 213, 117, 29);
		panelFestv5.add(btnFestv5);
		
		lblLugarFestv5 = new JLabel("La Rioja");
		lblLugarFestv5.setBounds(156, 213, 122, 16);
		panelFestv5.add(lblLugarFestv5);
		
		lblFechaFestv5 = new JLabel("6 al 10 Julio");
		lblFechaFestv5.setBounds(156, 241, 109, 16);
		panelFestv5.add(lblFechaFestv5);
		
	//panel del sexto festival
		panelFestv6 = new JPanel();
		panelFestv6.setBounds(594, 263, 295, 264);
		panelPrincipal.add(panelFestv6);
		panelFestv6.setLayout(null);
		
		lblFotoFestv6 = new JLabel("JLabelFoto6");
		lblFotoFestv6.setBounds(6, 6, 283, 195);
		panelFestv6.add(lblFotoFestv6);
		lblFotoFestv6.setIcon(new ImageIcon("/Users/mariaperaleseguiluz/Desktop/Captura de Pantalla 2022-11-09 a las 16.05.50.png"));

		btnFestv6 = new JButton("Bombastic");
		btnFestv6.setBounds(6, 213, 117, 29);
		panelFestv6.add(btnFestv6);
		
		lblLugarFestv6 = new JLabel("Marbella");
		lblLugarFestv6.setBounds(156, 213, 61, 16);
		panelFestv6.add(lblLugarFestv6);
		
		lblFechaFestv6 = new JLabel("21,22 Junio");
		lblFechaFestv6.setBounds(156, 241, 109, 16);
		panelFestv6.add(lblFechaFestv6);
		
		
		ArrayList<Festival> festivales = new ArrayList<>();

		
		panelPrincipal.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int anchoP = panelPrincipal.getPreferredSize().width;
				int largoP = panelPrincipal.getPreferredSize().height;
				int posy=1;
				int posx=1;
				if ( e.getX() > 0 && e.getX() < anchoP && e.getY()>0 && e.getY()<largoP ) {
					if (e.getY() < largoP && e.getY()>(largoP/2)+1) {
						posy = 2;
					} 
					if (e.getX() < largoP && e.getX() > (largoP / 3) * 2) {
						posx = 3;
						
					} else if (e.getX() < (largoP / 3) * 2 && e.getX() > (largoP / 3)+1 ) {
						posx = 2;
					}
					
				}
				int festivalSelec = posy + posx;
				if (festivalSelec == 2) {
					
					
				}
				
			}
		});
		
	}
	
}
