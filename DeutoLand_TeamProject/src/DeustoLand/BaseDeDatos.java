package DeustoLand;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase de gestion de una base de datos del sistema de festivales???
 * 
 */
public class BaseDeDatos {

	private static Connection con;
	// private static Logger logger = Logger.getLogger("BaseDatos");
	private static Logger logger = Logger.getLogger(BaseDeDatos.class.getName());

	/**
	 * Constructor de la clase y creacion del fichero loggers
	 */
	public BaseDeDatos() {
		try (FileInputStream fis = new FileInputStream("logger.properties")) {
			LogManager.getLogManager().readConfiguration(fis);
		} catch (Exception ex) {
			logger.warning(
					String.format("%s - Error leyendo configuración del Logger: %s", this.getClass(), ex.getMessage()));
		}
	}

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

				sent = "DROP TABLE IF EXISTS user";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE user (codU INTEGER PRIMARY KEY AUTOINCREMENT, nombre char(25), apellido char(25) , dni char(25) , correo char(30), contrasena char(25), tipo int(1), direccion char(25), edad int(2), codigoP int(5), fechaU char(10) );";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

				sent = "DROP TABLE IF EXISTS entradas";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
				sent = "CREATE TABLE entradas (codE INTEGER PRIMARY KEY AUTOINCREMENT, codC int(4) REFERENCES user(codU), codF int (3) REFERENCES festival(codF) , tipo int(1) , suplemento_c dec(4,2), parcela int(3), suplemento_v dec(4,2), num_zona int(2) );";
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

	///////////////////////////////////////////////////////////////
	// operacion para insertar festivales desde la app

