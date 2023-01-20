package Ventanas;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DeustoLand.Admin;
import DeustoLand.BaseDeDatos;
import DeustoLand.Cliente;
import DeustoLand.Festival;
import DeustoLand.Gestor;
import DeustoLand.Reloj;
import DeustoLand.User;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaPrincipal extends JFrame {

	private static int veces = 0;
	
	// HILO
	private Reloj reloj;

	private static final long serialVersionUID = 1L;

	// en el panel de arriba
	private JPanel panelArriba;
	private JLabel lblTitulo;
	private JButton btnEstadisticas;
	private JButton btnInicioSesion;

	// en el panel principal
	private JPanel panelPrincipal;
	// en el panel 1
	private JPanel panelFestv1;
	private JButton btnFestv1;
	private JLabel lblLugarFestv1;
	private JLabel lblFechaFestv1;

	// en el panel 2
	private JPanel panelFestv2;
	private JButton btnFestv2;
	private JLabel lblLugarFestv2;
	private JLabel lblFechaFestv2;

	// en el panel 3
	private JPanel panelFestv3;
	private JButton btnFestv3;
	private JLabel lblLugarFestv3;
	private JLabel lblFechaFestv3;

	// en el panel 4
	private JPanel panelFestv4;
	private JButton btnFestv4;
	private JLabel lblLugarFestv4;
	private JLabel lblFechaFestv4;

	// en el panel 5
	private JPanel panelFestv5;
	private JButton btnFestv5;
	private JLabel lblLugarFestv5;
	private JLabel lblFechaFestv5;

	// en el panel 6
	private JPanel panelFestv6;
	private JButton btnFestv6;
	private JLabel lblLugarFestv6;
	private JLabel lblFechaFestv6;

	private Gestor gestor;

	// IMPLEMENTAR LA INTERFAZ OBSERVER

	// esto es como inicializar: mete todo dentro
	public VentanaPrincipal(Gestor gestor, User u) {

		// HILO
		reloj = new Reloj(this);
		reloj.execute();

		setBounds(100, 100, 901, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// panel de arriba
		panelArriba = new JPanel();
		panelArriba.setBounds(6, 6, 889, 47);
		getContentPane().add(panelArriba);
		GridBagLayout gbl_panelArriba = new GridBagLayout();
		gbl_panelArriba.columnWidths = new int[] { 272, 82, 117, 141, 117, 0 };
		gbl_panelArriba.rowHeights = new int[] { 29, 0 };
		gbl_panelArriba.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelArriba.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelArriba.setLayout(gbl_panelArriba);

		btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.setVisible(false);
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaEstadisticas ve = new VentanaEstadisticas();
				ve.setVisible(true);
			}
		});

		// en el panel de arriba
		lblTitulo = new JLabel("DEUSTOLAND");
		lblTitulo.setFont(new Font("Palatino", Font.PLAIN, 29));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.fill = GridBagConstraints.BOTH;
		gbc_lblTitulo.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panelArriba.add(lblTitulo, gbc_lblTitulo);
		GridBagConstraints gbc_btnEstadisticas = new GridBagConstraints();
		gbc_btnEstadisticas.anchor = GridBagConstraints.NORTH;
		gbc_btnEstadisticas.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEstadisticas.insets = new Insets(0, 0, 0, 5);
		gbc_btnEstadisticas.gridx = 2;
		gbc_btnEstadisticas.gridy = 0;
		panelArriba.add(btnEstadisticas, gbc_btnEstadisticas);

		btnInicioSesion = new JButton("Iniciar Sesion");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaInicioSesion vs = new VentanaInicioSesion(gestor);
				vs.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnInicioSesion = new GridBagConstraints();
		gbc_btnInicioSesion.anchor = GridBagConstraints.NORTH;
		gbc_btnInicioSesion.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInicioSesion.gridx = 4;
		gbc_btnInicioSesion.gridy = 0;
		panelArriba.add(btnInicioSesion, gbc_btnInicioSesion);

//PANEL PRINCIAPAL EN EL QUE HAY 6 PANELES
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(6, 51, 889, 530);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);

		ArrayList<String> fotosFestv = new ArrayList<String>();
		for (Festival festv : BaseDeDatos.getFestivales()) {
			fotosFestv.add(festv.getFoto());
		}

