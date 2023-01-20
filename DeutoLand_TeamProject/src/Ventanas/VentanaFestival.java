package Ventanas;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import DeustoLand.BaseDeDatos;
import DeustoLand.Concierto;
import DeustoLand.Festival;
import DeustoLand.Gestor;
import DeustoLand.User;

public class VentanaFestival extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton bInicioSesion;

	public VentanaFestival(Festival festival, User u) {

		setBounds(100, 100, 901, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel parteArriba = new JPanel();
		parteArriba.setBounds(0, 0, 890, 47);
		getContentPane().add(parteArriba);
		// parteArriba.setLayout(new GridLayout(1,4));

		JLabel nomFest = new JLabel("Festival " + festival.getNombre());
		nomFest.setFont(new Font("Georgia", Font.PLAIN, 25));
		nomFest.setBounds(10, 11, 299, 36);
		parteArriba.add(nomFest);

		JButton bAtras = new JButton("volver atrás");
		
		bAtras.setFont(new Font("Georgia", Font.PLAIN, 16));
		bAtras.setBounds(387, 11, 133, 36);
		parteArriba.add(bAtras);
		bAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Gestor gn = new Gestor();
				VentanaPrincipal vp = new VentanaPrincipal(gn, null);
				vp.setVisible(true);
				setVisible(false);
				
			}
		});

		if (u == null) {

			bInicioSesion = new JButton("Iniciar sesión");
			bInicioSesion.setFont(new Font("Georgia", Font.PLAIN, 16));
			bInicioSesion.setBounds(716, 11, 144, 36);
			parteArriba.add(bInicioSesion);
			bInicioSesion.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Gestor gn = new Gestor();
					VentanaInicioSesion vis = new VentanaInicioSesion(gn);
					vis.setVisible(true);
					setVisible(false);

				}

			});

		}

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 51, 890, 527);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(new GridLayout(1, 2));

		JPanel principalIzq = new JPanel();
		principalIzq.setBounds(0, 5, 375, 522);
		panelPrincipal.add(principalIzq);
		principalIzq.setLayout(null);

		JLabel tituloPrecio = new JLabel("Precio:");
		tituloPrecio.setFont(new Font("Georgia", Font.PLAIN, 20));
		tituloPrecio.setBounds(22, 270, 75, 42);
		principalIzq.add(tituloPrecio);

		JButton bComprarEnt = new JButton("Comprar Entrada");
		bComprarEnt.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				if (u == null) {
					JOptionPane.showMessageDialog(null,
							"Para poder acceder a la compra de entradas es necesario Registrarse o Iniciar Sesión");
				} else {
					VentanaCompra vc = new VentanaCompra(festival, u);
					vc.setVisible(true);
					setVisible(false);
				}

			}
		});
		bComprarEnt.setFont(new Font("Georgia", Font.PLAIN, 16));
		bComprarEnt.setBounds(101, 380, 167, 36);
		principalIzq.add(bComprarEnt);

		JLabel precio = new JLabel(festival.getPrecio() + "€");
		precio.setFont(new Font("Georgia", Font.PLAIN, 20));
		precio.setBounds(114, 270, 128, 42);
		principalIzq.add(precio);

		JPanel principalDrch = new JPanel();
		principalDrch.setBounds(379, 5, 511, 522);
		panelPrincipal.add(principalDrch);
		principalDrch.setLayout(null);

		JLabel tituloFecha = new JLabel("Fecha:");
		tituloFecha.setFont(new Font("Georgia", Font.PLAIN, 20));
		tituloFecha.setBounds(61, 78, 75, 42);
		principalDrch.add(tituloFecha);

		JLabel tituloLugar = new JLabel("Lugar:");
		tituloLugar.setFont(new Font("Georgia", Font.PLAIN, 20));
		tituloLugar.setBounds(61, 132, 75, 42);
		principalDrch.add(tituloLugar);

		JLabel tituloArtistasInv = new JLabel("Artistas Invitados:");
		tituloArtistasInv.setFont(new Font("Georgia", Font.PLAIN, 20));
		tituloArtistasInv.setBounds(61, 185, 164, 42);
		principalDrch.add(tituloArtistasInv);

		JLabel tituloDescripcion = new JLabel("Descripción:");
		tituloDescripcion.setFont(new Font("Georgia", Font.PLAIN, 20));
		tituloDescripcion.setBounds(61, 307, 121, 42);
		principalDrch.add(tituloDescripcion);

		JLabel fecha = new JLabel(festival.getFecha());
		fecha.setFont(new Font("Georgia", Font.PLAIN, 20));
		fecha.setBounds(146, 78, 327, 42);
		principalDrch.add(fecha);

		JLabel lugar = new JLabel(festival.getLugar());
		lugar.setFont(new Font("Georgia", Font.PLAIN, 20));
		lugar.setBounds(150, 132, 323, 42);
		principalDrch.add(lugar);

		String listaA = "";
		for (Concierto con : festival.getListaConciertos()) {
			String artista = con.getArtista().getNombre();
			listaA = listaA + "," + artista;
		}

		JLabel artistasInv = new JLabel(listaA);
		artistasInv.setVerticalAlignment(SwingConstants.TOP);
		artistasInv.setFont(new Font("Georgia", Font.PLAIN, 20));
		artistasInv.setBounds(61, 225, 412, 78);
		principalDrch.add(artistasInv);

		JLabel descripcion = new JLabel(festival.getDescripcion());
		descripcion.setVerticalAlignment(SwingConstants.TOP);
		descripcion.setFont(new Font("Georgia", Font.PLAIN, 14));
		descripcion.setBounds(10, 340, 491, 171);
		principalDrch.add(descripcion);

		ImageIcon fotoFest = null;
		try {
			fotoFest = new ImageIcon(ImageIO.read(new File("fotos/" + BaseDeDatos.getFotoFest(festival.getNombre()))));
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabelAjustado fotoFest1 = new JLabelAjustado(fotoFest);
		fotoFest1.setBounds(21, 11, 352, 243);
		principalIzq.add(fotoFest1);

		setVisible(true);
		setSize(1000, 1000);
		
		setLocationRelativeTo(null);
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