	/**
	 * Insertar un festival en la base de datos abierta (debe abrirse previamente
	 * con {@link #abrirConexion(String, boolean)} Actualiza el codigo del festival
	 * insertado(ESTO NO LO TENGO CLARO SI HAY Q PONER)
	 * 
	 * @param festival Festival a insertar
	 * @return true si la insercion es correcta, false en caso contrario
	 */
	public static boolean insertarFestival(Festival festival) {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			String sent = "insert into festival values ( '" + festival.getNombre() + "' , '" + festival.getFecha()
					+ "' , '" + festival.getLugar() + "' , '" + festival.getDescripcion() + "' , "
					+ festival.getPrecio() + ", '" + festival.getFoto() + "');";
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
	 * Insertar un artista en la base de datos abierta (debe abrirse previamente con
	 * {@link #abrirConexion(String, boolean)}
	 * 
	 * @param artista Artista a insertar
	 * @return true si la insercion es correcta, false en caso contrario
	 */
	public static boolean insertarArtista(Artista artista) {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			String sent = "insert into artista values ( '" + artista.getNombre() + "', '" + artista.getTipogenero()
					+ "' );";
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
	 * Inserta un concierto en la base de datos abierta (debe abrirse previamente
	 * con {@link #abrirConexion(String, boolean)}
	 * 
	 * @param concierto Concierto a insertar
	 * @return true si la insercion es correcta, false en caso contrario
	 */
	public static boolean insertarConcierto(Concierto concierto) {
		try (Statement statement = con.createStatement()) {
			String sent = "insert into concierto values ( " + concierto.getArtista() + ", " + concierto.getHora()
					+ " , " + concierto.getDuracion() + " , " + concierto.getFestival() + " );";
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
	 * Metodo para insertar un cliente en la BD
	 * 
	 * @param cliente cliente a insertar
	 * @return true, si se ha añadido correctamente, de lo contrario, false
	 */
	public static boolean insertarCliente(Cliente cliente) {
		try (Statement statement = con.createStatement()) {
			String sent = "insert into user values ( '" + cliente.getNombre() + "' , '" + cliente.getApellido()
					+ "' , '" + cliente.getDni() + "' , '" + cliente.getCorreo() + "' , '" + cliente.getContrasena()
					+ "' , '" + cliente.getDireccion() + "' , " + cliente.getEdad() + " );";
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
			cliente.setCod(pk);
			return true;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);
			return false;
		}

	}

	/**
	 * Lee los festivales de la conexion de base de datos abierta (debe abrirse
	 * previamente con {@link #abrirConexion(String, boolean)}
	 * 
	 * @return Lista completa de festivales, vacia si no hay ninguna, null si existe
	 *         algun error
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
			// return ret;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}
		return ret;

	}

	// LO HE EMPZADO PERO NO ME HA DADO TIEMPO A ACABAR, LUEGO LO ACABO -- ANE

	/**
	 * Metodo para recuperar las entradas de la BD
	 * 
	 * @return
	 */
	public static ArrayList<Entrada> getEntradas() {
		ArrayList<Entrada> ret = new ArrayList<>();

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			String sent = "select * from entradas";
			logger.log(Level.INFO, "Statement: " + sent);
			ResultSet rs = statement.executeQuery(sent);

			while (rs.next()) {
				int cod = rs.getInt("codE");
				int codUser = rs.getInt("codC");
				int codFest = rs.getInt("codF");
				int tipo = rs.getInt("tipo");
				double suplementoC = rs.getDouble("suplemento_c");
				int parcela = rs.getInt("parcela");
				Double suplementoV = rs.getDouble("suplemento_v");
				int numZona = rs.getInt("num_zona");

				User user = new User();
				for (User u : BaseDeDatos.getUsers()) {
					if (u.getCod() == codUser) {
						user = BaseDeDatos.getUser(u.getCorreo(), u.getContrasena());
					}
				}

				if (user.equals(BaseDeDatos.getCliente(user.getCorreo(), user.getContrasena()))) {

					Cliente c = (Cliente) user;
					Festival fest = new Festival();
					for (Festival festival : BaseDeDatos.getFestivales()) {
						if (festival.getCodigoF() == codFest) {

							fest.setCodigoF(festival.getCodigoF());
							fest.setNombre(festival.getNombre());
							fest.setFecha(festival.getFecha());
							fest.setLugar(festival.getLugar());
							fest.setDescripcion(festival.getDescripcion());
							fest.setPrecio(festival.getPrecio());
							fest.setFoto(festival.getFoto());
						}
					}

					if (tipo == 0) {
						ret.add(new Entrada(cod, c, fest, TipoEntrada.NORMAL));
					} else if (tipo == 1) {
						ret.add(new EntradaConCamping(cod, c, fest, TipoEntrada.CONCAMPING, suplementoC, parcela));
					} else if (tipo == 2) {
						ret.add(new EntradaVIP(cod, c, fest, TipoEntrada.VIP, suplementoV, numZona));
					} else {
						System.out.println("tipo no válido para tipos de entrada disponibles");
					}

				} else {
					System.out.println("los administradores no los usamos para las estadísticas");

				}

			}
			// System.out.println(ret);
			return ret;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);

			return null;

		}

	}

	/**
	 * Metodo para obtener el precio total de una entrada determinada, incluyendo
	 * los suplementos
	 * 
	 * @param e entrada
	 * @return precio total de la entrada
	 */
	public static double getPrecioTotal(Entrada e) {
		double precio = e.getFestival().getPrecio();
		if (e.getTipoE().equals(TipoEntrada.NORMAL)) {
			return precio;
		} else if (e.getTipoE().equals(TipoEntrada.CONCAMPING)) {
			EntradaConCamping ec = (EntradaConCamping) e;
			double precioTotal = precio + ec.getSuplementoCamping();
			return precioTotal;
		} else {
			EntradaVIP ev = (EntradaVIP) e;
			double precioTotal = precio + ev.getSuplementoVIP();
			return precioTotal;
		}

	}

	/**
	 * Lee los artistas de la conexion de base de datos abierta (debe abrirse
	 * previamente con {@link #abrirConexion(String, boolean)}
	 * 
	 * @return Lista completa de artistas, vacia si no hay ninguno, null si hay
	 *         error
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
	 * Lee los festivales de la conexion de base de datos abierta (debe abrirse
	 * previamente con {@link #abrirConexion(String, boolean)
	 * 
	 * @return Lista completa de conciertos,vacia si no hay ninguno, null si existe
	 *         algun error
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
				for (Artista artista : BaseDeDatos.getArtistas()) {
					if (artista.getCodigoA() == codA) {
						art.setCodigoA(codA);
						art.setNombre(artista.getNombre());
						art.setTipogenero(artista.getTipogenero());
					}
				}
				Festival fest = new Festival();
				for (Festival festival : BaseDeDatos.getFestivales()) {
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

	/**
	 * Metodo para obtener una lista de los administradores
	 * 
	 * @return lista de los administradores
	 */
	public static ArrayList<Admin> getAdmins() {

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			ArrayList<Admin> ret = new ArrayList<>();
			String sent = "select * from user";
			logger.log(Level.INFO, "Statement: " + sent);
			ResultSet rs = statement.executeQuery(sent);
			while (rs.next()) {
				int codA = rs.getInt("codU");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String dni = rs.getString("dni");
				String correo = rs.getString("correo");
				String contraseña = rs.getString("contrasena");
				String fechaU = rs.getString("fechaU");
				ret.add(new Admin(codA, nombre, apellido, dni, correo, contraseña, fechaU));
			}
			return ret;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}

	}

	/**
	 * Metodo para obtener una lista de los clientes
	 * 
	 * @return una arraylist de clientes
	 */
	public static ArrayList<Cliente> getClientes() {

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			ArrayList<Cliente> ret = new ArrayList<>();
			String sent = "select * from user";
			logger.log(Level.INFO, "Statement: " + sent);
			ResultSet rs = statement.executeQuery(sent);
			while (rs.next()) {
				int codC = rs.getInt("codU");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String dni = rs.getString("dni");
				String correo = rs.getString("correo");
				String contraseña = rs.getString("contrasena");
				String dir = rs.getString("direccion");
				int edad = rs.getInt("edad");
				int codigoP = rs.getInt("codigoP");

				ret.add(new Cliente(codC, nombre, apellido, dni, correo, contraseña, dir, edad, codigoP));
			}
			return ret;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}
	}

	/**
	 * Obtener un cliente identificado por su correo y contraseña. Si éstas no
	 * coinciden, el usuario no existe y genera una excepcion
	 * 
	 * @param correo     correo del cliente
	 * @param contrasena contraseña del cliente
	 * @return un objeto de la clase cliente
	 */
	public static Cliente getCliente(String correo, String contrasena) {
		Cliente c = null;
		try {
			abrirConexion("BaseDatos.db", false);
			for (Cliente cli : BaseDeDatos.getClientes()) {
				if (cli.getCorreo().equals(correo) && cli.getContrasena().equals(contrasena)) {
					c = new Cliente();
					c.setCod(cli.getCod());
					c.setNombre(cli.getNombre());
					c.setApellido(cli.getApellido());
					c.setDni(cli.getDni());
					c.setCorreo(cli.getCorreo());
					c.setContrasena(cli.getContrasena());
					c.setDireccion(cli.getDireccion());
					c.setEdad(cli.getEdad());
					c.setCodigoP(cli.getCodigoP());
				}
			}

			return c;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}

	}

	/**
	 * Obtener un administrador identificado por su correo y contraseña. Si éstas no
	 * coinciden, el usuario no existe y genera una excepcion
	 * 
	 * @param correo     correo del administrador
	 * @param contrasena contrasena del administrador
	 * @return objeto de la clase admin
	 */
	public static Admin getAdmin(String correo, String contrasena) {
		Admin a = new Admin();

		try {
			abrirConexion("BaseDatos.db", false);
			for (Admin ad : BaseDeDatos.getAdmins()) {
				if (ad.getCorreo() == correo && ad.getContrasena() == contrasena) {
					a.setCod(ad.getCod());
					a.setNombre(ad.getNombre());
					a.setApellido(ad.getApellido());
					a.setDni(ad.getDni());
					a.setCorreo(ad.getCorreo());
					a.setContrasena(ad.getContrasena());
					a.setFechaUltimaMod(ad.getFechaUltimaMod());
				}
			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}
		// System.out.println(a);
		return a;

	}

	/**
	 * Metodo para obtener los usuarios de la BD
	 * 
	 * @return una arraylist the objetos cliente y admin
	 */
	public static ArrayList<User> getUsers() {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			ArrayList<User> ret = new ArrayList<>();

			String sent = "select * from user order by correo";
			logger.log(Level.INFO, "Statement: " + sent);
			ResultSet rs = statement.executeQuery(sent);
			while (rs.next()) {
				int codU = rs.getInt("codU");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String dni = rs.getString("dni");
				String correo = rs.getString("correo");
				String contraseña = rs.getString("contrasena");
				int tipo = rs.getInt("tipo");
				String dir = rs.getString("direccion");
				int edad = rs.getInt("edad");
				int codigoP = rs.getInt("codigoP");
				String fU = rs.getString("fechaU");

				if (tipo == 0) {
					ret.add(new Cliente(codU, nombre, apellido, dni, correo, contraseña, dir, edad, codigoP));
				} else {
					ret.add(new Admin(codU, nombre, apellido, dni, correo, contraseña, fU));
				}

			}
			System.out.println(ret);
			return ret;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}

	}

	/**
	 * Obtener un usuario identificado con un correo y contraseña determinados
	 * 
	 * @param correo     correo del usuario
	 * @param contrasena contrasena del usuario
	 * @return objeto de la clase admin o cliente
	 */
	public static User getUser(String correo, String contraseña) {

		int cli = 0;
		try {
			abrirConexion("BaseDatos.db", false);

			for (User ad : BaseDeDatos.getUsers()) {
				if (ad.equals(BaseDeDatos.getCliente(correo, contraseña))) {
					cli = cli + 1;
				}
			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion", e);
			return null;
		}

		if (cli == 1) {
			return BaseDeDatos.getCliente(correo, contraseña);
		} else {
			return BaseDeDatos.getAdmin(correo, contraseña);
		}

	}

	/**
	 * 
	 * @param f
	 * @param i
	 * @return
	 */
	public static Festival FestEstadistica(Festival f, int i) {
		Festival fest = new Festival();
		int index = -1;
		for (Festival festival : BaseDeDatos.getFestivales()) {
			index += 1;
			if (f.getNombre().equals(festival.getNombre())) {
				if (i == 0) {
					if (BaseDeDatos.getFestivales().get(0).getNombre().equals(f.getNombre())) {
						fest = BaseDeDatos.getFestivales().get(BaseDeDatos.getFestivales().size() - 1);
					} else {
						fest = BaseDeDatos.getFestivales().get(index - 1);
					}
				} else if (i == 1) {
					// if (
					// BaseDeDatos.getFestivales().get(BaseDeDatos.getFestivales().size()-1).equals(f))
					// {//no entra en este bucle y ns pq

					if (BaseDeDatos.getFestivales().get(BaseDeDatos.getFestivales().size() - 1).getNombre()
							.equals(f.getNombre())) {

						fest = BaseDeDatos.getFestivales().get(0);

					} else {
						fest = BaseDeDatos.getFestivales().get(index + 1);
					}
				} else {
					System.out.println("error, el número solo puede estar entre 0 y 1");
				}
			}
		}
		// System.out.println(fest);
		return fest;
	}

	////////////////////////////////////////////
	/// DATOS DE INICIO PARA LA BASE DE DATOS

	// este es para insertar caundo se abre la app
	/**
	 * Festivales con sus datos ya establecidos una vez se abre el programa (??
	 * redactarlo mejor)
	 */
	public static void insertarFestivales() {

		Festival fest1 = new Festival(01, "Tomorrowland", "21-07-2023", "Boom, Bélgica",
				"Tomorrowland es un festival de música electrónica de baile en el que lo pasarás en grande y difrutaras de 3 días increíbles con tus amigos y lleno de música. El festival tiene una duración de 3 días y cada día empezará sobre las 18:00 horas. Para más información consulte la página oficial del sitio: https://www.tomorrowland.com/",
				150.00, "tomorrowland.png");
		Festival fest2 = new Festival(02, "Coachella", "25-04-2023", "Colorado, California, EEUU",
				"Coachella es un gran festival de música que se lleva a cabo durante tres días en la última semana del mes de abril en California. Es uno de los festivales de música más grandes, famosos y rentables de Estados Unidos y del mundo. Para más información consulte la página oficial del sitio: https://www.coachella.com/",
				300.00, "coachella.png");
		Festival fest3 = new Festival(03, "Arenal Sound", "1-08-2023", "Burriana, Castellón, España",
				"Arenal Sound Festival es un festival de música que se caracteriza por su gran afluencia de jóvenes y se diferencia de otros festivales por su cercanía a la playa al tener uno de sus escenarios sobre la misma arena. Para más información consulte la página oficial del sitio: https://www.arenalsound.com/ ",
				70.00, "arenalsound.png");
		Festival fest4 = new Festival(04, "Mad Cool", "04-07-2023", "Madrid, España",
				"Mad Cool es un festival de música que se realiza en Madrid desde el año 2016. El arte, la moda, la gastronomía y el turismo se unen eclécticamente en este festival. Para más información consulte la página oficial del sitio: https://madcoolfestival.es/",
				120.00, "madcool.jpg");
		Festival fest5 = new Festival(05, "Hollika", "28-06-2023", "Calahorra, La Rioja, España",
				"El Holika Festival es un Festival de Música que incluye géneros de música electrónica, urbana y latina. Se caracteriza por su gran afluencia de jóvenes de todas las provincias españolas. La última edición (2023) se celebrará en Calahorra. Para más información consulte la página oficial del sitio: https://www.holika.es/ ",
				45, "holika.jpg");
		Festival fest6 = new Festival(06, "Boombastic", "20-07-2023", "Asturias, España",
				"Boombastic es un nuevo modelo de festival, adaptado a los tiempos que corren y con la intención de saciar las ganas de música, cultura y festivales de la gente joven. Tiene lugar en Asturias y tiene una duración de 4 días. Para más información consulte la página oficial del sitio: https://boombasticfestival.com/ ",
				50.00, "boombastic.jpg");

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

		Artista art21 = new Artista(21, "Dani Martin", TipoGenero.POP);
		Artista art22 = new Artista(22, "Sebastiian Yatra", TipoGenero.REGGAETON);
		Artista art23 = new Artista(23, "Omar Montes", TipoGenero.REGGAETON);
		Artista art24 = new Artista(24, "Bad Bunny", TipoGenero.REGGAETON);
		Artista art25 = new Artista(25, "Morat", TipoGenero.POP);

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

		artistas.add(art21);
		artistas.add(art22);
		artistas.add(art23);
		artistas.add(art24);
		artistas.add(art25);

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			for (Artista art : artistas) {
				String sent = "insert into artista values ( " + art.getCodigoA() + " , ' " + art.getNombre() + "' , '"
						+ art.getTipogenero() + "');";

				logger.log(Level.INFO, "Statement: " + sent);

				statement.executeUpdate(sent);

			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);

		}

	}

	/**
	 * Convertir fechas a milisegundos:
	 * 
	 * @param date fecha
	 * @return fecha convertida a milisegundos de tipo long
	 */
	public static long cambiarLong(String date) {
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
		long milliseconds = 0;
		try {
			java.util.Date d = formato.parse(date);
			milliseconds += d.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(milliseconds);
		return milliseconds;
	}

	/**
	 * Festivales ya establecidos una vez se abre el programa ?? redactarlo mejor
	 * 
	 */
	public static void insertarConciertos() {

		Concierto conc0 = new Concierto(01, BaseDeDatos.getArtistas().get(0), BaseDeDatos.cambiarLong("17:00:00"), 1.00,
				BaseDeDatos.getFestivales().get(0));
		Concierto conc1 = new Concierto(02, BaseDeDatos.getArtistas().get(1), BaseDeDatos.cambiarLong("18:00:00"), 1.00,
				BaseDeDatos.getFestivales().get(0));
		Concierto conc2 = new Concierto(03, BaseDeDatos.getArtistas().get(3), BaseDeDatos.cambiarLong("19:00:00"), 1.00,
				BaseDeDatos.getFestivales().get(0));
		Concierto conc3 = new Concierto(04, BaseDeDatos.getArtistas().get(7), BaseDeDatos.cambiarLong("20:00:00"), 1.00,
				BaseDeDatos.getFestivales().get(0));
		Concierto conc4 = new Concierto(05, BaseDeDatos.getArtistas().get(8), BaseDeDatos.cambiarLong("21:00:00"), 1.00,
				BaseDeDatos.getFestivales().get(0));
		Concierto conc5 = new Concierto(06, BaseDeDatos.getArtistas().get(9), BaseDeDatos.cambiarLong("22:00:00"), 1.00,
				BaseDeDatos.getFestivales().get(0));
		Concierto conc6 = new Concierto(07, BaseDeDatos.getArtistas().get(10), BaseDeDatos.cambiarLong("23:00:00"),
				1.00, BaseDeDatos.getFestivales().get(0));
		Concierto conc7 = new Concierto(8, BaseDeDatos.getArtistas().get(14), BaseDeDatos.cambiarLong("00:00:00"), 1.00,
				BaseDeDatos.getFestivales().get(0));
		Concierto conc8 = new Concierto(9, BaseDeDatos.getArtistas().get(15), BaseDeDatos.cambiarLong("01:00:00"), 1.00,
				BaseDeDatos.getFestivales().get(0));
		Concierto conc9 = new Concierto(10, BaseDeDatos.getArtistas().get(19), BaseDeDatos.cambiarLong("02:00:00"),
				1.00, BaseDeDatos.getFestivales().get(0));

		Concierto conc10 = new Concierto(11, BaseDeDatos.getArtistas().get(2), BaseDeDatos.cambiarLong("20:00:00"), 2.0,
				BaseDeDatos.getFestivales().get(1));
		Concierto conc11 = new Concierto(12, BaseDeDatos.getArtistas().get(3), BaseDeDatos.cambiarLong("21:00:00"), 1.0,
				BaseDeDatos.getFestivales().get(1));
		Concierto conc12 = new Concierto(13, BaseDeDatos.getArtistas().get(6), BaseDeDatos.cambiarLong("22:00:00"), 1.5,
				BaseDeDatos.getFestivales().get(1));
		Concierto conc13 = new Concierto(14, BaseDeDatos.getArtistas().get(13), BaseDeDatos.cambiarLong("23:00:00"),
				1.3, BaseDeDatos.getFestivales().get(1));
		Concierto conc14 = new Concierto(15, BaseDeDatos.getArtistas().get(19), BaseDeDatos.cambiarLong("00:00:00"),
				1.0, BaseDeDatos.getFestivales().get(1));

		Concierto conc15 = new Concierto(16, BaseDeDatos.getArtistas().get(17), BaseDeDatos.cambiarLong("21:30:00"),
				2.0, BaseDeDatos.getFestivales().get(2));
		Concierto conc16 = new Concierto(17, BaseDeDatos.getArtistas().get(22), BaseDeDatos.cambiarLong("23:30:00"),
				1.0, BaseDeDatos.getFestivales().get(2));
		Concierto conc17 = new Concierto(18, BaseDeDatos.getArtistas().get(15), BaseDeDatos.cambiarLong("00:30:00"),
				1.5, BaseDeDatos.getFestivales().get(2));
		Concierto conc18 = new Concierto(19, BaseDeDatos.getArtistas().get(6), BaseDeDatos.cambiarLong("01:30:00"), 1.5,
				BaseDeDatos.getFestivales().get(2));
		Concierto conc19 = new Concierto(20, BaseDeDatos.getArtistas().get(1), BaseDeDatos.cambiarLong("02:30:00"), 2.2,
				BaseDeDatos.getFestivales().get(2));

		Concierto conc20 = new Concierto(21, BaseDeDatos.getArtistas().get(11), BaseDeDatos.cambiarLong("17:30:00"),
				2.0, BaseDeDatos.getFestivales().get(3));
		Concierto conc21 = new Concierto(22, BaseDeDatos.getArtistas().get(3), BaseDeDatos.cambiarLong("20:30:00"), 2.0,
				BaseDeDatos.getFestivales().get(3));
		Concierto conc22 = new Concierto(23, BaseDeDatos.getArtistas().get(22), BaseDeDatos.cambiarLong("21:30:00"),
				2.0, BaseDeDatos.getFestivales().get(3));
		Concierto conc23 = new Concierto(24, BaseDeDatos.getArtistas().get(19), BaseDeDatos.cambiarLong("22:30:00"),
				2.0, BaseDeDatos.getFestivales().get(3));
		Concierto conc24 = new Concierto(25, BaseDeDatos.getArtistas().get(4), BaseDeDatos.cambiarLong("00:30:00"), 2.0,
				BaseDeDatos.getFestivales().get(3));

		Concierto conc25 = new Concierto(26, BaseDeDatos.getArtistas().get(14), BaseDeDatos.cambiarLong("20:00:00"),
				1.5, BaseDeDatos.getFestivales().get(4));
		Concierto conc26 = new Concierto(27, BaseDeDatos.getArtistas().get(10), BaseDeDatos.cambiarLong("21:30:00"),
				2.2, BaseDeDatos.getFestivales().get(4));
		Concierto conc27 = new Concierto(28, BaseDeDatos.getArtistas().get(20), BaseDeDatos.cambiarLong("22:30:00"),
				1.5, BaseDeDatos.getFestivales().get(4));
		Concierto conc28 = new Concierto(29, BaseDeDatos.getArtistas().get(8), BaseDeDatos.cambiarLong("00:00:00"), 2.0,
				BaseDeDatos.getFestivales().get(4));
		Concierto conc29 = new Concierto(30, BaseDeDatos.getArtistas().get(6), BaseDeDatos.cambiarLong("01:30:00"), 1.9,
				BaseDeDatos.getFestivales().get(4));

		Concierto conc30 = new Concierto(31, BaseDeDatos.getArtistas().get(5), BaseDeDatos.cambiarLong("20:00:00"), 1.5,
				BaseDeDatos.getFestivales().get(5));
		Concierto conc31 = new Concierto(32, BaseDeDatos.getArtistas().get(8), BaseDeDatos.cambiarLong("21:30:00"), 2.2,
				BaseDeDatos.getFestivales().get(5));
		Concierto conc32 = new Concierto(33, BaseDeDatos.getArtistas().get(24), BaseDeDatos.cambiarLong("22:30:00"),
				1.5, BaseDeDatos.getFestivales().get(5));
		Concierto conc33 = new Concierto(34, BaseDeDatos.getArtistas().get(15), BaseDeDatos.cambiarLong("00:00:00"),
				2.0, BaseDeDatos.getFestivales().get(5));
		Concierto conc34 = new Concierto(35, BaseDeDatos.getArtistas().get(7), BaseDeDatos.cambiarLong("01:30:00"), 1.9,
				BaseDeDatos.getFestivales().get(5));

		ArrayList<Concierto> conciertos = new ArrayList<>();
		conciertos.add(conc0);
		conciertos.add(conc1);
		conciertos.add(conc2);
		conciertos.add(conc3);
		conciertos.add(conc4);
		conciertos.add(conc5);
		conciertos.add(conc6);
		conciertos.add(conc7);
		conciertos.add(conc8);
		conciertos.add(conc9);

		conciertos.add(conc10);
		conciertos.add(conc11);
		conciertos.add(conc12);
		conciertos.add(conc13);
		conciertos.add(conc14);

		conciertos.add(conc15);
		conciertos.add(conc16);
		conciertos.add(conc17);
		conciertos.add(conc18);
		conciertos.add(conc19);

		conciertos.add(conc20);
		conciertos.add(conc21);
		conciertos.add(conc22);
		conciertos.add(conc23);
		conciertos.add(conc24);

		conciertos.add(conc25);
		conciertos.add(conc26);
		conciertos.add(conc27);
		conciertos.add(conc28);
		conciertos.add(conc29);

		conciertos.add(conc30);
		conciertos.add(conc31);
		conciertos.add(conc32);
		conciertos.add(conc33);
		conciertos.add(conc34);

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			for (Concierto conc : conciertos) {
				String sent = "insert into concierto values ( " + conc.getCodigoC() + ", "
						+ conc.getArtista().getCodigoA() + " , '" + conc.getHora() + "' , '" + conc.getDuracion()
						+ " ' , " + conc.getFestival().getCodigoF() + ");";

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

		Admin admin = new Admin("admin", "admin", "admin", "admin", "admin", "27/12/2022");
		Admin admin2 = new Admin("Juan", "Perez", "23423762A", "juanperez@gmail.com", "juanperez23", "27/10/2022");
		Admin admin3 = new Admin("Natalia", "Rodriguez", "29753197B", "natarod@gmail.com", "natrodri34", "05/11/2022");
		Admin admin4 = new Admin("Aitana", "Eguren", "2864286C", "aitanaeg@gmail.com", "casaeguren234", "15/11/2022");
		Admin admin5 = new Admin("Lucas", "Armas", "1234321D", "lucasarmas@gmail.com", "1234", "17/11/2022");
		Admin admin6 = new Admin("Isaak", "Garcia", "4321234E", "isgarcia@gmail.com", "5432", "27/11/2022");
		Admin admin7 = new Admin("Iker", "Portela", "9876789F", "portela44@gmail.com", "ikerportela65", "30/11/2022");
		Admin admin8 = new Admin("Alicia", "Hermosa", "6789876G", "alihermos@gmail.com", "alioli123", "15/12/2022");
		Admin admin9 = new Admin("Alvaro", "Villanueva", "5460645H", "alvarovilla@gmail.com", "alvarito86",
				"20/12/2022");
		Admin admin10 = new Admin("Lidia", "Alvarez", "5554672I", "lidia123@gmail.com", "lidix32", "22/12/2022");
		Admin admin11 = new Admin("Maria", "Pomares", "1000243J", "mariapom@gmail.com", "merypom99", "26/12/2022");
		Admin admin12 = new Admin("Lola", "Moreno", "2300233K", "lolalolita@gmail.com", "lolaBrownie", "27/12/2022");
		Admin admin13 = new Admin("Marcos", "Gonzalez", "1452375L", "marcos32g@gmail.com", "marcos323", "27/12/2022");
		Admin admin14 = new Admin("Alex", "Navarro", "29096527M", "alexnavarro@gmail.com", "alex231", "04/01/2023");
		Admin admin15 = new Admin("Mar", "Marco", "2299417N", "marmarco@gmail.com", "5453f", "10/01/2023");

		ArrayList<Admin> admins = new ArrayList<>();
		admins.add(admin);
		admins.add(admin2);
		admins.add(admin3);
		admins.add(admin4);
		admins.add(admin5);
		admins.add(admin6);
		admins.add(admin7);
		admins.add(admin8);
		admins.add(admin9);
		admins.add(admin10);
		admins.add(admin11);
		admins.add(admin12);
		admins.add(admin13);
		admins.add(admin14);
		admins.add(admin15);

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			for (Admin ad : admins) {

				String nombre = ad.getNombre();
				String apellido = ad.getApellido();
				String dni = ad.getDni();
				String correo = ad.getCorreo();
				String contraseña = ad.getContrasena();
				String fecha = ad.getFechaUltimaMod();
				int tipo = 1;

				String sent = "INSERT INTO user (nombre, apellido, dni, correo, contrasena, tipo , fechaU )"
						+ " VALUES ( '" + nombre + "', '" + apellido + "', '" + dni + "','" + correo + "','"
						+ contraseña + "'," + tipo + ",'" + fecha + "');";

				logger.log(Level.INFO, "Statement: " + sent);

				statement.executeUpdate(sent);
			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);

		}

		Cliente clienteP = new Cliente("marina", "m", "m", "m", "m", "m", 0, 0);

		Cliente cliente = new Cliente("Juan", "Gonzalez", "567899", "juangon@gmail.com", "1234", "vitoria", 18, 48980);

		Cliente cliente2 = new Cliente("Cristina", "Lopez", "4567881A", "crislopez@gmail.com", "5678",
				"C.Koldo Mitxelena, 9", 24, 37879);
		Cliente cliente3 = new Cliente("Ramon", "Foronda", "3234570B", "ramonperales@gmail.com", "4567",
				"C.Blas de Otero, 15", 20, 12398);
		Cliente cliente4 = new Cliente("Javier", "Rubio", "2003456C", "javierrubio@gmail.com", "3456", "C.Zubieta, 32",
				18, 23419);
		Cliente cliente5 = new Cliente("Ane", "Martin", "1234553D", "anemartin@gmail.com", "2345",
				"C.Fernan Gonzalez, 50", 18, 23910);
		Cliente cliente6 = new Cliente("Lucia", "Lopez", "1021344E", "lucialopez@gmail.com", "11223",
				"Av. de Roma, 123", 24, 12312);
		Cliente cliente7 = new Cliente("Andrea", "Rio", "2212533F", "andreario@gmail.com", "22334", "Gran Via, 50", 27,
				87381);
		Cliente cliente8 = new Cliente("Iñigo", "Arrieta", "1122334G", "iñiarrieta@gmail.com", "3214", "C.Platerias, 3",
				18, 01201);
		Cliente cliente9 = new Cliente("Tomas", "Alonso", "9876508H", "iñiarrieta@gmail.com", "tomas342",
				"C.Huertas, 5", 26, 01231);
		Cliente cliente10 = new Cliente("Larraitz", "Garcia", "1239822I", "iñiarrieta@gmail.com", "432Larra",
				"C.Eduardo Dato, 3", 21, 90976);
		Cliente cliente11 = new Cliente("Petri", "Guinea", "1298404J", "iñiarrieta@gmail.com", "98321", "C.Postas, 45",
				20, 12312);
		Cliente cliente12 = new Cliente("Leire", "Perez", "8723761K", "iñiarrieta@gmail.com", "LeiPe234",
				"C.Voluntaria Entrega, 1", 20, 11223);
		Cliente cliente13 = new Cliente("Blanca", "Gonzalez", "9087640L", "iñiarrieta@gmail.com", "bg2827h",
				"C.Mayor, 25", 22, 33445);
		Cliente cliente14 = new Cliente("Almudena", "Velasco", "1000841M", "iñiarrieta@gmail.com", "AlmuVelas44",
				"C.Alameda Urquijo, 44", 21, 55667);
		Cliente cliente15 = new Cliente("David", "Vesga", "9041287N", "iñiarrieta@gmail.com", "5876g",
				"C.Iparaguirre, 34", 22, 12213);
		Cliente cliente16 = new Cliente("Fernando", "Basterra", "1111222O", "iñiarrieta@gmail.com", "999f", "Ercilla,3",
				23, 12642);
		Cliente cliente17 = new Cliente("Maria Jesus", "Barrio", "3332248P", "iñiarrieta@gmail.com", "mariaJesus342",
				"C.Cava Baja, 7", 25, 85643);
		Cliente cliente18 = new Cliente("Sandra", "Ruiz", "4446657Q", "iñiarrieta@gmail.com", "sandraru333",
				"C.Orcasitas, 90", 32, 66773);
		Cliente cliente19 = new Cliente("Maria", "Chillida", "8888768R", "iñiarrieta@gmail.com", "87213FF",
				"C.Cardenal Cisneros, 89", 26, 88535);
		Cliente cliente20 = new Cliente("Pedro", "Abajo", "9665588S", "iñiarrieta@gmail.com", "fffttt54",
				"C.Antonio Mendoza, 65", 26, 98684);
		Cliente cliente21 = new Cliente("Susana", "Saez", "9900880T", "iñiarrieta@gmail.com", "asdf456", "C.Arenal, 6",
				28, 99945);
		Cliente cliente22 = new Cliente("Alvaro", "Arana", "7006358U", "iñiarrieta@gmail.com", "alvaroAra00",
				"C.Agua, 50", 30, 77536);
		Cliente cliente23 = new Cliente("Jorge", "Madruga", "9124332V", "iñiarrieta@gmail.com", "JorgeMadru213",
				"C.Angela de la Cruz, 3", 18, 77775);
		Cliente cliente24 = new Cliente("Monica", "Merino", "9612465W", "iñiarrieta@gmail.com", "1456",
				"C.Alhondiga, 59", 19, 88824);
		Cliente cliente25 = new Cliente("Guillermo", "Ibarra", "9988662X", "iñiarrieta@gmail.com", "23521",
				"C.Platerias, 15", 20, 77332);
		Cliente cliente26 = new Cliente("Lucia", "Martinez", "4422134Y", "iñiarrieta@gmail.com", "3399",
				"C.Santiago, 23", 23, 22233);
		Cliente cliente27 = new Cliente("Maitane", "Echeverria", "5544321Z", "iñiarrieta@gmail.com", "mai234",
				"C.Lepanto, 273", 23, 33332);
		Cliente cliente28 = new Cliente("Carlos", "Serrano", "9863355Z", "iñiarrieta@gmail.com", "charliesera23",
				"Av. de Gaudi, 587", 24, 11112);
		Cliente cliente29 = new Cliente("Maider", "Saracibar", "2345632W", "iñiarrieta@gmail.com", "maisa82435",
				"Av. de Gaudi, 585", 21, 11112);
		Cliente cliente30 = new Cliente("Mara", "Suso", "7776678U", "marasuso@gmail.com", "marasusi878", "C.Gran V", 18,
				14123);

		ArrayList<Cliente> clientes = new ArrayList<>();

		clientes.add(clienteP); // Cliente de prueba ELIMINAR DESPUES!!!!!!
		clientes.add(cliente);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);
		clientes.add(cliente6);
		clientes.add(cliente7);
		clientes.add(cliente8);
		clientes.add(cliente9);
		clientes.add(cliente10);
		clientes.add(cliente11);
		clientes.add(cliente12);
		clientes.add(cliente13);
		clientes.add(cliente14);
		clientes.add(cliente15);
		clientes.add(cliente16);
		clientes.add(cliente17);
		clientes.add(cliente18);
		clientes.add(cliente19);
		clientes.add(cliente20);
		clientes.add(cliente21);
		clientes.add(cliente22);
		clientes.add(cliente23);
		clientes.add(cliente24);
		clientes.add(cliente25);
		clientes.add(cliente26);
		clientes.add(cliente27);
		clientes.add(cliente28);
		clientes.add(cliente29);
		clientes.add(cliente30);

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			for (Cliente cl : clientes) {
				String nombre = cl.getNombre();
				String apellido = cl.getApellido();
				String dni = cl.getDni();
				String correo = cl.getCorreo();
				String contraseña = cl.getContrasena();
				String direccion = cl.getDireccion();
				int edad = cl.getEdad();
				int codigoP = cl.getCodigoP();
				int tipo = 0;

				String sent = "INSERT INTO user (nombre, apellido, dni, correo, contrasena, tipo, direccion, edad, codigoP) "
						+ " VALUES ( '" + nombre + "', '" + apellido + "', '" + dni + "','" + correo + "','"
						+ contraseña + "'," + tipo + ",'" + direccion + "'," + edad + " ," + codigoP + ");";

				logger.log(Level.INFO, "Statement: " + sent);

				statement.executeUpdate(sent);
			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);

		}

	}

	public static void insertarEntradas() {
		Entrada e1 = new Entrada(BaseDeDatos.getClientes().get(33), BaseDeDatos.getFestivales().get(0),
				TipoEntrada.NORMAL);
		Entrada e2 = new EntradaVIP(BaseDeDatos.getClientes().get(35), BaseDeDatos.getFestivales().get(1),
				TipoEntrada.VIP, 40.5, 03);
		Entrada e3 = new EntradaVIP(BaseDeDatos.getClientes().get(37), BaseDeDatos.getFestivales().get(2),
				TipoEntrada.VIP, 65, 01);
		Entrada e4 = new EntradaConCamping(BaseDeDatos.getClientes().get(38), BaseDeDatos.getFestivales().get(3),
				TipoEntrada.CONCAMPING, 30, 1345);
		Entrada e5 = new EntradaConCamping(BaseDeDatos.getClientes().get(40), BaseDeDatos.getFestivales().get(4),
				TipoEntrada.CONCAMPING, 25.50, 85);
		Entrada e6 = new Entrada(BaseDeDatos.getClientes().get(16), BaseDeDatos.getFestivales().get(5),
				TipoEntrada.NORMAL);
		Entrada e7 = new EntradaVIP(BaseDeDatos.getClientes().get(17), BaseDeDatos.getFestivales().get(0),
				TipoEntrada.VIP, 40.5, 04);
		Entrada e8 = new EntradaVIP(BaseDeDatos.getClientes().get(18), BaseDeDatos.getFestivales().get(1),
				TipoEntrada.VIP, 65, 02);
		Entrada e9 = new EntradaConCamping(BaseDeDatos.getClientes().get(19), BaseDeDatos.getFestivales().get(2),
				TipoEntrada.CONCAMPING, 25, 264);
		Entrada e10 = new EntradaConCamping(BaseDeDatos.getClientes().get(20), BaseDeDatos.getFestivales().get(3),
				TipoEntrada.CONCAMPING, 25.50, 768);
		Entrada e11 = new Entrada(BaseDeDatos.getClientes().get(21), BaseDeDatos.getFestivales().get(4),
				TipoEntrada.NORMAL);
		Entrada e12 = new EntradaVIP(BaseDeDatos.getClientes().get(22), BaseDeDatos.getFestivales().get(5),
				TipoEntrada.VIP, 50, 01);
		Entrada e13 = new EntradaVIP(BaseDeDatos.getClientes().get(23), BaseDeDatos.getFestivales().get(0),
				TipoEntrada.VIP, 65, 03);
		Entrada e14 = new EntradaConCamping(BaseDeDatos.getClientes().get(24), BaseDeDatos.getFestivales().get(1),
				TipoEntrada.CONCAMPING, 28, 142);
		Entrada e15 = new EntradaConCamping(BaseDeDatos.getClientes().get(25), BaseDeDatos.getFestivales().get(2),
				TipoEntrada.CONCAMPING, 29.25, 1879);

		Entrada e16 = new Entrada(BaseDeDatos.getClientes().get(1), BaseDeDatos.getFestivales().get(4),
				TipoEntrada.NORMAL);
		Entrada e17 = new Entrada(BaseDeDatos.getClientes().get(24), BaseDeDatos.getFestivales().get(3),
				TipoEntrada.NORMAL);
		Entrada e18 = new EntradaConCamping(BaseDeDatos.getClientes().get(13), BaseDeDatos.getFestivales().get(2),
				TipoEntrada.CONCAMPING, 39, 045);
		Entrada e19 = new EntradaConCamping(BaseDeDatos.getClientes().get(7), BaseDeDatos.getFestivales().get(1),
				TipoEntrada.CONCAMPING, 45, 236);
		Entrada e20 = new EntradaVIP(BaseDeDatos.getClientes().get(4), BaseDeDatos.getFestivales().get(0),
				TipoEntrada.VIP, 70, 06);
		Entrada e21 = new EntradaVIP(BaseDeDatos.getClientes().get(36), BaseDeDatos.getFestivales().get(1),
				TipoEntrada.VIP, 60, 34);

		ArrayList<Entrada> entradas = new ArrayList<>();

		entradas.add(e1);
		entradas.add(e2);
		entradas.add(e3);
		entradas.add(e4);
		entradas.add(e5);
		entradas.add(e6);
		entradas.add(e7);
		entradas.add(e8);
		entradas.add(e9);
		entradas.add(e10);
		entradas.add(e11);
		entradas.add(e12);
		entradas.add(e13);
		entradas.add(e14);
		entradas.add(e15);

		entradas.add(e16);
		entradas.add(e17);
		entradas.add(e18);
		entradas.add(e19);
		entradas.add(e20);
		entradas.add(e21);

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);

			for (Entrada e : entradas) {
				int codC = e.getCliente().getCod();
				int codF = e.getFestival().getCodigoF();
				TipoEntrada tipoE = e.getTipoE();

				if (tipoE.equals(TipoEntrada.NORMAL)) {
					String sent = "INSERT INTO entradas (codC, codF, tipo, suplemento_c, parcela, suplemento_v, num_zona) VALUES ( "
							+ codC + " , " + codF + " , " + 0 + " , " + null + " , " + null + " , " + null + " , "
							+ null + ");";

					logger.log(Level.INFO, "Statement: " + sent);
					statement.executeUpdate(sent);

				} else if (tipoE.equals(TipoEntrada.CONCAMPING)) {

					EntradaConCamping ec = (EntradaConCamping) e;
					double suplementoC = ec.getSuplementoCamping();
					int parcela = ec.getParcela();
					String sent = "INSERT INTO entradas (codC, codF, tipo, suplemento_c, parcela, suplemento_v, num_zona) VALUES ( "
							+ codC + " , " + codF + " , " + 1 + " , " + suplementoC + " , " + parcela + " , " + null
							+ " , " + null + ");";

					logger.log(Level.INFO, "Statement: " + sent);
					statement.executeUpdate(sent);

				} else if (tipoE.equals(TipoEntrada.VIP)) {
					EntradaVIP ev = (EntradaVIP) e;
					double suplementoV = ev.getSuplementoVIP();
					int numZona = ev.getNumZonaVIP();
					String sent = "INSERT INTO entradas (codC, codF, tipo, suplemento_c, parcela, suplemento_v, num_zona) VALUES ( "
							+ codC + " , " + codF + " , " + 2 + " , " + null + " , " + null + " , " + suplementoV
							+ " , " + numZona + ");";

					logger.log(Level.INFO, "Statement: " + sent);
					statement.executeUpdate(sent);

				}
			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);

		}

	}

