package DeustoLand;

public class Admin extends User {
	
	private String fechaUltimaMod;

	public Admin(int cod, String nombre, String apellido, String dni, String correo, String contrasena,
			String fechaUltimaMod) {
		super(cod, nombre, apellido, dni, correo, contrasena);
		this.fechaUltimaMod = fechaUltimaMod;
	}
	
	
	public Admin(String nombre, String apellido, String dni, String correo, String contrasena,
			String fechaUltimaMod) {
		super(nombre, apellido, dni, correo, contrasena);
		this.fechaUltimaMod = fechaUltimaMod;
	}


	public Admin() {
		super();
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