package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DeustoLand.BaseDeDatos;
import DeustoLand.Festival;
import DeustoLand.Gestor;
import DeustoLand.User;

public class vFesti extends JFrame {

	private JPanel principal;
	private JPanel arriba;

	private JPanel pIzq;
	private JPanel pDrch;

	private JPanel pIAr;
	private JPanel pIAb;

	private JPanel pIAb1;
	private JPanel pIAb2;

	private JPanel pd1;
	private JPanel pd2;
	private JPanel pd3;
	private JPanel pd4;

	private JLabel nomFest;
	private JButton bAtras;
	private JButton bIniciarS;

	private JLabel lP;
	private JLabel lPrecio;
	private JButton comprar;

	private JLabel lF;
	private JLabel lFecha;
	private JLabel lL;
	private JLabel lLugar;
	private JLabel lA;
	private JLabel lArtistas;
	private JLabel lD;
	private JLabel lDescripcion;

	public vFesti(Festival festival, User u) {

		getContentPane().setLayout(new GridLayout(2, 1));
		setSize(1050, 800);
		principal = new JPanel();
		arriba = new JPanel();
		pIzq = new JPanel();
		pDrch = new JPanel();
		pIAr = new JPanel();
		pIAb = new JPanel();
		pd1 = new JPanel();
		pd2 = new JPanel();
		pd3 = new JPanel();
		pd4 = new JPanel();
		pIAb1 = new JPanel();
		pIAb2 = new JPanel();

		bAtras = new JButton("Atrás");
		arriba.add(bAtras);
		bAtras.setFont(new Font("Georgia", Font.PLAIN, 16));
		bAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Gestor gn = new Gestor();
				VentanaPrincipal vp = new VentanaPrincipal(gn, null);
				vp.setVisible(true);
				setVisible(false);

			}
		});

		nomFest = new JLabel("Festival" + festival.getNombre());
		nomFest.setFont(new Font("Georgia", Font.PLAIN, 25));
		arriba.add(nomFest);

		if (u == null) {

			bIniciarS = new JButton("Iniciar sesión");
			bIniciarS.setFont(new Font("Georgia", Font.PLAIN, 16));
			arriba.add(bIniciarS);
			bIniciarS.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Gestor gn = new Gestor();
					VentanaInicioSesion vis = new VentanaInicioSesion(gn);
					vis.setVisible(true);
					setVisible(false);

				}

			});

		}

		ImageIcon fotoFest = null;
		try {
			fotoFest = new ImageIcon(ImageIO.read(new File("fotos/" + BaseDeDatos.getFotoFest(festival.getNombre()))));
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabelAjustado fotoFest1 = new JLabelAjustado(fotoFest);
		pIAr.add(fotoFest1);

		lP = new JLabel("Precio:");
		lPrecio = new JLabel(festival.getPrecio() + "€");
		comprar = new JButton("Comprar Entrada");

		lF = new JLabel("Fecha:");
		lFecha = new JLabel("x");
		lL = new JLabel("Lugar:");
		lLugar = new JLabel("x");
		lA = new JLabel("Artistas Invitados:");
		lArtistas = new JLabel("x");
		lD = new JLabel("Descripción:");
		lDescripcion = new JLabel("x");

		arriba.add(bAtras);
		arriba.add(nomFest);

		pIAb1.add(lP);
		pIAb1.add(lPrecio);
		pIAb2.add(comprar);

		pIAb.setLayout(new GridLayout(2, 1));
		pIAb.add(pIAb1);
		pIAb.add(pIAb2);
		pIzq.setLayout(new GridLayout(2, 1));

		pIzq.add(pIAr);
		pIzq.add(pIAb);

		pDrch.setLayout(new GridLayout(4, 1));

		pd1.setLayout(new BorderLayout());
		pd2.setLayout(new BorderLayout());
		pd3.setLayout(new BorderLayout());
		pd4.setLayout(new BorderLayout());
		pd1.add(lF, BorderLayout.WEST);
		pd1.add(lFecha, BorderLayout.CENTER);
		pd2.add(lL, BorderLayout.WEST);
		pd2.add(lLugar, BorderLayout.CENTER);
		pd3.add(lA, BorderLayout.WEST);
		pd3.add(lArtistas, BorderLayout.CENTER);
		pd4.add(lD, BorderLayout.WEST);
		pd4.add(lDescripcion, BorderLayout.CENTER);

		pDrch.add(pd1);
		pDrch.add(pd2);
		pDrch.add(pd3);
		pDrch.add(pd4);

		principal.setLayout(new GridLayout(1, 2));
		principal.add(pIzq);
		principal.add(pDrch);

		getContentPane().setLayout(new BorderLayout());

		getContentPane().add(arriba, new BorderLayout().NORTH);
		getContentPane().add(principal, new BorderLayout().CENTER);

		setVisible(true);
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
