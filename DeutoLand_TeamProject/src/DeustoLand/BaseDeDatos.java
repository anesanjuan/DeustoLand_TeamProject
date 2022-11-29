package DeustoLand;

import java.io.File;
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

	private static Connection con;
	private static Logger logger = Logger.getLogger("BaseDatos");
	private static Exception lastError;

	/*
	 * public static Statement abrirConex (String nombreBD) throws SQLException {
	 * 
	 * try { Class.forName("org.sqlite.JDBC"); con =
	 * DriverManager.getConnection("jdbc:sqlite:" + nombreBD ); Statement statement
	 * = con.createStatement(); logger.log(Level.INFO, "Conectada base de datos" +
	 * nombreBD); return statement; } catch (Exception e) { lastError = e;
	 * logger.log( Level.SEVERE, "Excepción", e ); e.printStackTrace(); return
	 * null;
	 * 
	 * } }
	 * 
	 * public static boolean init() { try { abrirConex("BaseDatos.db");
	 * 
	 * Statement statement = con.createStatement(); String sent =
	 * "DROP TABLE IF EXISTS festival"; logger.log( Level.INFO, "Statement: " + sent
	 * ); statement.executeUpdate( sent ); sent =
	 * "CREATE TABLE festival (codF INTEGER PRIMARY KEY AUTOINCREMENT, nombreF char(30), fechaF date, lugarF char(30), descripcionF char(250), precioF dec(3,2), foto char(250))"
	 * ; logger.log( Level.INFO, "Statement: " + sent ); statement.executeUpdate(
	 * sent );
	 * 
	 * sent = "DROP TABLE IF EXISTS artista"; logger.log( Level.INFO, "Statement: "
	 * + sent ); statement.executeUpdate( sent ); sent =
	 * "CREATE TABLE artista (codA INTEGER PRIMARY KEY AUTOINCREMENT, nombreA char(25), codF int(3) REFERENCES festival (codF), generoA char(25))"
	 * ; logger.log( Level.INFO, "Statement: " + sent ); statement.executeUpdate(
	 * sent );
	 * 
	 * sent = "DROP TABLE IF EXISTS concierto"; logger.log( Level.INFO,
	 * "Statement: " + sent ); statement.executeUpdate( sent ); sent =
	 * "CREATE TABLE concierto (codC INTEGER PRIMARY KEY AUTOINCREMENT, codA int(3) REFERENCES artista (codA), codF int(3) REFERENCES festival (codF), horaC date, duracionC dec(3,2))"
	 * ; logger.log( Level.INFO, "Statement: " + sent ); statement.executeUpdate(
	 * sent );
	 * 
	 * return true; } catch(Exception e) { logger.log( Level.SEVERE, "Excepción", e
	 * ); return false; } }
	 * 
	 */

	/**
	 * Abre conexión con la base de datos
	 * 
	 * @param nombreBD   Nombre del fichero de base de datos
	 * @param reiniciaBD true si se quiere reiniciar la base de datos (se borran sus
	 *                   contenidos si los tuviera y se crean datos por defecto)
	 * @return true si la conexión ha sido correcta, false en caso contrario
	 */
	public static boolean abrirConexion(String nombreBD, boolean reiniciaBD) {
		try {
			logger.log(Level.INFO, "Carga de librería org.sqlite.JDBC");
			Class.forName("org.sqlite.JDBC"); // Carga la clase de BD para sqlite
			logger.log(Level.INFO, "Abriendo conexión con " + nombreBD);
			con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
			if (reiniciaBD) {
				Statement statement = con.createStatement();
				String sent = "DROP TABLE IF EXISTS festival";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE festival (codF INTEGER PRIMARY KEY AUTOINCREMENT, nombreF char(30), fechaF date, lugarF char(30), descripcionF char(250), precioF dec(3,2), foto char(250));";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

				sent = "DROP TABLE IF EXISTS artista";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE artista (codA INTEGER PRIMARY KEY AUTOINCREMENT, nombreA char(25), codF int(3) REFERENCES festival (codF), generoA char(25));";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

				sent = "DROP TABLE IF EXISTS concierto";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE concierto (codC INTEGER PRIMARY KEY AUTOINCREMENT, codA int(3) REFERENCES artista (codA), codF int(3) REFERENCES festival (codF), horaC date, duracionC dec(3,2));";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

				// public User(String nombre, String apellido, String dni, String contrasena) {

				sent = "DROP TABLE IF EXISTS admins";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE admins (codA INTEGER PRIMARY KEY AUTOINCREMENT, nombre char(25), apellido char(25) , dni char(25) , contrasena char(25) );";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

				// clientes

			}
			return true;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);
			return false;
		}
	}

	/**
	 * Cierra la conexión abierta de base de datos ({@link #abrirConexion(String)})
	 */
	public static void cerrarConexion() {
		try {
			logger.log(Level.INFO, "Cerrando conexión");
			con.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Excepción", e);
		}
	}

	// operacion para insertar festivales desde la app

	public static boolean insertarFestival(Festival festival) {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			String sent = "insert into festival values ( " + festival.getCodigoF() + ", '" + festival.getNombre()
					+ "' , '" + festival.getFecha() + "' , '" + festival.getLugar() + "' , '"
					+ festival.getDescripcion() + "' , " + festival.getPrecio() + ", '" + festival.getFoto() + "');";
			logger.log(Level.INFO, "Statement: " + sent);
			int insertados = statement.executeUpdate(sent);

			if (insertados != 1)
				return false; // Error en inserción
			// Búsqueda de la fila insertada - para ello hay que recuperar la clave
			// autogenerada. Hay varias maneras, vemos dos diferentes:
			// Se hace utilizando método del propio objeto statement
			ResultSet rrss = statement.getGeneratedKeys(); // Genera un resultset ficticio con las claves generadas del
															// último comando
			rrss.next(); // Avanza a la única fila
			int pk = rrss.getInt(1); // Coge la única columna (la primary key autogenerada)
			festival.setCodigoF(pk);
			return true;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);
			return false;
		}
	}

	public static boolean insertarArtista(Artista artista) {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			String sent = "insert into artista values ( " + artista.getCodigoA() + ", '" + artista.getNombre() + "', '"
					+ artista.getFestival() + "' , '" + artista.getTipogenero() + "' );";
			logger.log(Level.INFO, "Statement: " + sent);
			int insertados = statement.executeUpdate(sent);

			if (insertados != 1)
				return false; // Error en inserción
			// Búsqueda de la fila insertada - para ello hay que recuperar la clave
			// autogenerada. Hay varias maneras, vemos dos diferentes:
			// Se hace utilizando método del propio objeto statement
			ResultSet rrss = statement.getGeneratedKeys(); // Genera un resultset ficticio con las claves generadas del
															// último comando
			rrss.next(); // Avanza a la única fila
			int pk = rrss.getInt(1); // Coge la única columna (la primary key autogenerada)
			artista.setCodigoA(pk);
			return true;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);
			return false;
		}

	}

	public static boolean insertarConcierto(Concierto concierto) {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			String sent = "insert into concierto values ( " + concierto.getCodigoC() + ", '" + concierto.getArtista()
					+ "', '" + concierto.getFestival() + "' , '" + concierto.getHora() + "' , '"
					+ concierto.getDuracion() + "' );";
			logger.log(Level.INFO, "Statement: " + sent);
			int insertados = statement.executeUpdate(sent);

			if (insertados != 1)
				return false; // Error en inserción
			// Búsqueda de la fila insertada - para ello hay que recuperar la clave
			// autogenerada. Hay varias maneras, vemos dos diferentes:
			// Se hace utilizando método del propio objeto statement
			ResultSet rrss = statement.getGeneratedKeys(); // Genera un resultset ficticio con las claves generadas del
															// último comando
			rrss.next(); // Avanza a la única fila
			int pk = rrss.getInt(1); // Coge la única columna (la primary key autogenerada)
			concierto.setCodigoC(pk);
			return true;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);
			return false;
		}

	}

	public static ArrayList<Festival> getFestivales() {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			ArrayList<Festival> ret = new ArrayList<>();
			String sent = "select * from festival";
			logger.log(Level.INFO, "Statement: " + sent);
			ResultSet rs = statement.executeQuery(sent);
			while (rs.next()) {
				int cod = rs.getInt("codigo");
				String nombre = rs.getString("nombre");
				String fecha = rs.getString("fecha");
				String lugar = rs.getString("lugar");
				String descripcion = rs.getString("descripcion");
				double precio = rs.getDouble("precio");
				String foto = rs.getString("foto");
				ret.add(new Festival(cod, nombre, fecha, lugar, descripcion, precio, foto));

			}
			return ret;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}

	}

	public static void insertarConciertos() {
		// TODO Lo hace Mar en su casa

	}

	public static void insertarArtistas() {
		// TODO Lo hace Mar en su casa

	}

	public static void insertarUsuarios() {
		// TODO Auto-generated method stub

		Admin admin = new Admin("admin", "admin", "admin", "admin");

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			String sent = "insert into admins values ( 1 , '" + admin.getNombre() + "', '" + admin.getApellido() + "' , '"
					+ admin.getDni() + "' , '" + admin.getContrasena() + "');";

			logger.log(Level.INFO, "Statement: " + sent);

			statement.executeUpdate(sent);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);

		}
	}

	// este esz para insertar caundo se abre la app
	public static void insertarFestivales() {

		Festival fest2 = new Festival(02, "Coachella", "21-07-2023", "Dubai", "bla bla", 150.7, "");
		Festival fest3 = new Festival(03, "Arenal Sound", "21-07-2023", "Dubai", "bla bla", 150.7, "");
		Festival fest4 = new Festival(04, "Mad Cool", "21-07-2023", "Dubai", "bla bla", 150.7, "");
		Festival fest5 = new Festival(05, "hollika", "21-07-2023", "Dubai", "bla bla", 150.7, "");
		Festival fest6 = new Festival(06, "boombastic", "21-07-2023", "Dubai", "bla bla", 150.7, "");

		ArrayList<Festival> fests = new ArrayList<>();
		fests.add(fest2);
		fests.add(fest3);
		fests.add(fest4);
		fests.add(fest5);
		fests.add(fest6);

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			for (Festival festival : fests) {
				String sent = "insert into festival values ( " + festival.getCodigoF() + ", '" + festival.getNombre()
						+ "' , '" + festival.getFecha() + "' , '" + festival.getLugar() + "' , '"
						+ festival.getDescripcion() + "' , " + festival.getPrecio() + ", '" + festival.getFoto()
						+ "');";

				logger.log(Level.INFO, "Statement: " + sent);

				statement.executeUpdate(sent);

			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);

		}
	}

}
