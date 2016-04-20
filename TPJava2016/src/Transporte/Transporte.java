package transporte;

public abstract class Transporte {
	
	private String patente;
	private int capacidad;
	private float velocidad;
	
	public Transporte(String patente, int capacidad, float velocidad) {
		super();
		this.patente = patente;
		this.capacidad = capacidad;
		this.velocidad = velocidad;
	}

	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public float getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	
	public float getPrecioKM(){ return 0;	
	}
	public float getCosto(){return 0;}
}
