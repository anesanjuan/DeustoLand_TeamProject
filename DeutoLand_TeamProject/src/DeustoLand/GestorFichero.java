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

	
	// ESTA HAY QUE BORRAR?
	
	/**
	 * Este es un método que devuelve una ArrayList de objetos "Cliente". Utilizado
	 * para cargar una lista de objetos de cliente desde un archivo llamado
	 * "clientes.dat" en el sistema de archivos.
	 * 
	 * @return
	 */
	public ArrayList<Cliente> cargarClientes() {

		ArrayList<Cliente> clientes = null;
		try {
			File f = new File("clientes.dat");
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream oos = new ObjectInputStream(fos);
			clientes = (ArrayList<Cliente>) oos.readObject();
			oos.close();
			return clientes;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Este es un método que toma una ArrayList de
	 * objetos "Cliente" como parámetro. Utilizado para guardar una lista de
	 * objetos de cliente en un archivo llamado "clientes.dat" en el sistema de
	 * archivos.
	 * 
	 * @param clientes
	 */
	public void guardarClientes(ArrayList<Cliente> clientes) {
		try {
			File f = new File("clientes.dat");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientes);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
