package DeustoLand;

public class Admin extends User {
	
	private String fechaUltimaMod;
	
	
	//tbala usuario con lo comun + columna tipo (boolean, string.. para diferenciar), + columnas especificas de cada clase
	
	public Admin(int cod, String nombre, String apellido, String dni, String contrasena , String fechaUltimaMod) {
		super(cod, nombre, apellido, dni, contrasena );
		this.fechaUltimaMod = fechaUltimaMod;
	}

	public String getFechaUltimaMod() {
		return fechaUltimaMod;
	}

	public void setFechaUltimaMod(String fechaUltimaMod) {
		this.fechaUltimaMod = fechaUltimaMod;
	}

	@Override
	public String toString() {
		return "Admin [fechaUltimaMod=" + fechaUltimaMod + "]";
	}
	
	
	


}