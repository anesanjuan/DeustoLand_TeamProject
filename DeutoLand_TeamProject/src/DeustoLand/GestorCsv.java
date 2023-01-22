package DeustoLand;

import java.io.BufferedReader;

import java.io.FileReader;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorCsv {

	/**
	 * Método para cargar las tarjetas de crédito disponibles en el CSV
	 * @return
	 */
	
	public static HashMap<Integer ,Tarjeta> cargarTarjetasCredito() {

		HashMap<Integer, Tarjeta> tarjetas = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("TarjetasCredito.csv"))) {
			String line = reader.readLine();
			String[] fields;

			while ((line = reader.readLine()) != null) {
				fields = line.split(",");
				String cvv = fields[2];
				String cvv2 = (String) cvv.subSequence(0, 3);
				Tarjeta tarjeta = new Tarjeta(Long.parseLong(fields[0]), fields[1], Integer.parseInt(cvv2));
				tarjetas.put(tarjeta.getCvv(), tarjeta);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return tarjetas;
	}

	/**
	 * Comprueba que la tarjeta exista en el CSV
	 * @param numTarjeta el número de tarjeta
	 * @param cvv el CVV
	 * @return
	 */
	public static boolean comprobarTarjeta(String numTarjeta, String cvv) {
		long numTarjetaLong = Long.parseLong(numTarjeta);
		int cvvInt = Integer.parseInt(cvv);

		for (Tarjeta tarjeta : GestorCsv.cargarTarjetasCredito().values()) {
			if (tarjeta.getNumTarjeta() == numTarjetaLong && tarjeta.getCvv() == cvvInt) {
				return true;
			}
		}
		return false;
	}

}
