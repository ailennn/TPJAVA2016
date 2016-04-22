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
	
	public int getOcupadoCama() {
		return 0;
	}

	public void setOcupadoCama(int ocupadoCama) {}

	public int getOcupadoComun() {
		return 0;
	}

	public void setOcupadoComun(int ocupadoComun) {}
	
	public float getPrecioKM(){ return 0;}
	/**
	 * getPrecioKM() devuelve el precio x km, en los casos que corresponda, lo
	 * multiplica por la cantidad de pasakeros (todos menos auto)
	 */
	
	public float getCosto(){return 0;}
	/**
	 * getCosto() devuelve el precio base, en caso de que no lo haya devuelve 0 (en colectivos)
	 */
}
