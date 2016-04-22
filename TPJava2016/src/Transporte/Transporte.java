package transporte;

public abstract class Transporte {
	
	private String patente;
	private float velocidad;
	
	public Transporte(String patente, float velocidad) {
		super();
		this.patente = patente;
		this.velocidad = velocidad;
	}

	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}

	public float getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	
		/**
	 * getPrecioKM() devuelve el precio x km, en los casos que corresponda, lo
	 * multiplica por la cantidad de pasajeros (todos menos auto)
	 */
	
	public float getPrecioKM(){ return 0;}

		/**
	 * getCosto() devuelve el precio base, en caso de que no lo haya devuelve 0 (en colectivos)
	 */
	
	public float getCosto(){return 0;}

}
