package transporte;

/**
 * Clase abstracta que representa los distintos transportes
 * Contiene los atributos generales
 * @author Usuario
 *
 */
public abstract class Transporte {
	
	private String patente;
	private int velocidad;
	private int ocupado;
	protected int capacidad;
	
	

	public Transporte(String patente, int velocidad) {
		super();
		this.patente = patente;
		this.velocidad = velocidad;
	}
	
	public int getCapacidad() {
		return 0;
	}

	public void setCapacidad() {
		this.capacidad = 0;
	}

	public int getOcupado() {
		return ocupado;
	}
	/**
	 * Para el caso de Cama, ocuapdo es la cantidad de camas ocupadas
	 * @param ocupado
	 */
	public void setOcupado(int ocupado) {
		this.ocupado = ocupado;
	}
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}

	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

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
