package DeustoLand;

import java.beans.beancontext.BeanContextContainerProxy;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase de gestion de una base de datos del sistema de festivales???
 * 
 */
public class BaseDeDatos {

	private static Connection con;
	private static Logger logger = Logger.getLogger("BaseDatos");
	private static Exception lastError;


	/**
	 * Abre conexión con la base de datos
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
				sent = "CREATE TABLE festival (codF INTEGER PRIMARY KEY, nombreF char(30), fechaF date, lugarF char(30), descripcionF char(250), precioF dec(3,2), foto char(250));";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

				sent = "DROP TABLE IF EXISTS artista";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE artista (codA INTEGER PRIMARY KEY AUTOINCREMENT, nombreA char(25), generoA char(25));";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

				sent = "DROP TABLE IF EXISTS concierto";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE concierto (codC INTEGER PRIMARY KEY AUTOINCREMENT, codA int(3) REFERENCES artista (codA), horaC date, duracionC dec(3,2), codF int(3) REFERENCES festival (codF));";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);


				sent = "DROP TABLE IF EXISTS admins";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE admins (codA INTEGER PRIMARY KEY AUTOINCREMENT, nombre char(25), apellido char(25) , dni char(25) , contrasena char(25) );";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

				
				sent = "DROP TABLE IF EXISTS clientes";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE clientes (codC INTEGER PRIMARY KEY AUTOINCREMENT, nombre char(25), apellido char(25) , dni char(25) , direccion char(25), edad int(3), correo char(25), contrasena char(25) );";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

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

	///////////////////////////////////////////////////////////////7
	// operacion para insertar festivales desde la app

	/**
	 * Insertar un festival en la base de datos abierta (debe abrirse previamente con 
	 * 		{@link #abrirConexion(String, boolean)}
	 * Actualiza el codigo del festival insertado(ESTO NO LO TENGO CLARO SI HAY Q PONER)
	 * @param festival Festival a insertar
	 * @return true si la insercion es correcta, false en caso contrario
	 */
	public static boolean insertarFestival(Festival festival) {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			String sent = "insert into festival values ( '" + festival.getNombre()
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

	/**
	 * Insertar un festival en la base de datos abierta (debe abrirse previamente con 
	 * 		{@link #abrirConexion(String, boolean)}
	 * @param artista Artista a insertar
	 * @return true si la insercion es correcta, false en caso contrario
	 */
	public static boolean insertarArtista(Artista artista) {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			String sent = "insert into artista values ( '" + artista.getNombre() + "', '" + artista.getTipogenero() + "' );";
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
 
	/**
	 * Inserta un concierto en la base de datos abierta (debe abrirse previamente con 
	 * 		{@link #abrirConexion(String, boolean)}
	 * @param concierto Concierto a insertar
	 * @return true si la insercion es correcta, false en caso contrario
	 */
	public static boolean insertarConcierto(Concierto concierto) {
		try (Statement statement = con.createStatement()) {
			String sent = "insert into concierto values ( " + concierto.getArtista()
					+ ", " + concierto.getHora() + " , "
					+ concierto.getDuracion() +  " , "
							+ concierto.getFestival() + " );";
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

	/**
	 * Lee los festivales de la conexion de base de datos abierta (debe abrirse previamente con 
	 * 		{@link #abrirConexion(String, boolean)}
	 * @return Lista completa de festivales, vacia si no hay ninguna, null si existe algun error
	 */
	public static ArrayList<Festival> getFestivales() {
		ArrayList<Festival> ret = new ArrayList<>();
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			String sent = "select * from festival";
			logger.log(Level.INFO, "Statement: " + sent);
			ResultSet rs = statement.executeQuery(sent);
			while (rs.next()) {
				int cod = rs.getInt("codF");
				String nombre = rs.getString("nombreF");
				String fecha = rs.getString("fechaF");
				String lugar = rs.getString("lugarF");
				String descripcion = rs.getString("descripcionF");
				double precio = rs.getDouble("precioF");
				String foto = rs.getString("foto");
				ret.add(new Festival(cod, nombre, fecha, lugar, descripcion, precio, foto));

			}
			//return ret;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}
		return ret;

	}
	
	/**
	 * Lee los festivales de la conexion de base de datos abierta (debe abrirse previamente con 
	 * 		{@link #abrirConexion(String, boolean)}
	 * @return Lista completa de artistas, vacia si no hay ninguno, null si hay error
	 */
	public static ArrayList<Artista> getArtistas() {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			ArrayList<Artista> ret = new ArrayList<>();
			String sent = "select * from artista";
			logger.log(Level.INFO, "Statement: " + sent);
			ResultSet rs = statement.executeQuery(sent);
			while (rs.next()) {
				int cod = rs.getInt("codA");
				String nombre = rs.getString("nombreA");
				String genero = rs.getString("generoA");
				ret.add(new Artista(cod, nombre, TipoGenero.valueOf(genero))); 

			}
			return ret;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}

	}
	
	/**
	 * Lee los festivales de la conexion de base de datos abierta (debe abrirse previamente con 
	 * 		{@link #abrirConexion(String, boolean)
	 * @return Lista completa de conciertos,vacia si no hay ninguno, null si existe algun error
	 */
	public static ArrayList<Concierto> getConciertos() {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			ArrayList<Concierto> ret = new ArrayList<>();
			String sent = "select * from artista";
			logger.log(Level.INFO, "Statement: " + sent);
			ResultSet rs = statement.executeQuery(sent);
			while (rs.next()) {
				int codC = rs.getInt("codC");
				int codA = rs.getInt("codA");
				Long hora = rs.getLong("horaC");
				double duracion = rs.getDouble("duracionC");
				int codF = rs.getInt("codF");
				
				Artista art = new Artista();
				for (Artista artista: BaseDeDatos.getArtistas()) {
					if (artista.getCodigoA() == codA) {
						art.setCodigoA(codA);
						art.setNombre(artista.getNombre());
						art.setTipogenero(artista.getTipogenero());
					}
				}
				Festival fest = new Festival();
				for (Festival festival: BaseDeDatos.getFestivales()) {
					if (festival.getCodigoF() == codF) {
						fest.setCodigoF(festival.getCodigoF());
						fest.setNombre(festival.getNombre());
						fest.setFecha(festival.getFecha());
						fest.setLugar(festival.getLugar());
						fest.setDescripcion(festival.getDescripcion());
						fest.setPrecio(festival.getPrecio());
						fest.setFoto(festival.getFoto());
					}
				}
				
				ret.add(new Concierto(codC, art, hora, duracion, fest)); 

			}
			return ret;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}

	}

	
	////////////////////////////////////////////
	///DATOS DE INICIO PARA LA BASE DE DATOS
	
	// este es para insertar caundo se abre la app
	/**
	 * Festivales con sus datos ya establecidos una vez se abre el programa (?? redactarlo mejor)
	 */
	public static void insertarFestivales() {

		//falta este por meter
		Festival fest2 = new Festival(02, "Coachella", "21-07-2023", "Dubai", "bla bla", 150.7, "tomorrowland.png");
		Festival fest3 = new Festival(03, "Arenal Sound", "21-07-2023", "Dubai", "bla bla", 150.7, "arenalsound.png");
		Festival fest4 = new Festival(04, "Mad Cool", "21-07-2023", "Dubai", "bla bla", 150.7, "");
		Festival fest5 = new Festival(05, "hollika", "21-07-2023", "Dubai", "bla bla", 150.7, "");
		Festival fest6 = new Festival(06, "boombastic", "21-07-2023", "Dubai", "bla bla", 150.7, "");
		Festival fest1 = new Festival(07, "Tomorrowland" , "21-07-2023", "Dubai","bla bla", 150.7, "");


		ArrayList<Festival> fests = new ArrayList<>();
		fests.add(fest1);
		fests.add(fest2);
		fests.add(fest3);
		fests.add(fest4);
		fests.add(fest5);
		fests.add(fest6);

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			for (Festival festival : fests) {
				String sent = "insert into festival values ( " + festival.getCodigoF() + " , '" + festival.getNombre()
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
	
	/**
	 * Festivales ya establecidos una vez se abre el programa ?? redactarlo mejor
	 * 
	 */
	public static void insertarConciertos() {
		
		Concierto conc1 = new Concierto(1, new Artista(0, null, null), 0, 0, new Festival(0, null, null, null, null, null, 0, null));
		ArrayList<Concierto> conciertos = new ArrayList<>();
		conciertos.add(conc1);
		
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			for (Concierto conc : conciertos) {
				String sent = "insert into concierto values ( " + conc.getCodigoC() + ", " + conc.getArtista().getCodigoA()
						+ " , '" + conc.getHora() + "' , '" + conc.getDuracion() + " ' , " + conc.getFestival().getCodigoF() + ");";

				logger.log(Level.INFO, "Statement: " + sent);

				statement.executeUpdate(sent);

			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);

		}
		
		

	}
	
	
	public static String getFotoFest(String nombreF) {
		String fotoFestival = "";
		for (Festival festival: BaseDeDatos.getFestivales()) {
			if (festival.getNombre() == nombreF) {
				fotoFestival = festival.getFoto();
			}
	}
		return fotoFestival;

	
	}
	
	
	
	/**
	 * Festivales ya establecidos una vez se abre el programa ?? redactarlo mejor
	 */
	public static void insertarArtistas() {
		Artista art1 = new Artista(01, "Aitana", TipoGenero.POP);
		ArrayList<Artista> artistas = new ArrayList<>();
		artistas.add(art1);
		
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			for (Artista art : artistas) {
				String sent = "insert into artista values ( " + art.getCodigoA() + " , ' " + art.getNombre()
						+ "' , '" + art.getTipogenero() +  "');";

				logger.log(Level.INFO, "Statement: " + sent);

				statement.executeUpdate(sent);

			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);

		}

	}

	/**
	 * Usuarios ya generados una vez se abre el programa ?? redactarlo mejor
	 */	
	public static void insertarUsuarios() {

		Admin admin = new Admin("admin", "admin", "admin", "admin");
		ArrayList<Admin> admins = new ArrayList<>();
		admins.add(admin);


		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			for (Admin ad : admins) {
				String sent = "insert into admins values ( 1 , '" + ad.getNombre() + "', '" + ad.getApellido() + "' , '"
						+ ad.getDni() + "' , '" + ad.getContrasena() + "');";

				logger.log(Level.INFO, "Statement: " + sent);

				statement.executeUpdate(sent);
			}


		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);

		}
		
		//insertarclientes
		
		Cliente cliente = new Cliente("Juan", "Gonzalez", "567899", "Vitoria", 27, "juan@gmail.com", "0000");
		ArrayList<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente);

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			for (Cliente cl : clientes) {
				String sent = "insert into clientes values ( 1 , '" + cl.getNombre() + "', '" + cl.getApellido() + "' , '"
						+ cl.getDni() + "' , '" + cl.getDireccion()+ "' , '" + cl.getEdad()+ "' , '" + cl.getCorreo() + "' , '" + cl.getContrasena() + "');";

				logger.log(Level.INFO, "Statement: " + sent);

				statement.executeUpdate(sent);
			}

			
			

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);

		}
	}
	
	
	///////////////////////////////////////////////////
	
	
	public static Festival getFestival(Festival festival) {
		Festival f = new Festival();
		try {
			abrirConexion("BaseDatos.db", false);
			for (Festival fest: BaseDeDatos.getFestivales() ) {
				if (fest.getCodigoF() == festival.getCodigoF() ) {
					f.setCodigoF(festival.getCodigoF());
					f.setNombre(festival.getNombre());
					f.setLugar(festival.getLugar());
					f.setDescripcion(festival.getDescripcion());
					f.setPrecio(festival.getPrecio());
					f.setFoto(festival.getFoto());
					ArrayList<Concierto> conciertos = new ArrayList<>();
					for (Concierto concierto: BaseDeDatos.getConciertos()) {
						if (concierto.getFestival().getCodigoF() == f.getCodigoF()) {
							conciertos.add(concierto);
						}
					}
					f.setListaConciertos(conciertos);
				}
			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}
		return f;
	}
	
	
	
	
	}


