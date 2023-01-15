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
	
	
	
	public static ArrayList<Tarjeta> cargarTarjetasCredito() {

		ArrayList<Tarjeta> tarjetas = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader("TarjetasCredito.csv"))) {
			String line = reader.readLine();
			String[] fields;

			while ((line = reader.readLine()) != null) {
				fields = line.split(",");
				Tarjeta tarjeta = new Tarjeta(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]));
				tarjetas.add(tarjeta);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return tarjetas;
	}
	
	
	public static boolean comprobarTarjeta (long numTarjeta, int cvv) {
		
		for (Tarjeta tarjeta : GestorFichero.cargarTarjetasCredito()) {
			if (tarjeta.getNumTarjeta() == numTarjeta && tarjeta.getCvv() == cvv) {
				return true;
			} 
		}
		return false;
	}

}