//dentro del panel principal
		// panel del primer festival
		panelFestv1 = new JPanel();
		panelFestv1.setBounds(0, 0, 295, 264);
		panelPrincipal.add(panelFestv1);
		panelFestv1.setLayout(null);

		btnFestv1 = new JButton("Tomorrowland");
		btnFestv1.setBounds(6, 213, 117, 29);
		btnFestv1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Festival festival : BaseDeDatos.getFestivales()) {
					if (festival.getNombre().equals(btnFestv1.getText())) {
						Festival f = BaseDeDatos.getFestival(festival);
						VentanaFestival vf = new VentanaFestival(f, u);
						vf.setVisible(true);
						setVisible(false);
					}
				}

			}
		});
		panelFestv1.add(btnFestv1);

		lblLugarFestv1 = new JLabel("Belgica");
		lblLugarFestv1.setBounds(156, 213, 61, 16);
		panelFestv1.add(lblLugarFestv1);

		lblFechaFestv1 = new JLabel("23 Julio");
		lblFechaFestv1.setBounds(156, 241, 61, 16);
		panelFestv1.add(lblFechaFestv1);

		// panel del segundo festival
		panelFestv2 = new JPanel();
		panelFestv2.setBounds(296, 0, 295, 264);
		panelPrincipal.add(panelFestv2);
		panelFestv2.setLayout(null);

		btnFestv2 = new JButton("Coachella");
		btnFestv2.setBounds(6, 213, 117, 29);
		btnFestv2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Festival festival : BaseDeDatos.getFestivales()) {
					if (festival.getNombre().equals(btnFestv2.getText())) {
						Festival f = BaseDeDatos.getFestival(festival);
						VentanaFestival vf = new VentanaFestival(f, u);
						vf.setVisible(true);
						setVisible(false);
					}
				}

			}
		});

		panelFestv2.add(btnFestv2);
		lblLugarFestv2 = new JLabel("EEUU");
		lblLugarFestv2.setBounds(156, 213, 61, 16);
		panelFestv2.add(lblLugarFestv2);

		lblFechaFestv2 = new JLabel("14 al 24 Abril");
		lblFechaFestv2.setBounds(156, 241, 94, 16);
		panelFestv2.add(lblFechaFestv2);

		// panel del tercer festival
		panelFestv3 = new JPanel();
		panelFestv3.setBounds(594, 0, 295, 264);
		panelPrincipal.add(panelFestv3);
		panelFestv3.setLayout(null);

		btnFestv3 = new JButton("Arenal Sound");
		btnFestv3.setBounds(6, 213, 117, 29);
		btnFestv3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Festival festival : BaseDeDatos.getFestivales()) {
					if (festival.getNombre().equals(btnFestv3.getText())) {
						Festival f = BaseDeDatos.getFestival(festival);
						VentanaFestival vf = new VentanaFestival(f, u);
						vf.setVisible(true);
						setVisible(false);
					}
				}

			}
		});

		panelFestv3.add(btnFestv3);

		lblLugarFestv3 = new JLabel("Burriana");
		lblLugarFestv3.setBounds(156, 213, 61, 16);
		panelFestv3.add(lblLugarFestv3);

		lblFechaFestv3 = new JLabel("2 al 6 Agosto");
		lblFechaFestv3.setBounds(156, 241, 94, 16);
		panelFestv3.add(lblFechaFestv3);

		// panel del cuarto festival
		panelFestv4 = new JPanel();
		panelFestv4.setBounds(0, 263, 295, 264);
		panelPrincipal.add(panelFestv4);
		panelFestv4.setLayout(null);

		btnFestv4 = new JButton("Mad Cool");
		btnFestv4.setBounds(6, 213, 117, 29);
		btnFestv4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Festival festival : BaseDeDatos.getFestivales()) {
					if (festival.getNombre().equals(btnFestv4.getText())) {
						Festival f = BaseDeDatos.getFestival(festival);
						VentanaFestival vf = new VentanaFestival(f, u);
						vf.setVisible(true);
						setVisible(false);
					}
				}

			}
		});
		panelFestv4.add(btnFestv4);

		lblLugarFestv4 = new JLabel("Belgica");
		lblLugarFestv4.setBounds(156, 213, 61, 16);
		panelFestv4.add(lblLugarFestv4);

		lblFechaFestv4 = new JLabel("6 al 8 Septiembre");
		lblFechaFestv4.setBounds(156, 241, 109, 16);
		panelFestv4.add(lblFechaFestv4);

		// panel del quinto festival
		panelFestv5 = new JPanel();
		panelFestv5.setBounds(296, 263, 295, 264);
		panelPrincipal.add(panelFestv5);
		panelFestv5.setLayout(null);

		btnFestv5 = new JButton("Hollika");
		btnFestv5.setBounds(6, 213, 117, 29);
		btnFestv5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Festival festival : BaseDeDatos.getFestivales()) {
					if (festival.getNombre().equals(btnFestv5.getText())) {
						Festival f = BaseDeDatos.getFestival(festival);
						VentanaFestival vf = new VentanaFestival(f, u);
						vf.setVisible(true);
						setVisible(false);
					}
				}

			}
		});
		panelFestv5.add(btnFestv5);

		lblLugarFestv5 = new JLabel("La Rioja");
		lblLugarFestv5.setBounds(156, 213, 122, 16);
		panelFestv5.add(lblLugarFestv5);

		lblFechaFestv5 = new JLabel("6 al 10 Julio");
		lblFechaFestv5.setBounds(156, 241, 109, 16);
		panelFestv5.add(lblFechaFestv5);

		// panel del sexto festival
		panelFestv6 = new JPanel();
		panelFestv6.setBounds(594, 263, 295, 264);
		panelPrincipal.add(panelFestv6);
		panelFestv6.setLayout(null);

		btnFestv6 = new JButton("Boombastic");
		btnFestv6.setBounds(6, 213, 117, 29);
		btnFestv6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Festival festival : BaseDeDatos.getFestivales()) {
					if (festival.getNombre().equals(btnFestv6.getText())) {
						Festival f = BaseDeDatos.getFestival(festival);
						VentanaFestival vf = new VentanaFestival(f, u);
						vf.setVisible(true);
						setVisible(false);
					}
				}

			}
		});
		panelFestv6.add(btnFestv6);

		lblLugarFestv6 = new JLabel("Marbella");
		lblLugarFestv6.setBounds(156, 213, 61, 16);
		panelFestv6.add(lblLugarFestv6);

		lblFechaFestv6 = new JLabel("21,22 Junio");
		lblFechaFestv6.setBounds(156, 241, 109, 16);
		panelFestv6.add(lblFechaFestv6);

		ImageIcon foto1 = null;
		ImageIcon foto2 = null;
		ImageIcon foto3 = null;
		ImageIcon foto4 = null;
		ImageIcon foto5 = null;
		ImageIcon foto6 = null;

		try {
			foto1 = new ImageIcon(ImageIO.read(new File("fotos/" + BaseDeDatos.getFotoFest(btnFestv1.getText()))));
			foto2 = new ImageIcon(ImageIO.read(new File("fotos/" + BaseDeDatos.getFotoFest(btnFestv2.getText()))));
			foto3 = new ImageIcon(ImageIO.read(new File("fotos/" + BaseDeDatos.getFotoFest(btnFestv3.getText()))));
			foto4 = new ImageIcon(ImageIO.read(new File("fotos/" + BaseDeDatos.getFotoFest(btnFestv4.getText()))));
			foto5 = new ImageIcon(ImageIO.read(new File("fotos/" + BaseDeDatos.getFotoFest(btnFestv5.getText()))));
			foto6 = new ImageIcon(ImageIO.read(new File("fotos/" + BaseDeDatos.getFotoFest(btnFestv6.getText()))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lFoto = new JLabel();
		lFoto.setBounds(6, 6, 283, 195);
		ImageIcon im = new ImageIcon(foto1.getImage().getScaledInstance(lFoto.getWidth(), lFoto.getHeight(), Image.SCALE_DEFAULT));
		lFoto.setIcon(im);
		panelFestv1.add(lFoto);
		
		JLabel lFoto2 = new JLabel();
		lFoto2.setBounds(6, 6, 283, 196);
		ImageIcon im2 = new ImageIcon(foto2.getImage().getScaledInstance(lFoto2.getWidth(), lFoto2.getHeight(), Image.SCALE_DEFAULT));
		lFoto2.setIcon(im2);
		
		panelFestv2.add(lFoto2);

		
		JLabel lFoto3 = new JLabel();
		lFoto3.setBounds(6, 6, 283, 197);
		ImageIcon im3 = new ImageIcon(foto3.getImage().getScaledInstance(lFoto3.getWidth(), lFoto3.getHeight(), Image.SCALE_DEFAULT));
		lFoto3.setIcon(im3);
		panelFestv3.add(lFoto3);

		
		JLabel lFoto4 = new JLabel();
		lFoto4.setBounds(6, 6, 283, 195);
		ImageIcon im4 = new ImageIcon(foto4.getImage().getScaledInstance(lFoto4.getWidth(), lFoto4.getHeight(), Image.SCALE_DEFAULT));
		lFoto4.setIcon(im4);
		panelFestv4.add(lFoto4);

		
		JLabel lFoto5 = new JLabel();
		lFoto5.setBounds(6, 6, 283, 195);
		ImageIcon im5 = new ImageIcon(foto5.getImage().getScaledInstance(lFoto5.getWidth(), lFoto5.getHeight(), Image.SCALE_DEFAULT));
		lFoto5.setIcon(im5);
		panelFestv5.add(lFoto5);

		
		JLabel lFoto6 = new JLabel();
		lFoto6.setBounds(6, 6, 283, 195);
		ImageIcon im6 = new ImageIcon(foto6.getImage().getScaledInstance(lFoto6.getWidth(), lFoto6.getHeight(), Image.SCALE_DEFAULT));
		lFoto6.setIcon(im6);
		panelFestv6.add(lFoto6);

		setVisible(true);

		ArrayList<Festival> festivales = new ArrayList<>();
		panelPrincipal.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int anchoP = panelPrincipal.getPreferredSize().width;
				int largoP = panelPrincipal.getPreferredSize().height;
				int posy = 1;
				int posx = 1;
				if (e.getX() > 0 && e.getX() < anchoP && e.getY() > 0 && e.getY() < largoP) {
					if (e.getY() < largoP && e.getY() > (largoP / 2) + 1) {
						posy = 2;
					}
					if (e.getX() < largoP && e.getX() > (largoP / 3) * 2) {
						posx = 3;

					} else if (e.getX() < (largoP / 3) * 2 && e.getX() > (largoP / 3) + 1) {
						posx = 2;
					}

				}
				int festivalSelec = posy + posx;
				if (festivalSelec == 2) {

				}

			}
		});

		setVisible(true);

		if (u instanceof Admin) {
			btnEstadisticas.setVisible(true);
			btnInicioSesion.setVisible(false);
		} else if (u instanceof Cliente) {
			btnEstadisticas.setVisible(false);
			btnInicioSesion.setVisible(false);
		}

		setLocationRelativeTo(null);

		if( u == null && veces == 0 )
		{
			veces = 1;
			WelcomePage wp = new WelcomePage(true);
		} 
		
		setResizable(false);
	}

	private static class JLabelAjustado extends JLabel {
		private ImageIcon imagen;
		private int tamX;
		private int tamY;

		/**
		 * Crea un jlabel que ajusta una imagen cualquiera con fondo blanco a su tamaño
		 * (a la que ajuste más de las dos escalas, horizontal o vertical)
		 * 
		 * @param imagen Imagen a visualizar en el label
		 */
		public JLabelAjustado(ImageIcon imagen) {
			setImagen(imagen);
		}

		/**
		 * Modifica la imagen
		 * 
		 * @param imagen Nueva imagen a visualizar en el label
		 */
		public void setImagen(ImageIcon imagen) {
			this.imagen = imagen;
			if (imagen == null) {
				tamX = 0;
				tamY = 0;
			} else {
				this.tamX = imagen.getIconWidth();
				this.tamY = imagen.getIconHeight();
			}			
		}

		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g; // El Graphics realmente es Graphics2D
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, getWidth(), getHeight());
			if (imagen != null && tamX > 0 && tamY > 0) {
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				double escalaX = 1.0 * getWidth() / tamX;
				double escalaY = 1.0 * getHeight() / tamY;
				double escala = escalaX;
				int x = 0;
				int y = 0;
				if (escalaY < escala) {
					escala = escalaY;
					x = (int) ((getWidth() - (tamX * escala)) / 2);
				} else {
					y = (int) ((getHeight() - (tamY * escala)) / 2);
				}
				g2.drawImage(imagen.getImage(), x, y, (int) (tamX * escala), (int) (tamY * escala), null);
			}
		}
	}

}
