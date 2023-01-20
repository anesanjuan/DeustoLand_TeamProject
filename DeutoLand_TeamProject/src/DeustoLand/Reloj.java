package DeustoLand;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

public class Reloj extends SwingWorker<Void, Void> {

	private JFrame frame;

	/**
	 * Constructor de la clase
	 * 
	 * @param frame ventana en la que se implementa
	 */
	public Reloj(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Este método es utilizado para actualizar el título de la ventana con la fecha
	 * y hora actual cada segundo.
	 */
	@Override
	protected Void doInBackground() throws Exception {

		while (!isCancelled()) {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String hora = LocalDateTime.now().format(formatter);
			frame.setTitle("Fecha y hora del sistema: " + hora);
			Thread.sleep(1000);

		}

		return null;
	}

}