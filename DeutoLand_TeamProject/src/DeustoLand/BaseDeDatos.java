package DeustoLand;

import java.beans.beancontext.BeanContextContainerProxy;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
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
				sent = "CREATE TABLE artista (codA INTEGER PRIMARY KEY, nombreA char(25), generoA char(25));";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

				sent = "DROP TABLE IF EXISTS concierto";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE concierto (codC INTEGER PRIMARY KEY, codA int(3) REFERENCES artista (codA), horaC date, duracionC dec(3,2), codF int(3) REFERENCES festival (codF));";
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
				
				sent = "DROP TABLE IF EXISTS entradas";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE clientes (codE INTEGER PRIMARY KEY AUTOINCREMENT, codC int(4) REFERENCES clientes(codC), codF int (3) REFERENCES festival(codF) , tipo int(1) , suplemento_c dec(4,2), parcela int(3), suplemento_v dec(4,2), num_zona int(2) );";
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
			String sent = "select * from concierto";
			logger.log(Level.INFO, "Statement: " + sent);
			ResultSet rs = statement.executeQuery(sent);
			while (rs.next()) {
				int codC = rs.getInt("codC");
				int codA = rs.getInt("codA");
				long hora = rs.getLong("horaC");
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

		
		Festival fest1 = new Festival(01, "Tomorrowland" , "21-07-2023", "Boom, Bélgica","Tomorrowland es un festival de música electrónica de baile en el que lo pasarás en grande y difrutaras de 3 días increíbles con tus amigos y lleno de música. El festival tiene una duración de 3 días y cada día empezará sobre las 18:00 horas. Para más información consulte la página oficial del sitio: https://www.tomorrowland.com/", 150.00, "tomorrowland.png");
		Festival fest2 = new Festival(02, "Coachella", "25-04-2023", "Colorado, California, EEUU", "Coachella es un gran festival de música que se lleva a cabo durante tres días en la última semana del mes de abril en California. Es uno de los festivales de música más grandes, famosos y rentables de Estados Unidos y del mundo. Para más información consulte la página oficial del sitio: https://www.coachella.com/", 300.00, "coachella.png");
		Festival fest3 = new Festival(03, "Arenal Sound", "1-08-2023", "Burriana, Castellón, España", "Arenal Sound Festival es un festival de música que se caracteriza por su gran afluencia de jóvenes y se diferencia de otros festivales por su cercanía a la playa al tener uno de sus escenarios sobre la misma arena. Para más información consulte la página oficial del sitio: https://www.arenalsound.com/ ", 70.00, "arenalsound.png");
		Festival fest4 = new Festival(04, "Mad Cool", "04-07-2023", "Madrid, España", "Mad Cool es un festival de música que se realiza en Madrid desde el año 2016. El arte, la moda, la gastronomía y el turismo se unen eclécticamente en este festival. Para más información consulte la página oficial del sitio: https://madcoolfestival.es/", 120.00, "madcool.jpg");
		Festival fest5 = new Festival(05, "Hollika", "28-06-2023", "Calahorra, La Rioja, España", "El Holika Festival es un Festival de Música que incluye géneros de música electrónica, urbana y latina. Se caracteriza por su gran afluencia de jóvenes de todas las provincias españolas. La última edición (2023) se celebrará en Calahorra. Para más información consulte la página oficial del sitio: https://www.holika.es/ ", 45, "holika.jpg");
		Festival fest6 = new Festival(06, "Boombastic", "20-07-2023", "Asturias, España", "Boombastic es un nuevo modelo de festival, adaptado a los tiempos que corren y con la intención de saciar las ganas de música, cultura y festivales de la gente joven. Tiene lugar en Asturias y tiene una duración de 4 días. Para más información consulte la página oficial del sitio: https://boombasticfestival.com/ ", 50.00, "boombastic.jpg");

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
	

	
	public static String getFotoFest(String nombreF) {
		String fotoFestival = "";
		for (Festival festival: BaseDeDatos.getFestivales()) {
			if (festival.getNombre() == nombreF) {
				fotoFestival = festival.getFoto();
				System.out.println(fotoFestival);
			} 
	}
		return fotoFestival;

		

	
	}
	
	
	
	/**
	 * Festivales ya establecidos una vez se abre el programa ?? redactarlo mejor
	 */
	public static void insertarArtistas() {
		Artista art1 = new Artista(01, "Aitana", TipoGenero.POP);
		Artista art2 = new Artista(02, "Mora", TipoGenero.URBANOLATINO);
		Artista art3 = new Artista(03, "Taburete", TipoGenero.ROCKESP);
		Artista art4 = new Artista(04, "Eladio Carrion", TipoGenero.URBANOLATINO);
		Artista art5 = new Artista(05, "One Direction", TipoGenero.POP);
		Artista art6 = new Artista(06, "La Oreja de Van Gogh", TipoGenero.POP);
		Artista art7 = new Artista(07, "Tini", TipoGenero.POP);
		Artista art8 = new Artista(8, "Rels B", TipoGenero.URBANOLATINO);
		Artista art9 = new Artista(9, "Juan Magan", TipoGenero.REGGAETON);
		Artista art10 = new Artista(10, "Myke Towers", TipoGenero.REGGAETON);
		Artista art11 = new Artista(11, "Afro Jack", TipoGenero.TECHNO);
		Artista art12 = new Artista(12, "La MODA", TipoGenero.ROCKESP);
		Artista art13 = new Artista(13, "Morad", TipoGenero.REGGAETON);
		Artista art14 = new Artista(14, "Belén Aguilera", TipoGenero.POP);
		Artista art15 = new Artista(15, "Amber Broose", TipoGenero.TECHNO); 
		Artista art16 = new Artista(16, "Dom Dolla", TipoGenero.TECHNO);
		Artista art17 = new Artista(17, "Harry Styles", TipoGenero.POP);
		Artista art18 = new Artista(18, "Billie Eilish", TipoGenero.POP);
		Artista art19 = new Artista(19, "Taylor Swift", TipoGenero.POP);
		Artista art20 = new Artista(20, "Daniel Caesar", TipoGenero.POP);
		

		ArrayList<Artista> artistas = new ArrayList<>();
		artistas.add(art1);
		artistas.add(art2);
		artistas.add(art3);
		artistas.add(art4);
		artistas.add(art5);
		artistas.add(art6);
		artistas.add(art7);
		artistas.add(art8);
		artistas.add(art9);
		artistas.add(art10);
		artistas.add(art11);
		artistas.add(art12);
		artistas.add(art13);
		artistas.add(art14);
		artistas.add(art15);
		artistas.add(art16);
		artistas.add(art17);
		artistas.add(art18);
		artistas.add(art19);
		artistas.add(art20);
		
	
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
	 * Festivales ya establecidos una vez se abre el programa ?? redactarlo mejor
	 * 
	 */
	public static void insertarConciertos() {

		Concierto conc1 = new Concierto(01, new Artista(0, "", null), 0, 1.00, new Festival(0, "", null, null, null, null, 0, null));
		//Concierto conc0 = new Concierto(01, BaseDeDatos.getArtistas().get(0), new Date(0), 1.00, BaseDeDatos.getFestivales().get(0));
		//Concierto conc2 = new Concierto(02, BaseDeDatos.getArtistas().get(1),  new Date(0), 1.00, BaseDeDatos.getFestivales().get(0));
		//Concierto conc3 = new Concierto(03, BaseDeDatos.getArtistas().get(3),  new Date(0), 1.00, BaseDeDatos.getFestivales().get(0));
		//Concierto conc4 = new Concierto(04, BaseDeDatos.getArtistas().get(7),  new Date(0), 1.00, BaseDeDatos.getFestivales().get(0));
		//Concierto conc5 = new Concierto(05, BaseDeDatos.getArtistas().get(8),  new Date(0), 1.00, BaseDeDatos.getFestivales().get(0));
		//Concierto conc6 = new Concierto(06, BaseDeDatos.getArtistas().get(9),  new Date(0), 1.00, BaseDeDatos.getFestivales().get(0));
		//Concierto conc7 = new Concierto(07, BaseDeDatos.getArtistas().get(10),  new Date(0), 1.00, BaseDeDatos.getFestivales().get(0));
		//Concierto conc8 = new Concierto(8, BaseDeDatos.getArtistas().get(14),  new Date(0), 1.00, BaseDeDatos.getFestivales().get(0));
		//Concierto conc9 = new Concierto(9, BaseDeDatos.getArtistas().get(15),  new Date(0), 1.00, BaseDeDatos.getFestivales().get(0));
		//Concierto conc10 = new Concierto(10, BaseDeDatos.getArtistas().get(19),  new Date(0), 1.00, BaseDeDatos.getFestivales().get(0));
		
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


