package Ventanas;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class WelcomePage extends JDialog {

	private JLabel lblNewLabel;

	private Image foto;

	/**
	 * Metodo que devuelve el ancho del panel de la ventana
	 * 
	 * @return el ancho del panel de la ventana como un entero
	 */
	public int getAncho() {
		return super.getWidth();
	}

	/**
	 * Metodo que devuelve el alto del panel de la ventana
	 * 
	 * @return el alto del panel de la ventana como un entero
	 */
	public int getAlto() {
		return super.getHeight();
	}

	/**
	 * Constructor de la ventana
	 * 
	 * @param modal
	 */
	public WelcomePage(boolean modal) {
		/**
		 * Cuando se cierra la ventana, se cierra la aplicacion.
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}
		});
		/**
		 * Cuando se produce el evento de redimensionamiento del componente, se invoca
		 * este método. La imagen es escalada de acuerdo al ancho y alto obtenidos.
		 */
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {

				int ancho = getAncho();
				int alto = getAlto();

				lblNewLabel.setIcon(new ImageIcon(foto.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));

			}
		});

		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setSize(600, 400);
		setModal(modal);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * Metodo que cierra la ventana cuando se pulsa el boton "Entrar"
			 * 
			 * @param e evento de pulsar el boton
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);

		lblNewLabel = new JLabel("");
		try {

			int ancho = super.getWidth();
			int alto = super.getHeight();

			foto = ImageIO.read(new File("fotos/welcomePage.jpg")).getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

			lblNewLabel.setIcon(new ImageIcon(foto));
		} catch (IOException e1) {
		}

		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		setVisible(true);

	}
}
