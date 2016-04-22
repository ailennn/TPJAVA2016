package misc;

public class Destino {
	
	private String ciudad;
	private int kilometros;
	private int contador;// cada vez que se cree un viaje con un destino, incrementar en 1 el contador (es para ponerle nombre al viaje)
	
	public Destino(String ciudad, int kilometros) {
		super();
		this.ciudad = ciudad;
		this.kilometros = kilometros;
		this.contador = 0;
	}
	public int getContador() {
		return contador;
	}
	public void setContador() {
		this.contador++;
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
