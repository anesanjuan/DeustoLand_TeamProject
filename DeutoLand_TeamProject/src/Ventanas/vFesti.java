package Ventanas;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class vFesti extends JFrame{
	
	private JPanel principal;
	private JPanel arriba;
	
	private JPanel pIzq;
	private JPanel pDrch;
	
	private JPanel pIAr;
	private JPanel pIAb;
	
	private JPanel pd1;
	private JPanel pd2;
	private JPanel pd3;
	private JPanel pd4;
	
	private JPanel pVacio;
	private JPanel pNoVacio;
	
	private JLabel nomFest;
	private JButton bAtras;
	private JButton bIniciarS;
	
	private JButton foto;
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
	
	public static void main(String[] args) {
		vFesti v = new vFesti();
		v.setVisible(true);
	}
	
	public vFesti() {
		
		getContentPane().setLayout(new GridLayout(2,1));
		setSize(1050,800);
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
		pVacio = new JPanel();
		pNoVacio = new JPanel();
		
		nomFest = new JLabel("x");
		bAtras = new JButton("Atrás");
		bIniciarS = new JButton("Iniciar Sesión");
		
		foto = new JButton("aqui va la foto");
		lP = new JLabel("Precio:");
		lPrecio = new JLabel("x");
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
		arriba.add(bIniciarS);
		
		pIzq.setLayout(new GridLayout(2,1));
		
		pIAr.add(foto);
		pIAb.add(lP);
		pIAb.add(lPrecio);
		pIAb.add(comprar);
		
		pIzq.add(pIAr);
		pIzq.add(pIAb);
		
		pDrch.setLayout(new GridLayout(4,1));
		
		pd1.add(lF);
		pd1.add(lFecha);
		pd2.add(lL);
		pd2.add(lLugar);
		pd3.add(lA);
		pd3.add(lArtistas);
		pd4.add(lD);
		pd4.add(lDescripcion);
		
		pDrch.add(pd1);
		pDrch.add(pd2);
		pDrch.add(pd3);
		pDrch.add(pd4);
		
		pNoVacio.setLayout(new GridLayout(1,2));
		pNoVacio.add(pIzq);
		pNoVacio.add(pDrch);
		
		principal.setLayout(new GridLayout(2,1));
		principal.setLayout(new BorderLayout());
		principal.add(pVacio, new BorderLayout().NORTH);
		principal.add(pNoVacio, new BorderLayout().CENTER);
	
		getContentPane().setLayout(new BorderLayout());
		

		getContentPane().add(arriba, new BorderLayout().NORTH);
		getContentPane().add(principal, new BorderLayout().CENTER);
		
		setVisible(true);
	}
	
}

