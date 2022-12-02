package Ventanas;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DeustoLand.Artista;
import DeustoLand.Concierto;
import DeustoLand.Festival;

public class VentanaFestival extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	
	public VentanaFestival(Festival festival) {
		
		setBounds(100, 100, 901, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel parteArriba = new JPanel();
		parteArriba.setBounds(0, 0, 890, 47);
		getContentPane().add(parteArriba);
		parteArriba.setLayout(null);
		
		JLabel nomFest = new JLabel("Festival" + festival.getNombre());
		nomFest.setFont(new Font("Georgia", Font.PLAIN, 30));
		nomFest.setBounds(10, 11, 299, 36);
		parteArriba.add(nomFest);
		
		JButton bAtras = new JButton("volver atrás");
		bAtras.setFont(new Font("Georgia", Font.PLAIN, 16));
		bAtras.setBounds(387, 11, 133, 36);
		parteArriba.add(bAtras);
		
		JButton bRegistro = new JButton("registrarme");
		bRegistro.setFont(new Font("Georgia", Font.PLAIN, 16));
		bRegistro.setBounds(545, 11, 144, 36);
		parteArriba.add(bRegistro);
		
		JButton bInicioSesion = new JButton("iniciar sesión");
		bInicioSesion.setFont(new Font("Georgia", Font.PLAIN, 16));
		bInicioSesion.setBounds(716, 11, 144, 36);
		parteArriba.add(bInicioSesion);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 51, 890, 527);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
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
			public void actionPerformed(ActionEvent e) {
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
		
		JLabel tituloArtistasInv = new JLabel("Aristas Invitados:");
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
		for (Concierto con: festival.getListaConciertos()) {
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
		descripcion.setFont(new Font("Georgia", Font.PLAIN, 20));
		descripcion.setBounds(61, 361, 412, 131);
		principalDrch.add(descripcion);
		setVisible(true);
		setSize(1000,1000);
		
		
	}
	
	

	
}
