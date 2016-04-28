package transporte;

/**
 * Clase derivada de transporte, que representa los autos
 * @author Usuario
 *
 */
public class Auto extends Transporte{

	private static final double PRECIO_BASE = 40;
	private static final double PRECIO_KM = 2;
	

	public Auto(String patente, int velocidad) {
		super(patente, velocidad);
		// TODO Auto-generated constructor stub
	}

	public double getPrecioKm() {
		return PRECIO_KM;
	}
	
	public double getCosto(){
		return PRECIO_BASE;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public void setCapacidad() {
		this.capacidad = 4;
	}

}
