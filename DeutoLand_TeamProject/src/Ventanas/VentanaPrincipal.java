package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DeustoLand.GestorLN;


public class VentanaPrincipal extends JFrame{

	private final JPanel panel = new JPanel();
	private GestorLN gestor;

	//esto es como inicializar: mete todo dentro
	public VentanaPrincipal(GestorLN gestor) {
		//setTitle("Inicio de Sesion:");
		this.gestor = gestor;
		
		//setSize(800,850);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setTitle("DEUSTOLAND");
		//setLocation(100,200);
		//engloba setSize y setLocation
		//setBounds(1 y 2 setLocation3 y 4, ancho y largo)
		//setSize(800,850);
		setBounds(800, 850,1200,800);
		//para centrar la ventansa
		setLocationRelativeTo(null);
				
		//this.getContentPane().setBackground(Color.GRAY);
				
				
		//iniciarComponentes();
		JPanel panelA = new JPanel();
		panelA.setBackground(Color.LIGHT_GRAY);
		this.getContentPane().add(panelA);
		
		panelA.setLayout(null);
		//(separacionmargenizq, separacion con lo de arriba, anchura hacia la derecha, altura )
		panelA.setBounds(0,0,1200,95);
		
		JPanel panel = new JPanel();
		panel.setBounds(800, 850,1200,800);

		//panel.setBackground(Color.BLUE);
		this.getContentPane().add(panel);
		
		panel.setLayout(null);
		
		//TITULO
		JLabel lblTitulo = new JLabel("DEUSTOLAND");
		lblTitulo.setBounds(30,0, 300, 90);
		panelA.add(lblTitulo);
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		
		
		//BOTON ESTADISTICAS
		JButton btnEstadistica = new JButton("Estadisticas");
		btnEstadistica.setBounds(525, 22, 140, 37);
		panelA.add(btnEstadistica);
		btnEstadistica.setFont(new Font("arial", Font.PLAIN, 18));
		//btnEstadistica.setBackground(Color.GRAY);
	
		
		//BOTON REGISTRO
		JButton btnRegsitro = new JButton("Registrarme");
		btnRegsitro.setBounds(900, 22, 140, 37);
		panelA.add(btnRegsitro);
		btnRegsitro.setFont(new Font("arial", Font.PLAIN, 18));
		//btnRegsitro.setBackground(Color.GRAY);

		
		//BOTON INICIO SESION
		JButton btnInicioSesion = new JButton("Iniciar Sesion");
		btnInicioSesion.setBounds(1040, 22, 140, 37);
		panelA.add(btnInicioSesion);
		btnInicioSesion.setFont(new Font("arial", Font.PLAIN, 18));
		//btnInicioSesion.setBackground(Color.GRAY);

		
	
		
		
		//FESTIVAL 1
		JButton btnFestv1Name = new JButton("Tomorrowland");
		btnFestv1Name.setBounds(90,370, 100, 40);
		panel.add(btnFestv1Name);
		btnFestv1Name.setFont(new Font("arial", Font.PLAIN, 13));
		//btnFestv1Name.setBackground(Color.BLUE);
		
		JLabel lblFestv1Fecha = new JLabel("23 JULIO");
		lblFestv1Fecha.setBounds(200,365, 90, 45);
		panel.add(lblFestv1Fecha);
		lblFestv1Fecha.setFont(new Font("arial", Font.PLAIN, 13));
		
		JLabel lblFestv1Lugar = new JLabel("Asturias");
		lblFestv1Lugar.setBounds(200,379, 90, 45);
		panel.add(lblFestv1Lugar);
		lblFestv1Lugar.setFont(new Font("arial", Font.PLAIN, 13));

		//ETIQUETA 2- TIPO IMAGEN
		ImageIcon fotofestv1  = new ImageIcon("festv1.jpg");
		JLabel fotoetiqueta1  = new JLabel();
		fotoetiqueta1.setBounds(44,0,370,470);
		fotoetiqueta1.setIcon(new ImageIcon(fotofestv1.getImage().getScaledInstance(320, 260, Image.SCALE_SMOOTH)));
		panel.add(fotoetiqueta1);
		

		//FESTIVAL 2
		JButton btnFestv2Name = new JButton("Coachella");
		btnFestv2Name.setBounds(500,370, 100, 40);
		panel.add(btnFestv2Name);
		btnFestv2Name.setFont(new Font("arial", Font.PLAIN, 13));
		//btnFestv1Name.setBackground(Color.BLUE);
		
		JLabel lblFestv2Fecha = new JLabel("23 JULIO");
		lblFestv2Fecha.setBounds(610,365, 90, 45);
		panel.add(lblFestv2Fecha);
		lblFestv2Fecha.setFont(new Font("arial", Font.PLAIN, 13));
		
		JLabel lblFestv2Lugar = new JLabel("Asturias");
		lblFestv2Lugar.setBounds(610,379, 90, 45);
		panel.add(lblFestv2Lugar);
		lblFestv2Lugar.setFont(new Font("arial", Font.PLAIN, 13));

		//ARREGLAR
		ImageIcon fotofestv2  = new ImageIcon("festv2.jpg");
		JLabel fotoetiqueta2  = new JLabel();
		fotoetiqueta2.setBounds(450,0,370,470);
		fotoetiqueta2.setIcon(new ImageIcon(fotofestv2.getImage().getScaledInstance(320, 260, Image.SCALE_SMOOTH)));
		panel.add(fotoetiqueta2);
		
		
		
		
		//FESTIVAL 3
		JButton btnFestv3Name = new JButton("Arenal Sound");
		btnFestv3Name.setBounds(890,370, 100, 40);
		panel.add(btnFestv3Name);
		btnFestv3Name.setFont(new Font("arial", Font.PLAIN, 13));
		//btnFestv1Name.setBackground(Color.BLUE);
		
		JLabel lblFestv3Fecha = new JLabel("23 JULIO");
		lblFestv3Fecha.setBounds(1000,365, 90, 45);
		panel.add(lblFestv3Fecha);
		lblFestv3Fecha.setFont(new Font("arial", Font.PLAIN, 13));
		
		JLabel lblFestv3Lugar = new JLabel("Asturias");
		lblFestv3Lugar.setBounds(1000,379, 90, 45);
		panel.add(lblFestv3Lugar);
		lblFestv3Lugar.setFont(new Font("arial", Font.PLAIN, 13));

		//ARREGLAR
		ImageIcon fotofestv3  = new ImageIcon("festv3.jpg");
		JLabel fotoetiqueta3  = new JLabel();
		fotoetiqueta3.setBounds(840,0,370,470);
		fotoetiqueta3.setIcon(new ImageIcon(fotofestv3.getImage().getScaledInstance(320, 260, Image.SCALE_SMOOTH)));
		panel.add(fotoetiqueta3);
		
		
		//FESTIVAL 4
		JButton btnFestv4Name = new JButton("MadCool");
		btnFestv4Name.setBounds(90,714, 100, 40);
		panel.add(btnFestv4Name);
		btnFestv4Name.setFont(new Font("arial", Font.PLAIN, 13));
		//btnFestv1Name.setBackground(Color.BLUE);
		
				
		JLabel lblFestv4Fecha = new JLabel("6-10 JULIO");
		lblFestv4Fecha.setBounds(200,706, 100, 40);
		panel.add(lblFestv4Fecha);
		lblFestv4Fecha.setFont(new Font("arial", Font.PLAIN, 13));
				
		JLabel lblFestv4Lugar = new JLabel("Madrid");
		lblFestv4Lugar.setBounds(200,720, 100, 40);
		panel.add(lblFestv4Lugar);
		lblFestv4Lugar.setFont(new Font("arial", Font.PLAIN, 13));

		//ARREGLAR
		ImageIcon fotofestv4  = new ImageIcon("festv4.jpg");
		JLabel fotoetiqueta4  = new JLabel();
		fotoetiqueta4.setBounds(44,340,370,470);
		fotoetiqueta4.setIcon(new ImageIcon(fotofestv4.getImage().getScaledInstance(320, 260, Image.SCALE_SMOOTH)));
		panel.add(fotoetiqueta4);
				
		
		//FESTIVAL 5
		JButton btnFestv5Name = new JButton("Hollika");
		btnFestv5Name.setBounds(500,714, 100, 40);
		panel.add(btnFestv5Name);
		btnFestv5Name.setFont(new Font("arial", Font.PLAIN, 13));
		//btnFestv1Name.setBackground(Color.BLUE);
		
		JLabel lblFestv5Fecha = new JLabel("28-30 JUNIO");
		lblFestv5Fecha.setBounds(610,706, 100, 40);
		panel.add(lblFestv5Fecha);
		lblFestv5Fecha.setFont(new Font("arial", Font.PLAIN, 13));
						
		JLabel lblFestv5Lugar = new JLabel("Asturias");
		lblFestv5Lugar.setBounds(610,720, 100, 40);
		panel.add(lblFestv5Lugar);
		lblFestv5Lugar.setFont(new Font("arial", Font.PLAIN, 13));
						
		//ARREGLAR
		ImageIcon fotofestv5  = new ImageIcon("festv5.jpg");
		JLabel fotoetiqueta5  = new JLabel();
		fotoetiqueta5.setBounds(450,340,370,470);
		fotoetiqueta5.setIcon(new ImageIcon(fotofestv5.getImage().getScaledInstance(320, 260, Image.SCALE_SMOOTH)));
		panel.add(fotoetiqueta5);		
		
		//FESTIVAL 6
		JButton btnFestv6Name = new JButton("Bombastic");
		btnFestv6Name.setBounds(890,714, 100, 40);
		panel.add(btnFestv6Name);
		btnFestv6Name.setFont(new Font("arial", Font.PLAIN, 13));
		//btnFestv1Name.setBackground(Color.BLUE);
				
						
		JLabel lblFestv6Fecha = new JLabel("23 JULIO");
		lblFestv6Fecha.setBounds(1000,706, 100, 40);
		panel.add(lblFestv6Fecha);
		lblFestv6Fecha.setFont(new Font("arial", Font.PLAIN, 13));
						
		JLabel lblFestv6Lugar = new JLabel("Asturias");
		lblFestv6Lugar.setBounds(1000,720, 100, 40);
		panel.add(lblFestv6Lugar);
		lblFestv6Lugar.setFont(new Font("arial", Font.PLAIN, 13));

						
		//ARREGLAR
		ImageIcon fotofestv6  = new ImageIcon("festv6.jpg");
		JLabel fotoetiqueta6  = new JLabel();
		fotoetiqueta6.setBounds(840,340,370,470);
		fotoetiqueta6.setIcon(new ImageIcon(fotofestv6.getImage().getScaledInstance(320, 260, Image.SCALE_SMOOTH)));
		panel.add(fotoetiqueta6);
		
	}
	
//	public void iniciarComponentes() {
		
