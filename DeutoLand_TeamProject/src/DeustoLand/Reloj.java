package DeustoLand;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reloj implements Runnable {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	String hora;

	public String getHora()
	{
		return hora;
	}
	
	public void run() {

		while (true) {
			// Obtener la hora actual
			hora = sdf.format(new Date());
			// Mostrar la hora
			System.out.println(hora);

			// Duerme el hilo durante 1 segundo
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}