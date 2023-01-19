package Ventanas;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class WelcomePage extends JDialog {

	private JLabel lblNewLabel;

	private Image foto;

	public int getAncho() {
		return super.getWidth();
	}

	public int getAlto() {
		return super.getHeight();
	}

	public WelcomePage(boolean modal) {

		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {

				int ancho = getAncho();
				int alto = getAlto();

				lblNewLabel.setIcon(new ImageIcon(foto.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));

			}
		});

		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setSize(600, 400);
		setModal(modal);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);

		lblNewLabel = new JLabel("");
		try {

			int ancho = super.getWidth();
			int alto = super.getHeight();

			foto = ImageIO.read(new File("fotos/holika.jpg")).getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

			lblNewLabel.setIcon(new ImageIcon(foto));
		} catch (IOException e1) {
		}

		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		setVisible(true);

	}
}