	public static void insertarEntrada(Entrada e) {

		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			if (e.getTipoE().equals(TipoEntrada.NORMAL)) {
				String sent = "INSERT INTO entradas (codC, codF, tipo)" + " VALUES ( " + e.getCliente().getCod() + ","
						+ e.getFestival().getCodigoF() + "," + 0 + ");";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

			} else if (e.getTipoE().equals(TipoEntrada.VIP)) {
				EntradaVIP ev = (EntradaVIP) e;
				String sent = "INSERT INTO entradas (codC, codF, tipo, suplemento_v, num_zona)" + " VALUES ( "
						+ ev.getCliente().getCod() + "," + ev.getFestival().getCodigoF() + "," + 2 + ","
						+ ev.getSuplementoVIP() + "," + ev.getNumZonaVIP() + ");";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);

			} else if (e.getTipoE().equals(TipoEntrada.CONCAMPING)) {
				EntradaConCamping ec = (EntradaConCamping) e;
				String sent = "INSERT INTO entradas (codC, codF, tipo, suplemento_c , parcela)" + " VALUES ( "
						+ ec.getCliente().getCod() + "," + ec.getFestival().getCodigoF() + "," + 1 + ","
						+ ec.getSuplementoCamping() + "," + ec.getParcela() + ");";
				logger.log(Level.INFO, "Statement: " + sent);
				statement.executeUpdate(sent);
			}

		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Excepción", ex);
		}

	}

	// INSERTAR CLIENTE ---- VENTANA REGISTRO
	/**
	 * Metodo para insertar usuarios:
	 * 
	 * @param nombre       nombre del cliente
	 * @param apellido     apellido del cliente
	 * @param dni          dni del cliente
	 * @param correo       correo del cliente
	 * @param contrasena   contraseña del cliente
	 * @param direccion    direccion del cliente
	 * @param edad         edad del cliente
	 * @param codigoPostal codigo postal del cliente
	 */
	public static void insertarUsuario(String nombre, String apellido, String dni, String correo, String contrasena,
			String direccion, int edad, int codigoPostal) {
		try (Statement statement = con.createStatement()) {
			abrirConexion("BaseDatos.db", false);
			int tipo = 0;

			String sent = "INSERT INTO user (nombre, apellido, dni, correo, contrasena, tipo, direccion, edad, codigoP) "
					+ " VALUES ( '" + nombre + "', '" + apellido + "', '" + dni + "','" + correo + "','" + contrasena
					+ "'," + tipo + ",'" + direccion + "'," + edad + " ," + codigoPostal + ");";
			logger.log(Level.INFO, "Statement: " + sent);

			statement.executeUpdate(sent);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepción", e);
		}
	}

	///////////////////////////////////////////////////

	/**
	 * 
	 * @param festival
	 * @return
	 */
	public static Festival getFestival(Festival festival) {
		Festival f = new Festival();
		try {
			abrirConexion("BaseDatos.db", false);
			for (Festival fest : BaseDeDatos.getFestivales()) {
				if (fest.getCodigoF() == festival.getCodigoF()) {
					f.setCodigoF(festival.getCodigoF());
					f.setNombre(festival.getNombre());
					f.setLugar(festival.getLugar());
					f.setFecha(festival.getFecha());
					f.setDescripcion(festival.getDescripcion());
					f.setPrecio(festival.getPrecio());
					f.setFoto(festival.getFoto());
					ArrayList<Concierto> conciertos = new ArrayList<>();
					for (Concierto concierto : BaseDeDatos.getConciertos()) {
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

	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public static Festival getFestNom(String nombre) {
		Festival f = new Festival();
		try {
			abrirConexion("BaseDatos.db", false);
			for (Festival fest : BaseDeDatos.getFestivales()) {
				if (fest.getNombre().equals(nombre)) {
					f.setCodigoF(fest.getCodigoF());
					f.setNombre(fest.getNombre());
					f.setLugar(fest.getLugar());
					f.setFecha(fest.getFecha());
					f.setDescripcion(fest.getDescripcion());
					f.setPrecio(fest.getPrecio());
					f.setFoto(fest.getFoto());
					ArrayList<Concierto> conciertos = new ArrayList<>();
					for (Concierto concierto : BaseDeDatos.getConciertos()) {
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

	/**
	 * 
	 * @param nombreF
	 * @return
	 */
	public static String getFotoFest(String nombreF) {
		String fotoFestival = "";

		for (Festival festival : BaseDeDatos.getFestivales()) {
			if (festival.getNombre().equals(nombreF)) {
				fotoFestival += (festival.getFoto());
			}
		}
		return fotoFestival;

	}

	public static ArrayList<Entrada> search(String nomFest) {
		Festival fest = BaseDeDatos.getFestNom(nomFest);
		ArrayList<Entrada> entradas = new ArrayList<>();

		for (Entrada e : BaseDeDatos.getEntradas()) {
			if (e.getFestival().getNombre().equals(fest.getNombre())) {
				entradas.add(e);
			}
		}
		return entradas;
	}

	public static void borrarDatos(JTable tDatos) {
		try {
			DefaultTableModel mDatos = (DefaultTableModel) tDatos.getModel();
			int numFilas = tDatos.getRowCount();
			for (int i = 0; numFilas > i; i++) {
				mDatos.removeRow(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertarDatos(JTable tDatos, String nomFest) {
		try {
			DefaultTableModel mDatos = (DefaultTableModel) tDatos.getModel();
			for (Entrada en : BaseDeDatos.search(nomFest)) {
				mDatos.addRow(
						new Object[] { en.getCliente().getNombre(), en.getCliente().getDni(), en.getCliente().getEdad(),
								en.getTipoE(), en.getFestival().getPrecio(), BaseDeDatos.getPrecioTotal(en) });

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getMediaEdad(JTable t) {
		ArrayList<Object> edades = new ArrayList<>();
		for (int i = 0; i < t.getRowCount(); i++) {
			Object edad = t.getValueAt(i, 2);
			edades.add(edad);
		}
		double sumatorio = 0;
		int divisor = 0;
		for (Object e : edades) {
			sumatorio += Double.valueOf((Integer) e);
			divisor += 1;
		}
		int mediaE = (int) (sumatorio / divisor);
		return String.valueOf(mediaE);

	}

	public static String calculoTotalE(JTable t, TipoEntrada tipoE) {
		int entradas = 0;
		if (tipoE.equals(TipoEntrada.NORMAL)) {
			for (int i = 0; i < t.getRowCount(); i++) {
				entradas += 1;
			}
		} else if (tipoE.equals(TipoEntrada.VIP)) {
			for (int i = 0; i < t.getRowCount(); i++) {
				if (t.getValueAt(i, 3).equals(tipoE)) {
					entradas += 1;
				}
			}
		} else if (tipoE.equals(TipoEntrada.CONCAMPING)) {
			for (int i = 0; i < t.getRowCount(); i++) {
				if (t.getValueAt(i, 3).equals(tipoE)) {
					entradas += 1;
				}
			}
		}
		return String.valueOf(entradas);

	}

	public static ArrayList<Integer> recalcularTabla(JTable t, String edadMin, String edadMax, String minPrecio,
			String maxPrecio) {
		// System.out.println(edadMin);
		int minE = Integer.parseInt(edadMin);
		int maxE = Integer.parseInt(edadMax);
		double minP = Double.parseDouble(minPrecio);
		double maxP = Double.parseDouble(maxPrecio);

		ArrayList<Integer> filas = new ArrayList<>();

		for (int i = 0; i < t.getRowCount(); i++) {
			if ((Integer) t.getValueAt(i, 2) >= minE
					&& (Integer) t.getValueAt(i, 2) <= maxE
					&& (Double) t.getValueAt(i, 5) >= minP
					&& (Double) t.getValueAt(i, 5) <= maxP) {
				filas.add(i);
			}
		}
		return filas;
	}

	public static Entrada crearEntrada(Festival f, Cliente c, TipoEntrada tipoE) {
		Entrada e = new Entrada();
		if (tipoE.equals(TipoEntrada.NORMAL)) {
			e = new Entrada(c, f, tipoE);

		} else {
			double suplemento = f.getPrecio() * 0.2;

			Random numAleatorio = new Random();
			int zonaVip = numAleatorio.nextInt(10 - 1 + 1) + 1;

			e = new EntradaVIP(c, f, tipoE, suplemento, zonaVip);

		}
		BaseDeDatos.insertarEntrada(e);
		return e;
	}

	public static Entrada crearEntradaConCamping(Festival f, Cliente c, Random r) {
		double suplemento = f.getPrecio() * 0.15;

		ArrayList<EntradaConCamping> entradasC = new ArrayList<>();
		for (Entrada e : BaseDeDatos.getEntradas()) {
			if (e.getTipoE().equals(TipoEntrada.CONCAMPING)) {
				entradasC.add((EntradaConCamping) e);
			}

		}
		int p = 0;
		for (EntradaConCamping eC : entradasC) {
			p += r.nextInt(2000 - 10 + 1) + 10;
			if (eC.getParcela() == p) {
				return crearEntradaConCamping(f, c, r);
			}
		}
		Entrada e = new EntradaConCamping(c, f, TipoEntrada.CONCAMPING, suplemento, p);
		BaseDeDatos.insertarEntrada(e);
		return e;

	}

}
