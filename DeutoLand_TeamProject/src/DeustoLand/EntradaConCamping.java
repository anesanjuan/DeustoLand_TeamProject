package DeustoLand;

public class EntradaConCamping extends User{
	
	private int suplementoCamping;
	private int parcela;
	
	
	public EntradaConCamping(String nombre, String apellido, String dni, int suplementoCamping, int parcela) {
		super(nombre, apellido, dni);
		this.suplementoCamping = suplementoCamping;
		this.parcela = parcela;
	}


	public EntradaConCamping(String nombre, String apellido, String dni) {
		super(nombre, apellido, dni);
	}


	public int getSuplementoCamping() {
		return suplementoCamping;
	}


	public void setSuplementoCamping(int suplementoCamping) {
		this.suplementoCamping = suplementoCamping;
	}


	public int getParcela() {
		return parcela;
	}


	public void setParcela(int parcela) {
		this.parcela = parcela;
	}


	@Override
	public String toString() {
		return "EntradaConCamping [suplementoCamping=" + suplementoCamping + ", parcela=" + parcela + "]";
	}
	
	
	
	

}
