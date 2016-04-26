package transporte;

/**
 * Clase derivada de colectivo, que representa los coches cama
 * @author Usuario
 *
 */
public class Cama extends Colectivo{

	//COSTO ADICIONAL POR ELEGIR CAMA
	private static final double ADICIONAL_CAMA = 100;
	private int ocupadoComun;
	
	public Cama(String patente, int velocidad) {
		super(patente, velocidad);
		// TODO Auto-generated constructor stub
	}
	
	/*GETTERS & SETTERS*/


	public void setCapacidad() {
		this.capacidad = 32;
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public int getOcupadoComun() {
		return ocupadoComun;
	}

	public void setOcupadoComun(int ocupadoComun) {
		this.ocupadoComun = ocupadoComun;
	}

	public static double getAdicionalCama() {
		return ADICIONAL_CAMA;
	}
	public double getCosto(){
		return 0;
	}

	public double getPrecioKM(){
		return (getOcupado()+ocupadoComun)*getPrecio()+getOcupado()*ADICIONAL_CAMA*getPrecio();
	}
}
