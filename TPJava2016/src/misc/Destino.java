package misc;

public class Destino {
	
	private String ciudad;
	private int kilometros;
	
	public Destino(String ciudad, int kilometros) {
		super();
		this.ciudad = ciudad;
		this.kilometros = kilometros;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getKilometros() {
		return kilometros;
	}
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}
	
	
}
