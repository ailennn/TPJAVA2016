package Transporte;

public abstract class Transporte {
	
	String patente;
	int capacidad;
	float velocidad;
	
	
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
	
	
}
