package transporte;

/**
 * Clase derivada de colectivo, que representa los coches semi cama
 * @author Usuario
 *
 */
public class SemiCama extends Colectivo{

	public SemiCama(String patente, int velocidad) {
		super(patente, velocidad);
		// TODO Auto-generated constructor stub
	}


	/*GETTERS & SETTERS*/
	public void setCapacidad() {
		this.capacidad = 40;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public double getCosto(){
		return 0;
	}
	
	public double getPrecioKm() {
		return getOcupado()*getPrecio();
	}
}