		/*
		 * JPanel panelA = new JPanel(); panelA.setBackground(Color.LIGHT_GRAY);
		 * this.getContentPane().add(panelA);
		 * 
		 * panelA.setLayout(null); //(separacionmargenizq, separacion con lo de arriba,
		 * anchura hacia la derecha, altura ) panelA.setBounds(0,0,1200,95);
		 * 
		 * JPanel panel = new JPanel(); panel.setBounds(800, 850,1200,800);
		 * 
		 * //panel.setBackground(Color.BLUE); this.getContentPane().add(panel);
		 * 
		 * panel.setLayout(null);
		 * 
		 * //TITULO JLabel lblTitulo = new JLabel("DEUSTOLAND");
		 * lblTitulo.setBounds(30,0, 300, 90); panelA.add(lblTitulo);
		 * lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		 * 
		 * 
		 * //BOTON ESTADISTICAS JButton btnEstadistica = new JButton("Estadisticas");
		 * btnEstadistica.setBounds(525, 22, 140, 37); panelA.add(btnEstadistica);
		 * btnEstadistica.setFont(new Font("arial", Font.PLAIN, 18));
		 * //btnEstadistica.setBackground(Color.GRAY);
		 * 
		 * 
		 * //BOTON REGISTRO JButton btnRegsitro = new JButton("Registrarme");
		 * btnRegsitro.setBounds(900, 22, 140, 37); panelA.add(btnRegsitro);
		 * btnRegsitro.setFont(new Font("arial", Font.PLAIN, 18));
		 * //btnRegsitro.setBackground(Color.GRAY);
		 * 
		 * 
		 * //BOTON INICIO SESION JButton btnInicioSesion = new
		 * JButton("Iniciar Sesion"); btnInicioSesion.setBounds(1040, 22, 140, 37);
		 * panelA.add(btnInicioSesion); btnInicioSesion.setFont(new Font("arial",
		 * Font.PLAIN, 18)); //btnInicioSesion.setBackground(Color.GRAY);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * //FESTIVAL 1 JButton btnFestv1Name = new JButton("Tomorrowland");
		 * btnFestv1Name.setBounds(90,370, 100, 40); panel.add(btnFestv1Name);
		 * btnFestv1Name.setFont(new Font("arial", Font.PLAIN, 13));
		 * //btnFestv1Name.setBackground(Color.BLUE);
		 * 
		 * JLabel lblFestv1Fecha = new JLabel("23 JULIO");
		 * lblFestv1Fecha.setBounds(200,365, 90, 45); panel.add(lblFestv1Fecha);
		 * lblFestv1Fecha.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * JLabel lblFestv1Lugar = new JLabel("Asturias");
		 * lblFestv1Lugar.setBounds(200,379, 90, 45); panel.add(lblFestv1Lugar);
		 * lblFestv1Lugar.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * //ETIQUETA 2- TIPO IMAGEN ImageIcon fotofestv1 = new ImageIcon("festv1.jpg");
		 * JLabel fotoetiqueta1 = new JLabel(); fotoetiqueta1.setBounds(44,0,370,470);
		 * fotoetiqueta1.setIcon(new
		 * ImageIcon(fotofestv1.getImage().getScaledInstance(320, 260,
		 * Image.SCALE_SMOOTH))); panel.add(fotoetiqueta1);
		 * 
		 * 
		 * //FESTIVAL 2 JButton btnFestv2Name = new JButton("Coachella");
		 * btnFestv2Name.setBounds(500,370, 100, 40); panel.add(btnFestv2Name);
		 * btnFestv2Name.setFont(new Font("arial", Font.PLAIN, 13));
		 * //btnFestv1Name.setBackground(Color.BLUE);
		 * 
		 * JLabel lblFestv2Fecha = new JLabel("23 JULIO");
		 * lblFestv2Fecha.setBounds(610,365, 90, 45); panel.add(lblFestv2Fecha);
		 * lblFestv2Fecha.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * JLabel lblFestv2Lugar = new JLabel("Asturias");
		 * lblFestv2Lugar.setBounds(610,379, 90, 45); panel.add(lblFestv2Lugar);
		 * lblFestv2Lugar.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * //ARREGLAR ImageIcon fotofestv2 = new ImageIcon("festv2.jpg"); JLabel
		 * fotoetiqueta2 = new JLabel(); fotoetiqueta2.setBounds(450,0,370,470);
		 * fotoetiqueta2.setIcon(new
		 * ImageIcon(fotofestv2.getImage().getScaledInstance(320, 260,
		 * Image.SCALE_SMOOTH))); panel.add(fotoetiqueta2);
		 * 
		 * 
		 * 
		 * 
		 * //FESTIVAL 3 JButton btnFestv3Name = new JButton("Arenal Sound");
		 * btnFestv3Name.setBounds(890,370, 100, 40); panel.add(btnFestv3Name);
		 * btnFestv3Name.setFont(new Font("arial", Font.PLAIN, 13));
		 * //btnFestv1Name.setBackground(Color.BLUE);
		 * 
		 * JLabel lblFestv3Fecha = new JLabel("23 JULIO");
		 * lblFestv3Fecha.setBounds(1000,365, 90, 45); panel.add(lblFestv3Fecha);
		 * lblFestv3Fecha.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * JLabel lblFestv3Lugar = new JLabel("Asturias");
		 * lblFestv3Lugar.setBounds(1000,379, 90, 45); panel.add(lblFestv3Lugar);
		 * lblFestv3Lugar.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * //ARREGLAR ImageIcon fotofestv3 = new ImageIcon("festv3.jpg"); JLabel
		 * fotoetiqueta3 = new JLabel(); fotoetiqueta3.setBounds(840,0,370,470);
		 * fotoetiqueta3.setIcon(new
		 * ImageIcon(fotofestv3.getImage().getScaledInstance(320, 260,
		 * Image.SCALE_SMOOTH))); panel.add(fotoetiqueta3);
		 * 
		 * 
		 * //FESTIVAL 4 JButton btnFestv4Name = new JButton("MadCool");
		 * btnFestv4Name.setBounds(90,714, 100, 40); panel.add(btnFestv4Name);
		 * btnFestv4Name.setFont(new Font("arial", Font.PLAIN, 13));
		 * //btnFestv1Name.setBackground(Color.BLUE);
		 * 
		 * 
		 * JLabel lblFestv4Fecha = new JLabel("6-10 JULIO");
		 * lblFestv4Fecha.setBounds(200,706, 100, 40); panel.add(lblFestv4Fecha);
		 * lblFestv4Fecha.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * JLabel lblFestv4Lugar = new JLabel("Madrid");
		 * lblFestv4Lugar.setBounds(200,720, 100, 40); panel.add(lblFestv4Lugar);
		 * lblFestv4Lugar.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * //ARREGLAR ImageIcon fotofestv4 = new ImageIcon("festv4.jpg"); JLabel
		 * fotoetiqueta4 = new JLabel(); fotoetiqueta4.setBounds(44,340,370,470);
		 * fotoetiqueta4.setIcon(new
		 * ImageIcon(fotofestv4.getImage().getScaledInstance(320, 260,
		 * Image.SCALE_SMOOTH))); panel.add(fotoetiqueta4);
		 * 
		 * 
		 * //FESTIVAL 5 JButton btnFestv5Name = new JButton("Hollika");
		 * btnFestv5Name.setBounds(500,714, 100, 40); panel.add(btnFestv5Name);
		 * btnFestv5Name.setFont(new Font("arial", Font.PLAIN, 13));
		 * //btnFestv1Name.setBackground(Color.BLUE);
		 * 
		 * JLabel lblFestv5Fecha = new JLabel("28-30 JUNIO");
		 * lblFestv5Fecha.setBounds(610,706, 100, 40); panel.add(lblFestv5Fecha);
		 * lblFestv5Fecha.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * JLabel lblFestv5Lugar = new JLabel("Asturias");
		 * lblFestv5Lugar.setBounds(610,720, 100, 40); panel.add(lblFestv5Lugar);
		 * lblFestv5Lugar.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * //ARREGLAR ImageIcon fotofestv5 = new ImageIcon("festv5.jpg"); JLabel
		 * fotoetiqueta5 = new JLabel(); fotoetiqueta5.setBounds(450,340,370,470);
		 * fotoetiqueta5.setIcon(new
		 * ImageIcon(fotofestv5.getImage().getScaledInstance(320, 260,
		 * Image.SCALE_SMOOTH))); panel.add(fotoetiqueta5);
		 * 
		 * //FESTIVAL 6 JButton btnFestv6Name = new JButton("Bombastic");
		 * btnFestv6Name.setBounds(890,714, 100, 40); panel.add(btnFestv6Name);
		 * btnFestv6Name.setFont(new Font("arial", Font.PLAIN, 13));
		 * //btnFestv1Name.setBackground(Color.BLUE);
		 * 
		 * 
		 * JLabel lblFestv6Fecha = new JLabel("23 JULIO");
		 * lblFestv6Fecha.setBounds(1000,706, 100, 40); panel.add(lblFestv6Fecha);
		 * lblFestv6Fecha.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * JLabel lblFestv6Lugar = new JLabel("Asturias");
		 * lblFestv6Lugar.setBounds(1000,720, 100, 40); panel.add(lblFestv6Lugar);
		 * lblFestv6Lugar.setFont(new Font("arial", Font.PLAIN, 13));
		 * 
		 * 
		 * //ARREGLAR ImageIcon fotofestv6 = new ImageIcon("festv6.jpg"); JLabel
		 * fotoetiqueta6 = new JLabel(); fotoetiqueta6.setBounds(840,340,370,470);
		 * fotoetiqueta6.setIcon(new
		 * ImageIcon(fotofestv6.getImage().getScaledInstance(320, 260,
		 * Image.SCALE_SMOOTH))); panel.add(fotoetiqueta6);
		 */
	
	//}
	
}
