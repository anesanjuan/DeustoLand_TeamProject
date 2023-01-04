package DeustoLand;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

public class Reloj extends SwingWorker<Void, Void> {
	
	
	private JFrame frame;
	public Reloj (JFrame frame) {
		this.frame = frame;
	}
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