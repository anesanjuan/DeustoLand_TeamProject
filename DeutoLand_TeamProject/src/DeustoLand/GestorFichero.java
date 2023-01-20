package DeustoLand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestorFichero {



	/**
	 * 
	 * @return
	 */
	public static ArrayList<Tarjeta> cargarTarjetasCredito() {

		ArrayList<Tarjeta> tarjetas = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("TarjetasCredito.csv"))) {
			String line = reader.readLine();
			String[] fields;

			while ((line = reader.readLine()) != null) {
				fields = line.split(",");
				String cvv = fields[2];
				String cvv2 = (String) cvv.subSequence(0, 3);
				Tarjeta tarjeta = new Tarjeta(Long.parseLong(fields[0]), fields[1], Integer.parseInt(cvv2));
				tarjetas.add(tarjeta);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return tarjetas;
	}

	/**
	 * 
	 * @param numTarjeta
	 * @param cvv
	 * @return
	 */
	public static boolean comprobarTarjeta(String numTarjeta, String cvv) {
		long numTarjetaLong = Long.parseLong(numTarjeta);
		int cvvInt = Integer.parseInt(cvv);

		for (Tarjeta tarjeta : GestorFichero.cargarTarjetasCredito()) {
			if (tarjeta.getNumTarjeta() == numTarjetaLong && tarjeta.getCvv() == cvvInt) {
				return true;
			}
		}
		return false;
	}

}
