package Ventanas;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
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

		getContentPane().setBackground(new Color(237, 245, 244));

		setBounds(100, 100, 901, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel parteArriba = new JPanel();
		parteArriba.setBackground(new Color(237, 245, 244));
		parteArriba.setBounds(0, 0, 890, 47);
		getContentPane().add(parteArriba);
		// parteArriba.setLayout(new GridLayout(1,4));

		JLabel nomFest = new JLabel("Festival " + festival.getNombre());
		nomFest.setFont(new Font("Georgia", Font.PLAIN, 25));
		nomFest.setBounds(10, 11, 299, 36);
		parteArriba.add(nomFest);

		JButton bAtras = new JButton("Volver atrás");

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
		panelPrincipal.setBackground(new Color(237, 245, 244));
		panelPrincipal.setBounds(0, 51, 890, 527);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(new GridLayout(1, 2));

		JPanel principalIzq = new JPanel();
		principalIzq.setBackground(new Color(237, 245, 244));
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
		principalDrch.setBackground(new Color(237, 245, 244));
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

		JTextArea artistasInv = new JTextArea(5, 25);
		String nombres = String.valueOf(listaA.charAt(0));
		for (int i = 1; i < listaA.length(); i++) {
			nombres = nombres + listaA.charAt(i);
			if (i % 64 == 0) {
				nombres = nombres + "\n";
			}
		}
		artistasInv.append(nombres);
		artistasInv.setBackground(new Color(237, 245, 244));
		artistasInv.setEditable(false);
		artistasInv.setFont(new Font("Georgia", Font.PLAIN, 10));
		artistasInv.setBounds(61, 225, 412, 78);
		principalDrch.add(artistasInv);

		JTextArea descripcion = new JTextArea(5, 20);
		String texto = String.valueOf(festival.getDescripcion().charAt(0));
		for(int i=1;i<festival.getDescripcion().length();i++) {
			texto = texto + festival.getDescripcion().charAt(i);
			if(i%64==0) {
				String s = festival.getDescripcion().substring(i+1);
				int pos = s.indexOf(' ');
				if(pos!=-1) {
					String pal = festival.getDescripcion().substring(i+1, i+1+pos);
					texto = texto + pal;
					i += pal.length();
				}
				texto = texto + "\n";
			}
		}
		descripcion.append(texto);
		descripcion.setEditable(false);
		
		descripcion.setBackground(new Color(237, 245, 244));

		descripcion.setFont(new Font("Georgia", Font.PLAIN, 14));
		descripcion.setBounds(10, 340, 491, 171);
		principalDrch.add(descripcion);

		ImageIcon fotoFest = null;
		try {
			fotoFest = new ImageIcon(ImageIO.read(new File("fotos/" + BaseDeDatos.getFotoFest(festival.getNombre()))));
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lFoto = new JLabel();
		lFoto.setBounds(21, 11, 352, 243);
		ImageIcon im = new ImageIcon(
				fotoFest.getImage().getScaledInstance(lFoto.getWidth(), lFoto.getHeight(), Image.SCALE_DEFAULT));
		lFoto.setIcon(im);
		principalIzq.add(lFoto);

		setVisible(true);
		setSize(1000, 1000);

		setLocationRelativeTo(null);
		setResizable(false);

	}

}
