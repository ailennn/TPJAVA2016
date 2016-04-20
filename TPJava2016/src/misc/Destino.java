package misc;

public class Destino {
	
	private String ciudad;
	private int kilometros;
	private int contador=0;// cada vez que se cree un viaje con un destino, incrementar en 1 el contador (es para ponerlenombre al viaje)
	
	public Destino(String ciudad, int kilometros, int contador) {
		super();
		this.ciudad = ciudad;
		this.kilometros = kilometros;
		this.contador = contador;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
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
