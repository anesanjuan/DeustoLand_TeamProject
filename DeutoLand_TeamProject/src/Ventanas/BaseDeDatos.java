package Ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDeDatos {
	
	
	private static Connection conexion;
	private static Logger logger = Logger.getLogger( "BaseDatos" );
	
	/** Abre conexión con la base de datos
	 * @param nombreBD	Nombre del fichero de base de datos
	 * @param reiniciaBD	true si se quiere reiniciar la base de datos (se borran sus contenidos si los tuviera y se crean datos por defecto)
	 * @return	true si la conexión ha sido correcta, false en caso contrario
	 */
	public static boolean abrirConexion( String nombreBD, boolean reiniciaBD ) {
		try {
			logger.log( Level.INFO, "Carga de librería org.sqlite.JDBC" );
			Class.forName("org.sqlite.JDBC");  // Carga la clase de BD para sqlite
			logger.log( Level.INFO, "Abriendo conexión con " + nombreBD );
			conexion = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			if (reiniciaBD) {
				Statement statement = conexion.createStatement();
				String sent = "DROP TABLE IF EXISTS festival";
				logger.log( Level.INFO, "Statement: " + sent );
				statement.executeUpdate( sent );
				sent = "CREATE TABLE festival (codF INTEGER PRIMARY KEY AUTOINCREMENT, nombreF char(30), fechaF date, lugarF char(30), descripcionF char(250), precioF dec(3,2));";
				logger.log( Level.INFO, "Statement: " + sent );
				statement.executeUpdate( sent );
				
				sent = "DROP TABLE IF EXISTS artista";
				logger.log( Level.INFO, "Statement: " + sent );
				statement.executeUpdate( sent );
				sent = "CREATE TABLE artista (codA INTEGER PRIMARY KEY AUTOINCREMENT, nombreA char(25), codF int(3) REFERENCES festival (codF), generoA char(25));";
				logger.log( Level.INFO, "Statement: " + sent );
				statement.executeUpdate( sent );
				
				sent = "DROP TABLE IF EXISTS concierto";
				logger.log( Level.INFO, "Statement: " + sent );
				statement.executeUpdate( sent );
				sent = "CREATE TABLE concierto (codC INTEGER PRIMARY KEY AUTOINCREMENT, codA int(3) REFERENCES artista (codA), codF int(3) REFERENCES festival (codF), horaC date, duracionC dec(3,2));";
				logger.log( Level.INFO, "Statement: " + sent );
				statement.executeUpdate( sent );
				try {
					Scanner scanner = new Scanner( BaseDeDatos.class.getResourceAsStream("productos-inic.txt") );
					while (scanner.hasNextLine()) {
						String linea = scanner.nextLine();
						String[] datos = linea.split( "\t" );
						sent = "insert into producto (id, nombre, precio) values (" + datos[0] + ",'" + datos[1] + "'," + datos[2] + ");";
						logger.log( Level.INFO, "Statement: " + sent );
						statement.executeUpdate( sent );
					}
					scanner.close();
					scanner = new Scanner( BaseDeDatos.class.getResourceAsStream("compras-inic.txt") );
					while (scanner.hasNextLine()) {
						String linea = scanner.nextLine();
						String[] datos = linea.split( "\t" );
						sent = "insert into compra (id, idProducto, cliente, fecha, cantidad) values (" + datos[0] + "," + datos[1] + ",'" + datos[2] + "'," + datos[3] + "," + datos[4] + ");";
						logger.log( Level.INFO, "Statement: " + sent );
						statement.executeUpdate( sent );
					}
					scanner.close();
				} catch(Exception e) {
					logger.log( Level.SEVERE, "Excepción", e );
				}
			}
			return true;
		} catch(Exception e) {
			logger.log( Level.SEVERE, "Excepción", e );
			return false;
		}
	}	
	
	/** Cierra la conexión abierta de base de datos ({@link #abrirConexion(String)})
	 */
	public static void cerrarConexion() {
		try {
			logger.log( Level.INFO, "Cerrando conexión" );
			conexion.close();
		} catch (SQLException e) {
			logger.log( Level.SEVERE, "Excepción", e );
		}
	}
	
	

}
