package transporte;

public abstract class Transporte {
	
	private String patente;
	private double velocidad;
	
	public Transporte(String patente, double velocidad) {
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

	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	
	public int getOcupadoCama() {
		return 0;
	}

	public void setOcupadoCama(int ocupadoCama) {}

	public int getOcupadoComun() {
		return 0;
	}

	public void setOcupadoComun(int ocupadoComun) {}
	
	public double getPrecioKM(){ return 0;}
	/**
	 * getPrecioKM() devuelve el precio x km, en los casos que corresponda, lo
	 * multiplica por la cantidad de pasajeros (todos menos auto)
	 */
	
	public double getCosto(){return 0;}
	/**
	 * getCosto() devuelve el precio base, en caso de que no lo haya devuelve 0 (en colectivos)
	 */
}
