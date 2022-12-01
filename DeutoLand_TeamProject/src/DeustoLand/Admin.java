package DeustoLand;

public class Admin extends User {
	
	private String identificador;
	
	//fecha ultimo login
	
	//tbala usuario con lo comun + columna tipo (boolean, string.. para diferenciar), + columnas especificas de cada clase
	
	public Admin(String nombre, String apellido, String dni, String contrasena , String identificador) {
		super(nombre, apellido, dni, contrasena );
		this.identificador = identificador;
	}


	public Admin(String nombre, String apellido, String dni, String contrasena ) {
		super(nombre, apellido, dni, contrasena);
	}


	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	@Override
	public String toString() {
		return "Admin [identificador=" + identificador + "]";
	}
	
	

}
