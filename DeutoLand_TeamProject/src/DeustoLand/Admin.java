package DeustoLand;

public class Admin extends User{
	
	private String identificador;

	
	public Admin(String nombre, String apellido, String dni, String identificador) {
		super(nombre, apellido, dni);
		this.identificador = identificador;
	}


	public Admin(String nombre, String apellido, String dni) {
		super(nombre, apellido, dni);
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
